package com.faas.core.base.endpoint.controller.remoteapp.details;

import com.faas.core.base.middleware.remoteapp.details.RemoteAppDetailsMiddleware;
import com.faas.core.base.model.ws.remoteapp.content.RemoteClientSummaryWSModel;
import com.faas.core.base.model.ws.remoteapp.details.RemoteClientDetailsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/remoteapp/details/")
public class RemoteAppDetailsController {


    @Autowired
    RemoteAppDetailsMiddleware remoteAppDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_REMOTE_APP_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteAppDetails(@RequestParam long userId,
                                                    @RequestParam String clientRemoteId) {

        RemoteClientDetailsWSModel response = remoteAppDetailsMiddleware.getRemoteAppDetails(userId,clientRemoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTE_APPS_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteAppsSummary(@RequestParam long userId) {

        RemoteClientSummaryWSModel response = remoteAppDetailsMiddleware.getRemoteAppsSummary(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
