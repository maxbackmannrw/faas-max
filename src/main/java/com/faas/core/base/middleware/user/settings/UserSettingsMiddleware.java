package com.faas.core.base.middleware.user.settings;

import com.faas.core.base.framework.user.settings.UserSettingsFramework;
import com.faas.core.base.model.db.user.settings.UserRoleDBModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.user.settings.UserRoleWSModel;
import com.faas.core.base.model.ws.user.settings.dto.UserRoleWSDTO;
import com.faas.core.base.repo.user.settings.UserRoleRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserSettingsMiddleware {


    @Autowired
    UserSettingsFramework userSettingsFramework;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    AppUtils appUtils;


    public UserRoleWSModel getAllUserRoles(long userId) {

        UserRoleWSModel response = new UserRoleWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UserRoleWSDTO> userRoleWSDTOS = new ArrayList<>();

        List<UserRoleDBModel> userRoleDBModels = userRoleRepository.findByStatus(1);
        if (userRoleDBModels.size() > 0) {
            for (UserRoleDBModel userRoleDBModel : userRoleDBModels) {
                userRoleWSDTOS.add(userSettingsFramework.fillUserRoleWSDTO(userRoleDBModel));
            }
        }

        response.setUserRoles(userRoleWSDTOS);
        general.setOperation("getAllUserRoles");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UserRoleWSModel getUserRole(long userId, long roleId) {

        UserRoleWSModel response = new UserRoleWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UserRoleWSDTO> userRoleWSDTOS = new ArrayList<>();

        Optional<UserRoleDBModel> userRoleDBModel = userRoleRepository.findById(roleId);
        userRoleDBModel.ifPresent(roleDBModel -> userRoleWSDTOS.add(userSettingsFramework.fillUserRoleWSDTO(roleDBModel)));

        response.setUserRoles(userRoleWSDTOS);
        general.setOperation("getUserRole");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UserRoleWSModel createUserRole(long userId, String userRole, String userType) {

        UserRoleWSModel response = new UserRoleWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UserRoleWSDTO> userRoleWSDTOS = new ArrayList<>();

        UserRoleDBModel userRoleDBModel = userSettingsFramework.createUserRoleService(userRole, userType);
        if (userRoleDBModel != null) {
            userRoleWSDTOS.add(userSettingsFramework.fillUserRoleWSDTO(userRoleDBModel));
        }

        response.setUserRoles(userRoleWSDTOS);
        general.setOperation("createUserRole");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UserRoleWSModel updateUserRole(long userId, long roleId, String userRole, String userType) {

        UserRoleWSModel response = new UserRoleWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UserRoleWSDTO> userRoleWSDTOS = new ArrayList<>();

        UserRoleDBModel userRoleDBModel = userSettingsFramework.updateUserRoleService(roleId, userRole, userType);
        if (userRoleDBModel != null) {
            userRoleWSDTOS.add(userSettingsFramework.fillUserRoleWSDTO(userRoleDBModel));
        }

        response.setUserRoles(userRoleWSDTOS);
        general.setOperation("updateUserRole");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UserRoleWSModel removeUserRole(long userId, long roleId) {

        UserRoleWSModel response = new UserRoleWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UserRoleWSDTO> userRoleWSDTOS = new ArrayList<>();

        UserRoleDBModel userRoleDBModel = userSettingsFramework.removeUserRoleService(roleId);
        if (userRoleDBModel != null) {
            userRoleWSDTOS.add(userSettingsFramework.fillUserRoleWSDTO(userRoleDBModel));
        }

        response.setUserRoles(userRoleWSDTOS);
        general.setOperation("removeUserRole");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
