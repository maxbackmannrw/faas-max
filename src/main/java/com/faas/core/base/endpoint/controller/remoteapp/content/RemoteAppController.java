package com.faas.core.base.endpoint.controller.remoteapp.content;

import com.faas.core.base.middleware.remoteapp.content.RemoteAppMiddleware;
import com.faas.core.base.model.ws.remoteapp.content.RemoteAppListWSModel;
import com.faas.core.base.model.ws.remoteapp.content.RemoteAppWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/remoteapp/")
public class RemoteAppController {


    @Autowired
    RemoteAppMiddleware remoteAppMiddleware;


    @RequestMapping(value = BaseRoute.GET_REMOTE_APPS, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteApps(@RequestParam long userId,
                                           @RequestParam String appState,
                                           @RequestParam String baseType,
                                           @RequestParam int reqPage,
                                           @RequestParam int reqSize) {

        RemoteAppListWSModel response = remoteAppMiddleware.getRemoteApps(userId,appState,baseType,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CLIENT_REMOTE_APPS, method = RequestMethod.POST)
    public ResponseEntity<?> getClientRemoteApps(@RequestParam long userId,
                                                 @RequestParam long clientId) {

        RemoteAppListWSModel response = remoteAppMiddleware.getClientRemoteApps(userId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTE_APP, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteApp(@RequestParam long userId,
                                             @RequestParam String clientRemoteId) {

        RemoteAppWSModel response = remoteAppMiddleware.getRemoteApp(userId,clientRemoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_REMOTE_APP, method = RequestMethod.POST)
    public ResponseEntity<?> createRemoteApp(@RequestParam long userId,
                                                @RequestParam String operationId,
                                                @RequestParam String remoteId) {

        RemoteAppWSModel response = remoteAppMiddleware.createRemoteApp(userId,operationId,remoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_REMOTE_APP, method = RequestMethod.POST)
    public ResponseEntity<?> updateRemoteApp(@RequestParam long userId,
                                                @RequestParam String clientRemoteId,
                                                @RequestParam String remoteState) {

        RemoteAppWSModel response = remoteAppMiddleware.updateRemoteApp(userId,clientRemoteId,remoteState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_REMOTE_APP, method = RequestMethod.POST)
    public ResponseEntity<?> removeRemoteApp(@RequestParam long userId,
                                                @RequestParam String clientRemoteId) {

        RemoteAppWSModel response = remoteAppMiddleware.removeRemoteApp(userId,clientRemoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
