package com.faas.core.base.endpoint.controller.remote.settings;

import com.faas.core.base.middleware.remote.settings.RemoteSettingsMiddleware;
import com.faas.core.base.model.ws.remote.client.ClientRemoteListWSModel;
import com.faas.core.base.model.ws.remote.settings.RemoteTypeWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/remote/settings/")
public class RemoteSettingsController {


    @Autowired
    RemoteSettingsMiddleware remoteSettingsMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_REMOTE_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllRemoteTypes(@RequestParam long userId) {

        RemoteTypeWSModel response = remoteSettingsMiddleware.getAllRemoteTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTE_TYPES_BY_BASE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteTypesByBaseType(@RequestParam long userId,
                                                      @RequestParam String baseType) {

        RemoteTypeWSModel response = remoteSettingsMiddleware.getRemoteTypesByBaseType(userId,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_REMOTE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteType(@RequestParam long userId,
                                           @RequestParam long remoteTypeId) {

        RemoteTypeWSModel response = remoteSettingsMiddleware.getRemoteType(userId,remoteTypeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_REMOTE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createRemoteType(@RequestParam long userId,
                                              @RequestParam String remoteType,
                                              @RequestParam String baseType) {

        RemoteTypeWSModel response = remoteSettingsMiddleware.createRemoteType(userId,remoteType,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_REMOTE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateRemoteType(@RequestParam long userId,
                                              @RequestParam long remoteTypeId,
                                              @RequestParam String remoteType,
                                              @RequestParam String baseType) {

        RemoteTypeWSModel response = remoteSettingsMiddleware.updateRemoteType(userId,remoteTypeId,remoteType,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_REMOTE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeRemoteType(@RequestParam long userId,
                                              @RequestParam long remoteTypeId) {

        RemoteTypeWSModel response = remoteSettingsMiddleware.removeRemoteType(userId,remoteTypeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
