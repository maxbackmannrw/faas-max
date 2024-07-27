package com.faas.core.base.endpoint.controller.remoteapp.manager.content;

import com.faas.core.base.middleware.remoteapp.content.RemoteAppMiddleware;
import com.faas.core.base.middleware.remoteapp.manager.content.RemoteAppManagerMiddleware;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/remoteapp/manager/")
public class RemoteAppManagerController {


    @Autowired
    RemoteAppManagerMiddleware remoteAppManagerMiddleware;


    @RequestMapping(value = BaseRoute.GET_REMOTE_APPS, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteAppManagers(@RequestParam long userId,
                                           @RequestParam String appState,
                                           @RequestParam String baseType,
                                           @RequestParam int reqPage,
                                           @RequestParam int reqSize) {

        RemoteAppListWSModel response = remoteAppManagerMiddleware.getRemoteApps(userId,appState,baseType,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }




}
