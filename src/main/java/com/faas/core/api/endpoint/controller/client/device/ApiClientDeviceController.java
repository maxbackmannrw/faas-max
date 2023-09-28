package com.faas.core.api.endpoint.controller.client.device;

import com.faas.core.api.middleware.client.device.ApiClientDeviceMiddleware;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/client/device/")
public class ApiClientDeviceController {


    @Autowired
    ApiClientDeviceMiddleware apiClientDeviceMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_AGENT_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentSession(@RequestParam long agentId,
                                                @RequestParam int reqPage,
                                                @RequestParam int reqSize) {

        ApiAgentSessionWSModel response = apiClientDeviceMiddleware.apiGetAgentSession(agentId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}