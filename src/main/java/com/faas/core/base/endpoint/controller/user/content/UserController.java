package com.faas.core.base.endpoint.controller.user.content;

import com.faas.core.base.middleware.user.content.UserMiddleware;
import com.faas.core.base.model.ws.user.content.UserWSModel;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/user/")
public class UserController {


    @Autowired
    UserMiddleware userMiddleware;


    @RequestMapping(value = BaseRoute.MANAGER_LOGIN, method = RequestMethod.POST)
    public ResponseEntity<?> managerLogin(@RequestParam String userEmail,
                                          @RequestParam String password) {

        UserWSModel response = userMiddleware.managerLogin(userEmail,password);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_ALL_USERS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllUsers(@RequestParam long userId) {

        UserWSModel response = userMiddleware.getAllUsers(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_USERS_BY_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getUsersByType(@RequestParam long userId,
                                            @RequestParam String userType) {

        UserWSModel response = userMiddleware.getUsersByType(userId, userType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_USER, method = RequestMethod.POST)
    public ResponseEntity<?> getUser(@RequestParam long userId,
                                     @RequestParam long selectedId) {

        UserWSModel response = userMiddleware.getUser(userId, selectedId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_USER, method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestParam long userId,
                                        @RequestParam String userName,
                                        @RequestParam String userEmail,
                                        @RequestParam String password,
                                        @RequestParam long roleId,
                                        @RequestParam int operationLimit) {

        UserWSModel response = userMiddleware.createUser(userId, userName, userEmail, password, roleId, operationLimit);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_USER, method = RequestMethod.POST)
    public ResponseEntity<?> updateUser(@RequestParam long userId,
                                        @RequestParam long selectedId,
                                        @RequestParam String userName,
                                        @RequestParam String userEmail,
                                        @RequestParam String password,
                                        @RequestParam long roleId,
                                        @RequestParam int operationLimit,
                                        @RequestParam boolean validUser) {

        UserWSModel response = userMiddleware.updateUser(userId, selectedId, userName, userEmail, password, roleId, operationLimit, validUser);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_USER, method = RequestMethod.POST)
    public ResponseEntity<?> removeUser(@RequestParam long userId,
                                        @RequestParam long selectedId) {

        UserWSModel response = userMiddleware.removeUser(userId, selectedId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
