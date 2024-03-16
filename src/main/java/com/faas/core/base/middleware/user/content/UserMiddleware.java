package com.faas.core.base.middleware.user.content;

import com.faas.core.base.framework.user.content.UserFramework;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.user.content.UserWSModel;
import com.faas.core.base.model.ws.user.content.dto.UserWSDTO;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserMiddleware {


    @Autowired
    UserFramework userFramework;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppUtils appUtils;


    public UserWSModel managerLogin(String userEmail, String password) {

        UserWSModel response = new UserWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UserWSDTO> userWSDTOS = new ArrayList<>();

        UserWSDTO userWSDTO = userFramework.managerLoginService(userEmail, password);
        if (userWSDTO != null) {
            userWSDTOS.add(userWSDTO);
        }

        response.setUsers(userWSDTOS);
        general.setOperation("managerLogin");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UserWSModel getAllUsers(long userId) {

        UserWSModel response = new UserWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UserWSDTO> userWSDTOS = new ArrayList<>();

        List<UserDBModel> userDBModels = userRepository.findByStatus(1);
        for (UserDBModel userDBModel : userDBModels) {
            userWSDTOS.add(userFramework.fillUserWSDTO(userDBModel));
        }

        response.setUsers(userWSDTOS);
        general.setOperation("getAllUsers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UserWSModel getUsersByType(long userId, String userType) {

        UserWSModel response = new UserWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UserWSDTO> userWSDTOS = new ArrayList<>();

        List<UserDBModel> userDBModels = userRepository.findByUserTypeAndStatus(userType, 1);
        for (UserDBModel userDBModel : userDBModels) {
            userWSDTOS.add(userFramework.fillUserWSDTO(userDBModel));
        }

        response.setUsers(userWSDTOS);
        general.setOperation("getUsersByType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UserWSModel getUser(long userId, long selectedId) {

        UserWSModel response = new UserWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UserWSDTO> userWSDTOS = new ArrayList<>();

        Optional<UserDBModel> userDBModel = userRepository.findById(selectedId);
        userDBModel.ifPresent(dbModel -> userWSDTOS.add(userFramework.fillUserWSDTO(dbModel)));

        response.setUsers(userWSDTOS);
        general.setOperation("getUser");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UserWSModel createUser(long userId, String userName, String userEmail, String password,long roleId,int operationLimit) {

        UserWSModel response = new UserWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UserWSDTO> userWSDTOS = new ArrayList<>();

        UserWSDTO userWSDTO = userFramework.createUserService(userName, userEmail, password, roleId, operationLimit);
        if (userWSDTO != null) {
            userWSDTOS.add(userWSDTO);
        }

        response.setUsers(userWSDTOS);
        general.setOperation("createUser");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UserWSModel updateUser(long userId, long selectedId, String userName, String userEmail, String password, long roleId, int operationLimit, boolean validUser) {

        UserWSModel response = new UserWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UserWSDTO> userWSDTOS = new ArrayList<>();

        UserWSDTO userWSDTO = userFramework.updateUserService(selectedId, userName, userEmail, password, roleId, operationLimit, validUser);
        if (userWSDTO != null) {
            userWSDTOS.add(userWSDTO);
        }

        response.setUsers(userWSDTOS);
        general.setOperation("updateUser");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UserWSModel removeUser(long userId, long selectedId) {

        UserWSModel response = new UserWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UserWSDTO> userWSDTOS = new ArrayList<>();

        UserWSDTO userWSDTO = userFramework.removeUserService(selectedId);
        if (userWSDTO != null) {
            userWSDTOS.add(userWSDTO);
        }

        response.setUsers(userWSDTOS);
        general.setOperation("removeUser");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
