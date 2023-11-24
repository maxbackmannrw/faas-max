package com.faas.core.base.endpoint.controller.remote.settings;

import com.faas.core.base.middleware.remote.settings.RemoteSettingsMiddleware;
import com.faas.core.base.model.ws.remote.content.RemoteListWSModel;
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


    @RequestMapping(value = BaseRoute.GET_ALL_REMOTES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllRemotes(@RequestParam long userId,
                                           @RequestParam String remoteType,
                                           @RequestParam String remoteState,
                                           @RequestParam int reqPage,
                                           @RequestParam int reqSize) {

        RemoteListWSModel response = remoteSettingsMiddleware.getAllRemotes(userId,remoteType,remoteState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
