package com.faas.core.api.endpoint.controller.operation.scenario;

import com.faas.core.api.middleware.operation.scenario.ApiOperationFlowMiddleware;
import com.faas.core.api.model.ws.operation.scenario.flow.ApiOperationFlowWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/scenario/flow/")
public class ApiOperationFlowController {


    @Autowired
    ApiOperationFlowMiddleware apiOperationFlowMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationFlow(@RequestParam long agentId,
                                                 @RequestParam long sessionId,
                                                 @RequestParam long clientId,
                                                 @RequestParam String campaignId) {

        ApiOperationFlowWSModel response = apiOperationFlowMiddleware.apiGetOperationFlow(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
