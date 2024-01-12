package com.faas.core.api.endpoint.controller.client.content;

import com.faas.core.api.middleware.client.content.ApiClientMiddleware;
import com.faas.core.api.model.ws.client.content.ApiClientWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/client/")
public class ApiClientController {


    @Autowired
    ApiClientMiddleware apiClientMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClient(@RequestParam long agentId,
                                          @RequestParam long clientId) {

        ApiClientWSModel response = apiClientMiddleware.apiGetClient(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}