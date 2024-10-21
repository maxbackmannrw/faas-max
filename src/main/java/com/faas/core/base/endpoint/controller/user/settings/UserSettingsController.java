package com.faas.core.base.endpoint.controller.user.settings;

import com.faas.core.base.middleware.user.settings.UserSettingsMiddleware;
import com.faas.core.base.model.ws.user.settings.UserRoleWSModel;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/user/settings/")
public class UserSettingsController {


    @Autowired
    UserSettingsMiddleware userSettingsMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_USER_ROLES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllUserRoles(@RequestParam long userId) {

        UserRoleWSModel response = userSettingsMiddleware.getAllUserRoles(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_USER_ROLE, method = RequestMethod.POST)
    public ResponseEntity<?> getUserRole(@RequestParam long userId,
                                         @RequestParam long roleId) {

        UserRoleWSModel response = userSettingsMiddleware.getUserRole(userId, roleId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_USER_ROLE, method = RequestMethod.POST)
    public ResponseEntity<?> createUserRole(@RequestParam long userId,
                                            @RequestParam String userRole,
                                            @RequestParam String userType) {

        UserRoleWSModel response = userSettingsMiddleware.createUserRole(userId, userRole, userType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_USER_ROLE, method = RequestMethod.POST)
    public ResponseEntity<?> updateUserRole(@RequestParam long userId,
                                            @RequestParam long roleId,
                                            @RequestParam String userRole,
                                            @RequestParam String userType) {

        UserRoleWSModel response = userSettingsMiddleware.updateUserRole(userId, roleId, userRole, userType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_USER_ROLE, method = RequestMethod.POST)
    public ResponseEntity<?> removeUserRole(@RequestParam long userId,
                                            @RequestParam long roleId) {

        UserRoleWSModel response = userSettingsMiddleware.removeUserRole(userId, roleId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
