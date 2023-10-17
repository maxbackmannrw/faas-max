package com.faas.core.api.endpoint.controller.client.details;

import com.faas.core.api.middleware.client.details.ApiClientOsIntMiddleware;
import com.faas.core.api.model.ws.client.session.ApiAgentSessionWSModel;
import com.faas.core.utils.config.ApiRoute;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/client/osint/")
public class ApiClientOsIntController {


    @Autowired
    ApiClientOsIntMiddleware apiClientOsIntMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_DEVICES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientDevices(@RequestParam long agentId,
                                                 @RequestParam long clientId) {

        ApiAgentSessionWSModel response = apiClientOsIntMiddleware.apiGetClientDevices(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}