package com.faas.core.base.endpoint.controller.remote.content;

import com.faas.core.base.middleware.remote.content.RemoteDetailsMiddleware;
import com.faas.core.base.model.ws.remote.client.ClientRemoteListWSModel;
import com.faas.core.base.model.ws.remote.content.RemoteDataWSModel;
import com.faas.core.base.model.ws.remote.content.RemoteDetailsWSModel;
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
    RemoteDetailsMiddleware remoteDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_REMOTE_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteDetails(@RequestParam long userId,
                                              @RequestParam String remoteId) {

        RemoteDetailsWSModel response = remoteDetailsMiddleware.getRemoteDetails(userId,remoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_REMOTE_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteDatas(@RequestParam long userId,
                                            @RequestParam String remoteId) {

        RemoteDataWSModel response = remoteDetailsMiddleware.getRemoteDatas(userId,remoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTE_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteData(@RequestParam long userId,
                                           @RequestParam String remoteId,
                                           @RequestParam String dataId) {

        RemoteDataWSModel response = remoteDetailsMiddleware.getRemoteData(userId,remoteId,dataId);

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

        RemoteDataWSModel response = remoteDetailsMiddleware.createRemoteData(userId,remoteId,typeId,value);

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

        RemoteDataWSModel response = remoteDetailsMiddleware.updateRemoteData(userId,remoteId,dataId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_REMOTE_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeRemoteData(@RequestParam long userId,
                                              @RequestParam String remoteId,
                                              @RequestParam String dataId) {

        RemoteDataWSModel response = remoteDetailsMiddleware.removeRemoteData(userId,remoteId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
