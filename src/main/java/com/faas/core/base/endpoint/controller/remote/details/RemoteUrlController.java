package com.faas.core.base.endpoint.controller.remote.details;

import com.faas.core.base.middleware.remote.details.RemoteUrlMiddleware;
import com.faas.core.base.model.ws.remote.details.RemoteUrlWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/remote/url/")
public class RemoteUrlController {


    @Autowired
    RemoteUrlMiddleware remoteUrlMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_REMOTE_URLS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllRemoteUrls(@RequestParam long userId) {

        RemoteUrlWSModel response = remoteUrlMiddleware.getAllRemoteUrls(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTE_URLS, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteUrls(@RequestParam long userId,
                                           @RequestParam String remoteId) {

        RemoteUrlWSModel response = remoteUrlMiddleware.getRemoteUrls(userId,remoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTE_URL, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteUrl(@RequestParam long userId,
                                          @RequestParam long urlId) {

        RemoteUrlWSModel response = remoteUrlMiddleware.getRemoteUrl(userId,urlId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_REMOTE_URL, method = RequestMethod.POST)
    public ResponseEntity<?> createRemoteUrl(@RequestParam long userId,
                                             @RequestParam String remoteId,
                                             @RequestParam String remoteUrl,
                                             @RequestParam String urlType) {

        RemoteUrlWSModel response = remoteUrlMiddleware.createRemoteUrl(userId,remoteId,remoteUrl,urlType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_REMOTE_URL, method = RequestMethod.POST)
    public ResponseEntity<?> updateRemoteUrl(@RequestParam long userId,
                                             @RequestParam long urlId,
                                             @RequestParam String remoteId,
                                             @RequestParam String remoteUrl,
                                             @RequestParam String urlType) {

        RemoteUrlWSModel response = remoteUrlMiddleware.updateRemoteUrl(userId,urlId,remoteId,remoteUrl,urlType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_REMOTE_URL, method = RequestMethod.POST)
    public ResponseEntity<?> removeRemoteUrl(@RequestParam long userId,
                                             @RequestParam long urlId) {

        RemoteUrlWSModel response = remoteUrlMiddleware.removeRemoteUrl(userId,urlId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
