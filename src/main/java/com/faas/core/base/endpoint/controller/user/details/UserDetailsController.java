package com.faas.core.base.endpoint.controller.user.details;

import com.faas.core.base.middleware.user.details.UserDetailsMiddleware;
import com.faas.core.base.model.ws.user.details.UserDataWSModel;
import com.faas.core.base.model.ws.user.details.UserDetailsWSModel;
import com.faas.core.base.model.ws.user.details.UserSipChannelWSModel;
import com.faas.core.base.model.ws.user.details.UserWappChannelWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/user/details/")
public class UserDetailsController {


    @Autowired
    UserDetailsMiddleware userDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_USER_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getUserDetails(@RequestParam long userId,
                                            @RequestParam long selectedId) {

        UserDetailsWSModel response = userDetailsMiddleware.getUserDetails(userId,selectedId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_USER_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getUserDatas(@RequestParam long userId,
                                            @RequestParam long selectedId) {

        UserDataWSModel response = userDetailsMiddleware.getUserDatas(userId,selectedId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_USER_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getUserData(@RequestParam long userId,
                                         @RequestParam long selectedId,
                                         @RequestParam String dataId) {

        UserDataWSModel response = userDetailsMiddleware.getUserData(userId,selectedId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_USER_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createUserData(@RequestParam long userId,
                                            @RequestParam long selectedId,
                                            @RequestParam long dataTypeId,
                                            @RequestParam String value) {

        UserDataWSModel response = userDetailsMiddleware.createUserData(userId,selectedId,dataTypeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_USER_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateUserData(@RequestParam long userId,
                                            @RequestParam long selectedId,
                                            @RequestParam String dataId,
                                            @RequestParam long dataTypeId,
                                            @RequestParam String value) {

        UserDataWSModel response = userDetailsMiddleware.updateUserData(userId,selectedId,dataId,dataTypeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_USER_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeUserData(@RequestParam long userId,
                                            @RequestParam long selectedId,
                                            @RequestParam String dataId) {

        UserDataWSModel response = userDetailsMiddleware.removeUserData(userId,selectedId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_USER_SIP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> getUserSipChannel(@RequestParam long userId,
                                               @RequestParam long selectedId) {

        UserSipChannelWSModel response = userDetailsMiddleware.getUserSipChannel(userId,selectedId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_USER_SIP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> createUserSipChannel(@RequestParam long userId,
                                                  @RequestParam long selectedId,
                                                  @RequestParam String accountId) {

        UserSipChannelWSModel response = userDetailsMiddleware.createUserSipChannel(userId,selectedId,accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_USER_SIP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> removeUserSipChannel(@RequestParam long userId,
                                                  @RequestParam long selectedId) {

        UserSipChannelWSModel response = userDetailsMiddleware.removeUserSipChannel(userId,selectedId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_USER_WAPP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> getUserWappChannel(@RequestParam long userId,
                                                @RequestParam long selectedId) {

        UserWappChannelWSModel response = userDetailsMiddleware.getUserWappChannel(userId,selectedId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_USER_WAPP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> createUserWappChannel(@RequestParam long userId,
                                                   @RequestParam long selectedId,
                                                   @RequestParam String accountId) {

        UserWappChannelWSModel response = userDetailsMiddleware.createUserWappChannel(userId,selectedId,accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_USER_WAPP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> removeUserWappChannel(@RequestParam long userId,
                                                   @RequestParam long selectedId) {

        UserWappChannelWSModel response = userDetailsMiddleware.removeUserWappChannel(userId,selectedId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
