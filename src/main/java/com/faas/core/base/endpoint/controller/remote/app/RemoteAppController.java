package com.faas.core.base.endpoint.controller.remote.app;

import com.faas.core.base.middleware.remote.app.RemoteAppMiddleware;
import com.faas.core.base.model.ws.remote.app.RemoteAppListWSModel;
import com.faas.core.base.model.ws.remote.app.RemoteAppWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/remote/app/")
public class RemoteAppController {


    @Autowired
    RemoteAppMiddleware remoteAppMiddleware;


    @RequestMapping(value = BaseRoute.GET_REMOTE_APPS, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteApps(@RequestParam long userId,
                                           @RequestParam String remoteState,
                                           @RequestParam int reqPage,
                                           @RequestParam int reqSize) {

        RemoteAppListWSModel response = remoteAppMiddleware.getRemoteApps(userId,remoteState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTE_APPS_BY_BASE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteAppsByBaseType(@RequestParam long userId,
                                                     @RequestParam String baseType,
                                                     @RequestParam String remoteState,
                                                     @RequestParam int reqPage,
                                                     @RequestParam int reqSize) {

        RemoteAppListWSModel response = remoteAppMiddleware.getRemoteAppsByBaseType(userId,baseType,remoteState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CLIENT_REMOTE_APPS, method = RequestMethod.POST)
    public ResponseEntity<?> getClientRemoteApps(@RequestParam long userId,
                                                 @RequestParam long clientId) {

        RemoteAppWSModel response = remoteAppMiddleware.getClientRemoteApps(userId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTE_APP, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteApp(@RequestParam long userId,
                                          @RequestParam String appId) {

        RemoteAppWSModel response = remoteAppMiddleware.getRemoteApp(userId,appId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_REMOTE_APP, method = RequestMethod.POST)
    public ResponseEntity<?> createRemoteApp(@RequestParam long userId,
                                             @RequestParam long sessionId,
                                             @RequestParam String remoteId) {

        RemoteAppWSModel response = remoteAppMiddleware.createRemoteApp(userId,sessionId,remoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_REMOTE_APP, method = RequestMethod.POST)
    public ResponseEntity<?> updateRemoteApp(@RequestParam long userId,
                                             @RequestParam String appId,
                                             @RequestParam String remoteId,
                                             @RequestParam String remoteState) {

        RemoteAppWSModel response = remoteAppMiddleware.updateRemoteApp(userId,appId,remoteId,remoteState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_REMOTE_APP, method = RequestMethod.POST)
    public ResponseEntity<?> removeRemoteApp(@RequestParam long userId,
                                             @RequestParam String appId) {

        RemoteAppWSModel response = remoteAppMiddleware.removeRemoteApp(userId,appId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
