package com.faas.core.base.framework.user.content;

import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.model.db.user.settings.UserRoleDBModel;
import com.faas.core.base.model.ws.user.content.dto.UserWSDTO;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.base.repo.user.settings.UserRoleRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.user.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserFramework {


    @Autowired
    UserHelper userHelper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    AppUtils appUtils;


    public UserWSDTO fillUserWSDTO(UserDBModel userDBModel) {

        UserWSDTO userWSDTO = new UserWSDTO();
        userWSDTO.setUser(userDBModel);
        List<UserDetailsDBModel> userDetailsDBModels = userDetailsRepository.findByUserId(userDBModel.getId());
        if (userDetailsDBModels.size()>0){
            userWSDTO.setUserDetails(userDetailsDBModels.get(0));
        }
        return userWSDTO;
    }


    public UserWSDTO managerLoginService(String userEmail, String password) {

        List<UserDBModel> userDBModels = userRepository.findByUserEmailAndPasswordAndUserTypeAndValidUser(userEmail.toLowerCase(), appUtils.base64Encoder(password), AppConstant.MANAGER_USER, true);
        if (userDBModels.size() > 0) {
            return fillUserWSDTO(userDBModels.get(0));
        }
        return null;
    }


    public UserWSDTO createUserService(String userName, String userEmail, String password, long roleId, int operationLimit) {

        Optional<UserRoleDBModel> userRoles = userRoleRepository.findById(roleId);
        if (userRoles.isPresent() && validateUserEmail(userEmail)) {

            UserDBModel userDBModel = new UserDBModel();
            userDBModel.setUserName(userName);
            userDBModel.setUserEmail(userEmail.toLowerCase());
            userDBModel.setPassword(appUtils.base64Encoder(password));
            userDBModel.setRoleId(roleId);
            userDBModel.setUserRole(userRoles.get().getUserRole());
            userDBModel.setUserType(userRoles.get().getUserType());
            userDBModel.setValidUser(true);
            userDBModel.setuDate(appUtils.getCurrentTimeStamp());
            userDBModel.setcDate(appUtils.getCurrentTimeStamp());
            userDBModel.setStatus(1);

            UserDBModel createdUser = userRepository.save(userDBModel);
            createUserDetailsService(createdUser,operationLimit);

            return fillUserWSDTO(createdUser);
        }
        return null;
    }


    public void createUserDetailsService(UserDBModel userDBModel,int operationLimit){

        UserDetailsDBModel userDetailsDBModel = new UserDetailsDBModel();
        userDetailsDBModel.setUserId(userDBModel.getId());
        userDetailsDBModel.setUserDatas(new ArrayList<>());
        userDetailsDBModel.setOperationLimit(operationLimit);
        userDetailsDBModel.setuDate(appUtils.getCurrentTimeStamp());
        userDetailsDBModel.setcDate(appUtils.getCurrentTimeStamp());
        userDetailsDBModel.setStatus(1);

        userDetailsRepository.save(userDetailsDBModel);
    }



    public UserWSDTO updateUserService(long selectedId, String userName, String userEmail, String password, long roleId, int operationLimit, boolean validUser) {

        Optional<UserRoleDBModel> userRoles = userRoleRepository.findById(roleId);
        Optional<UserDBModel> userDBModel = userRepository.findById(selectedId);
        List<UserDetailsDBModel> userDetailsDBModels = userDetailsRepository.findByUserId(selectedId);
        if (userDBModel.isPresent() && !userDetailsDBModels.isEmpty() && userRoles.isPresent()) {

            userDBModel.get().setUserName(userName);
            userDBModel.get().setUserEmail(userEmail.toLowerCase());
            userDBModel.get().setPassword(appUtils.base64Encoder(password));
            userDBModel.get().setRoleId(roleId);
            userDBModel.get().setUserRole(userRoles.get().getUserRole());
            userDBModel.get().setUserType(userRoles.get().getUserType());
            userDBModel.get().setValidUser(validUser);
            userDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            userDBModel.get().setcDate(appUtils.getCurrentTimeStamp());
            userDBModel.get().setStatus(1);

            UserDBModel updatedUser = userRepository.save(userDBModel.get());

            userDetailsDBModels.get(0).setOperationLimit(operationLimit);
            userDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            userDetailsRepository.save(userDetailsDBModels.get(0));

            return fillUserWSDTO(updatedUser);
        }
        return null;
    }


    public UserWSDTO removeUserService(long selectedId) {

        Optional<UserDBModel> userDBModel = userRepository.findById(selectedId);
        if (userDBModel.isPresent()) {

            userRepository.delete(userDBModel.get());
            userDetailsRepository.deleteAll(userDetailsRepository.findByUserId(selectedId));

            return fillUserWSDTO(userDBModel.get());
        }
        return null;
    }

    public boolean validateUserEmail(String userEmail) {
        List<UserDBModel> userDBModels = userRepository.findByUserEmail(userEmail.toLowerCase());
        return userDBModels.size() == 0;
    }


}
