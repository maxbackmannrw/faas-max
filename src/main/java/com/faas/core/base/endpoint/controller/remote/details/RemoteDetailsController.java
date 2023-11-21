package com.faas.core.base.endpoint.controller.remote.details;

import com.faas.core.base.middleware.remote.details.RemoteDetailsMiddleware;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/remote/details/")
public class RemoteDetailsController {


    @Autowired
    RemoteDetailsMiddleware remoteDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_REMOTE_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteDetails(@RequestParam long userId) {

        RemoteWSModel response = remoteDetailsMiddleware.getRemoteDetails(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
