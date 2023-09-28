package com.faas.core.api.endpoint.controller.operation.details.client.osint;

import com.faas.core.api.middleware.operation.details.client.osint.ApiOperationClientOsIntMiddleware;
import com.faas.core.api.model.ws.client.details.ApiClientOsIntWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/client/osint/")
public class ApiOperationClientOsIntController {


    @Autowired
    ApiOperationClientOsIntMiddleware apiOperationClientOsIntMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_OS_INTS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientOsInts(@RequestParam long agentId,
                                                @RequestParam long sessionId,
                                                @RequestParam long clientId) {

        ApiClientOsIntWSModel response = apiOperationClientOsIntMiddleware.apiGetClientOsInts(agentId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
