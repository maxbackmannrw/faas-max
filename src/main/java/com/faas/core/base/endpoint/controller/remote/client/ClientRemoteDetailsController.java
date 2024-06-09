package com.faas.core.base.endpoint.controller.remote.client;

import com.faas.core.base.middleware.remote.client.ClientRemoteDetailsMiddleware;
import com.faas.core.base.model.ws.remote.client.content.ClientRemoteSummaryWSModel;
import com.faas.core.base.model.ws.remote.client.details.ClientRemoteDetailsWSModel;
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
public class ClientRemoteDetailsController {


    @Autowired
    ClientRemoteDetailsMiddleware clientRemoteDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_CLIENT_REMOTE_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getClientRemoteDetails(@RequestParam long userId,
                                                    @RequestParam String clientRemoteId) {

        ClientRemoteDetailsWSModel response = clientRemoteDetailsMiddleware.getClientRemoteDetails(userId,clientRemoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CLIENT_REMOTE_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> getClientRemoteSummary(@RequestParam long userId) {

        ClientRemoteSummaryWSModel response = clientRemoteDetailsMiddleware.getClientRemoteSummary(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
