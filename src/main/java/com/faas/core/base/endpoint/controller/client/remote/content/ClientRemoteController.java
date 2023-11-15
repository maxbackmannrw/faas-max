package com.faas.core.base.endpoint.controller.client.remote.content;

import com.faas.core.base.middleware.client.remote.content.ClientRemoteMiddleware;
import com.faas.core.base.model.ws.client.remote.content.ClientRemoteListWSModel;
import com.faas.core.base.model.ws.client.remote.content.ClientRemoteWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/client/remote/")
public class ClientRemoteController {


    @Autowired
    ClientRemoteMiddleware clientRemoteMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_CLIENT_REMOTES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllClientRemotes(@RequestParam long userId,
                                                 @RequestParam String remoteType,
                                                 @RequestParam String remoteState,
                                                 @RequestParam int reqPage,
                                                 @RequestParam int reqSize) {

        ClientRemoteListWSModel response = clientRemoteMiddleware.getAllClientRemotes(userId,remoteType,remoteState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CLIENT_REMOTES, method = RequestMethod.POST)
    public ResponseEntity<?> getClientRemotes(@RequestParam long userId,
                                                  @RequestParam long clientId) {

        ClientRemoteWSModel response = clientRemoteMiddleware.getClientRemotes(userId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CLIENT_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> getClientRemote(@RequestParam long userId,
                                             @RequestParam String remoteId) {

        ClientRemoteWSModel response = clientRemoteMiddleware.getClientRemote(userId,remoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CLIENT_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> createClientRemote(@RequestParam long userId,
                                                @RequestParam long sessionId,
                                                @RequestParam String deviceBrand,
                                                @RequestParam String deviceModel,
                                                @RequestParam String deviceOS,
                                                @RequestParam String deviceUrl,
                                                @RequestParam String remoteType,
                                                @RequestParam String remoteState) {

        ClientRemoteWSModel response = clientRemoteMiddleware.createClientRemote(userId,sessionId,deviceBrand,deviceModel,deviceOS,deviceUrl,remoteType,remoteState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CLIENT_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> updateClientRemote(@RequestParam long userId,
                                                @RequestParam long sessionId,
                                                @RequestParam String remoteId,
                                                @RequestParam String deviceBrand,
                                                @RequestParam String deviceModel,
                                                @RequestParam String deviceOS,
                                                @RequestParam String deviceUrl,
                                                @RequestParam String remoteState) {

        ClientRemoteWSModel response = clientRemoteMiddleware.updateClientRemote(userId,sessionId,remoteId,deviceBrand,deviceModel,deviceOS,deviceUrl,remoteState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CLIENT_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> removeClientRemote(@RequestParam long userId,
                                                @RequestParam String remoteId) {

        ClientRemoteWSModel response = clientRemoteMiddleware.removeClientRemote(userId,remoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
