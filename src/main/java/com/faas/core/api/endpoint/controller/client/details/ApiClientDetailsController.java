package com.faas.core.api.endpoint.controller.client.details;

import com.faas.core.api.middleware.client.details.ApiClientDetailsMiddleware;
import com.faas.core.api.model.ws.client.details.ApiClientDetailsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/client/details/")
public class ApiClientDetailsController {


    @Autowired
    ApiClientDetailsMiddleware apiClientDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_AGENT_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentClient(@RequestParam long agentId,
                                               @RequestParam long clientId) {

        ApiClientDetailsWSModel response = apiClientDetailsMiddleware.apiGetClientDevices(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}