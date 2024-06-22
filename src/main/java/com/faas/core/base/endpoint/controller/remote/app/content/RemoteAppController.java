package com.faas.core.base.endpoint.controller.remote.app.content;

import com.faas.core.base.middleware.remote.app.content.RemoteAppMiddleware;
import com.faas.core.base.model.ws.remote.app.content.RemoteClientListWSModel;
import com.faas.core.base.model.ws.remote.app.content.RemoteClientWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/remote/client/")
public class RemoteAppController {


    @Autowired
    RemoteAppMiddleware remoteAppMiddleware;


    @RequestMapping(value = BaseRoute.GET_REMOTE_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteClients(@RequestParam long userId,
                                              @RequestParam long clientId) {

        RemoteClientWSModel response = remoteAppMiddleware.getRemoteClients(userId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTE_CLIENTS_BY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteClientsByState(@RequestParam long userId,
                                                     @RequestParam String remoteState,
                                                     @RequestParam int reqPage,
                                                     @RequestParam int reqSize) {

        RemoteClientListWSModel response = remoteAppMiddleware.getRemoteClientsByState(userId,remoteState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTE_CLIENTS_BY_BASE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteClientsByBaseType(@RequestParam long userId,
                                                        @RequestParam String remoteState,
                                                        @RequestParam String baseType,
                                                        @RequestParam int reqPage,
                                                        @RequestParam int reqSize) {

        RemoteClientListWSModel response = remoteAppMiddleware.getRemoteClientsByBaseType(userId,remoteState,baseType,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CLIENT_REMOTE_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getClientRemoteClients(@RequestParam long userId,
                                                    @RequestParam long clientId) {

        RemoteClientWSModel response = remoteAppMiddleware.getRemoteClients(userId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTE_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteClient(@RequestParam long userId,
                                             @RequestParam String clientRemoteId) {

        RemoteClientWSModel response = remoteAppMiddleware.getRemoteClient(userId,clientRemoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_REMOTE_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> createRemoteClient(@RequestParam long userId,
                                                @RequestParam String operationId,
                                                @RequestParam String remoteId) {

        RemoteClientWSModel response = remoteAppMiddleware.createRemoteClient(userId,operationId,remoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_REMOTE_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> updateRemoteClient(@RequestParam long userId,
                                                @RequestParam String clientRemoteId,
                                                @RequestParam String remoteState) {

        RemoteClientWSModel response = remoteAppMiddleware.updateRemoteClient(userId,clientRemoteId,remoteState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_REMOTE_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> removeRemoteClient(@RequestParam long userId,
                                                @RequestParam String clientRemoteId) {

        RemoteClientWSModel response = remoteAppMiddleware.removeRemoteClient(userId,clientRemoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
