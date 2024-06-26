package com.faas.core.api.endpoint.controller.operation.details.osint;

import com.faas.core.api.middleware.operation.details.osint.ApiOperationOSINTMiddleware;
import com.faas.core.api.model.ws.operation.details.osint.ApiOperationOSINTWSModel;
import com.faas.core.utility.config.ApiRoute;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/osint/")
public class ApiOperationOSINTController {


    @Autowired
    ApiOperationOSINTMiddleware apiOperationOSINTMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CLIENT_OS_INTS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationClientOSINTs(@RequestParam long agentId,
                                                         @RequestParam long clientId) {

        ApiOperationOSINTWSModel response = apiOperationOSINTMiddleware.apiGetOperationClientOSINTs(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CLIENT_OS_INT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationClientOSINT(@RequestParam long agentId,
                                                        @RequestParam long clientId) {

        ApiOperationOSINTWSModel response = apiOperationOSINTMiddleware.apiGetOperationClientOSINT(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
