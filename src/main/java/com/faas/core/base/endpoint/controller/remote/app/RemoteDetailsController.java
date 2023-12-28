package com.faas.core.base.endpoint.controller.remote.app;

import com.faas.core.base.middleware.remote.app.RemoteDetailsMiddleware;
import com.faas.core.base.model.ws.remote.app.RemoteDataWSModel;
import com.faas.core.base.model.ws.remote.app.RemoteDetailsWSModel;
import com.faas.core.base.model.ws.remote.app.RemoteUrlWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/remote/details/")
public class RemoteDetailsController {


    @Autowired
    RemoteDetailsMiddleware remoteAppDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_REMOTE_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteDetails(@RequestParam long userId,
                                              @RequestParam String remoteId) {

        RemoteDetailsWSModel response = remoteAppDetailsMiddleware.getRemoteDetails(userId,remoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_REMOTE_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteDatas(@RequestParam long userId,
                                            @RequestParam String remoteId) {

        RemoteDataWSModel response = remoteAppDetailsMiddleware.getRemoteDatas(userId,remoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTE_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteData(@RequestParam long userId,
                                           @RequestParam String remoteId,
                                           @RequestParam String dataId) {

        RemoteDataWSModel response = remoteAppDetailsMiddleware.getRemoteData(userId,remoteId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_REMOTE_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createRemoteData(@RequestParam long userId,
                                              @RequestParam String remoteId,
                                              @RequestParam long typeId,
                                              @RequestParam String value) {

        RemoteDataWSModel response = remoteAppDetailsMiddleware.createRemoteData(userId,remoteId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_REMOTE_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateRemoteData(@RequestParam long userId,
                                              @RequestParam String remoteId,
                                              @RequestParam String dataId,
                                              @RequestParam long typeId,
                                              @RequestParam String value) {

        RemoteDataWSModel response = remoteAppDetailsMiddleware.updateRemoteData(userId,remoteId,dataId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_REMOTE_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeRemoteData(@RequestParam long userId,
                                              @RequestParam String remoteId,
                                              @RequestParam String dataId) {

        RemoteDataWSModel response = remoteAppDetailsMiddleware.removeRemoteData(userId,remoteId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_REMOTE_URLS, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteUrls(@RequestParam long userId,
                                           @RequestParam String remoteId) {

        RemoteUrlWSModel response = remoteAppDetailsMiddleware.getRemoteUrls(userId,remoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTE_URL, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteUrl(@RequestParam long userId,
                                          @RequestParam String remoteId,
                                          @RequestParam String urlId) {

        RemoteUrlWSModel response = remoteAppDetailsMiddleware.getRemoteUrl(userId,remoteId,urlId);

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

        RemoteUrlWSModel response = remoteAppDetailsMiddleware.createRemoteUrl(userId,remoteId,remoteUrl,urlType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_REMOTE_URL, method = RequestMethod.POST)
    public ResponseEntity<?> updateRemoteUrl(@RequestParam long userId,
                                             @RequestParam String remoteId,
                                             @RequestParam String urlId,
                                             @RequestParam String remoteUrl,
                                             @RequestParam String urlType) {

        RemoteUrlWSModel response = remoteAppDetailsMiddleware.updateRemoteUrl(userId,remoteId,urlId,remoteUrl,urlType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_REMOTE_URL, method = RequestMethod.POST)
    public ResponseEntity<?> removeRemoteUrl(@RequestParam long userId,
                                             @RequestParam String remoteId,
                                             @RequestParam String urlId) {

        RemoteUrlWSModel response = remoteAppDetailsMiddleware.removeRemoteUrl(userId,remoteId,urlId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
