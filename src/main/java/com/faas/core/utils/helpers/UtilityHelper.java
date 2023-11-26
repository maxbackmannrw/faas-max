package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.model.db.user.settings.UserRoleDBModel;
import com.faas.core.base.model.ws.utility.system.dto.SystemInitWSDTO;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.base.repo.user.settings.UserRoleRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UtilityHelper {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    AppUtils appUtils;


    public SystemInitWSDTO firstInitSystemHelper(String initType){

        if (initType.equalsIgnoreCase(AppConstant.FIRST_TIME_INIT)){
            checkUserRolesAndResetHelper();
            initializeUserRolesHelper();
            checkManagerUsersAndResetHelper();
            initializeManagerUsersHelper();
        }
        return null;
    }


    public void checkUserRolesAndResetHelper(){

        if (userRoleRepository.count()>0){
            userRoleRepository.deleteAll(userRoleRepository.findAll());
        }
    }

    public void initializeUserRolesHelper(){
        userRoleRepository.save(createUserRoleModelHelper(AppConstant.SUPER_MANAGER,AppConstant.MANAGER_USER));
        userRoleRepository.save(createUserRoleModelHelper(AppConstant.BASIC_MANAGER,AppConstant.MANAGER_USER));
        userRoleRepository.save(createUserRoleModelHelper(AppConstant.BASIC_AGENT,AppConstant.AGENT_USER));
        userRoleRepository.save(createUserRoleModelHelper(AppConstant.SUPER_AGENT,AppConstant.AGENT_USER));
        userRoleRepository.save(createUserRoleModelHelper(AppConstant.AUTO_AGENT,AppConstant.AGENT_USER));
    }

    public UserRoleDBModel createUserRoleModelHelper(String userRole,String userType){

        UserRoleDBModel userRoleDBModel = new UserRoleDBModel();
        userRoleDBModel.setUserRole(userRole);
        userRoleDBModel.setUserType(userType);
        userRoleDBModel.setuDate(appUtils.getCurrentTimeStamp());
        userRoleDBModel.setcDate(appUtils.getCurrentTimeStamp());
        userRoleDBModel.setStatus(1);

        return userRoleDBModel;
    }



    public void checkManagerUsersAndResetHelper(){

        List<UserDBModel> managerUsers = userRepository.findByUserType(AppConstant.MANAGER_USER);
        if (!managerUsers.isEmpty()){
            userRepository.deleteAll(managerUsers);
            for (UserDBModel managerUser : managerUsers) {
                userDetailsRepository.deleteAll(userDetailsRepository.findByUserId(managerUser.getId()));
            }
        }
    }

    public void initializeManagerUsersHelper(){

        createUserHelper(AppConstant.DEFAULT_MANAGER_NAME, AppConstant.DEFAULT_MANAGER_EMAIL, AppConstant.DEFAULT_MANAGER_EMAIL,AppConstant.SUPER_MANAGER );
    }

    public void createUserHelper(String userName,String userEmail,String password,String userRole){

        List<UserRoleDBModel> userRoleDBModels = userRoleRepository.findByUserRole(userRole);
        if (!userRoleDBModels.isEmpty()){

            UserDBModel userDBModel = new UserDBModel();
            userDBModel.setUserName(userName);
            userDBModel.setUserEmail(userEmail.toLowerCase());
            userDBModel.setPassword(appUtils.base64Encoder(password));
            userDBModel.setRoleId(userRoleDBModels.get(0).getId());
            userDBModel.setUserRole(userRoleDBModels.get(0).getUserRole());
            userDBModel.setUserType(userRoleDBModels.get(0).getUserType());
            userDBModel.setValidUser(true);
            userDBModel.setuDate(appUtils.getCurrentTimeStamp());
            userDBModel.setcDate(appUtils.getCurrentTimeStamp());
            userDBModel.setStatus(1);

            createUserDetailsModel(userRepository.save(userDBModel));
        }
    }

    public void createUserDetailsModel(UserDBModel userDBModel){

        UserDetailsDBModel userDetailsDBModel = new UserDetailsDBModel();
        userDetailsDBModel.setUserId(userDBModel.getId());
        userDetailsDBModel.setUserDatas(new ArrayList<>());
        userDetailsDBModel.setuDate(appUtils.getCurrentTimeStamp());
        userDetailsDBModel.setcDate(appUtils.getCurrentTimeStamp());
        userDetailsDBModel.setStatus(1);

        userDetailsRepository.save(userDetailsDBModel);
    }



}
