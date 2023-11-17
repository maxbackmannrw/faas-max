package com.faas.core.base.endpoint.controller.remote.content;

import com.faas.core.base.middleware.remote.content.RemoteMiddleware;
import com.faas.core.base.model.ws.remote.content.RemoteListWSModel;
import com.faas.core.base.model.ws.remote.content.RemoteWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/remote/")
public class RemoteController {


    @Autowired
    RemoteMiddleware remoteMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_REMOTES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllRemotes(@RequestParam long userId,
                                           @RequestParam String remoteType,
                                           @RequestParam String remoteState,
                                           @RequestParam int reqPage,
                                           @RequestParam int reqSize) {

        RemoteListWSModel response = remoteMiddleware.getAllRemotes(userId,remoteType,remoteState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CLIENT_REMOTES, method = RequestMethod.POST)
    public ResponseEntity<?> getClientRemotes(@RequestParam long userId,
                                              @RequestParam long clientId) {

        RemoteWSModel response = remoteMiddleware.getClientRemotes(userId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> getRemote(@RequestParam long userId,
                                       @RequestParam String remoteId) {

        RemoteWSModel response = remoteMiddleware.getRemote(userId,remoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> createRemote(@RequestParam long userId,
                                          @RequestParam long sessionId,
                                          @RequestParam String deviceBrand,
                                          @RequestParam String deviceModel,
                                          @RequestParam String deviceOS,
                                          @RequestParam String deviceUrl,
                                          @RequestParam String remoteType,
                                          @RequestParam String remoteState) {

        RemoteWSModel response = remoteMiddleware.createRemote(userId,sessionId,deviceBrand,deviceModel,deviceOS,deviceUrl,remoteType,remoteState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> updateRemote(@RequestParam long userId,
                                          @RequestParam long sessionId,
                                          @RequestParam String remoteId,
                                          @RequestParam String deviceBrand,
                                          @RequestParam String deviceModel,
                                          @RequestParam String deviceOS,
                                          @RequestParam String deviceUrl,
                                          @RequestParam String remoteState) {

        RemoteWSModel response = remoteMiddleware.updateRemote(userId,sessionId,remoteId,deviceBrand,deviceModel,deviceOS,deviceUrl,remoteState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> removeRemote(@RequestParam long userId,
                                          @RequestParam String remoteId) {

        RemoteWSModel response = remoteMiddleware.removeRemote(userId,remoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
