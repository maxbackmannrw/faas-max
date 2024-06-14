package com.faas.core.base.endpoint.controller.remote.client.details;

import com.faas.core.base.middleware.remote.client.details.RemoteClientDetailsMiddleware;
import com.faas.core.base.model.ws.remote.client.content.RemoteClientSummaryWSModel;
import com.faas.core.base.model.ws.remote.client.details.RemoteClientDetailsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/remote/client/details/")
public class RemoteClientDetailsController {


    @Autowired
    RemoteClientDetailsMiddleware remoteClientDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_REMOTE_CLIENT_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteClientDetails(@RequestParam long userId,
                                                    @RequestParam String clientRemoteId) {

        RemoteClientDetailsWSModel response = remoteClientDetailsMiddleware.getRemoteClientDetails(userId,clientRemoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTE_CLIENT_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteClientSummary(@RequestParam long userId) {

        RemoteClientSummaryWSModel response = remoteClientDetailsMiddleware.getRemoteClientSummary(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
