package com.faas.core.api.endpoint.controller.operation.manager.client.intel;

import com.faas.core.api.middleware.operation.manager.client.intel.ApiOperationIntelMiddleware;
import com.faas.core.api.model.ws.operation.manager.client.intel.ApiOperationIntelWSModel;
import com.faas.core.misc.config.ApiRoute;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/manager/client/intel/")
public class ApiOperationIntelController {


    @Autowired
    ApiOperationIntelMiddleware apiOperationIntelMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_INTELS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationIntels(@RequestParam long agentId,
                                                   @RequestParam long clientId) {

        ApiOperationIntelWSModel response = apiOperationIntelMiddleware.apiGetOperationIntels(agentId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_INTEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationIntel(@RequestParam long agentId,
                                                  @RequestParam long clientId) {

        ApiOperationIntelWSModel response = apiOperationIntelMiddleware.apiGetOperationIntel(agentId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}