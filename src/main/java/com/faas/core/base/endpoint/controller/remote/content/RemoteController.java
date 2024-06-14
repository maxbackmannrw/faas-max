package com.faas.core.base.endpoint.controller.remote.content;

import com.faas.core.base.middleware.remote.content.RemoteMiddleware;
import com.faas.core.base.model.ws.remote.content.RemoteWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/remote/")
public class RemoteController {


    @Autowired
    RemoteMiddleware remoteMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_REMOTES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllRemotes(@RequestParam long userId) {

        RemoteWSModel response = remoteMiddleware.getAllRemotes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTES_BY_BASE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getRemotesByBaseType(@RequestParam long userId,
                                                  @RequestParam String baseType) {

        RemoteWSModel response = remoteMiddleware.getRemotesByBaseType(userId,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTES_BY_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getRemotesByType(@RequestParam long userId,
                                              @RequestParam String remoteType) {

        RemoteWSModel response = remoteMiddleware.getRemotesByType(userId,remoteType);

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
                                          @RequestParam String remote,
                                          @RequestParam String remoteDesc,
                                          @RequestParam String version,
                                          @RequestParam String sourceUrl,
                                          @RequestParam long typeId) {

        RemoteWSModel response = remoteMiddleware.createRemote(userId,remote,remoteDesc,version,sourceUrl,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> updateRemote(@RequestParam long userId,
                                          @RequestParam String remoteId,
                                          @RequestParam String remote,
                                          @RequestParam String remoteDesc,
                                          @RequestParam String version) {

        RemoteWSModel response = remoteMiddleware.updateRemote(userId,remoteId,remote,remoteDesc,version);

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
