package com.faas.core.api.endpoint.controller.operation.details.campaign.transaction.content;

import com.faas.core.api.middleware.operation.details.campaign.transaction.content.ApiTransactionMiddleware;
import com.faas.core.api.model.ws.operation.details.campaign.scenario.ApiOperationScenarioWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/transaction/")
public class ApiTransactionController {


    @Autowired
    ApiTransactionMiddleware apiTransactionMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SCENARIOS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationScenarios(@RequestParam long agentId,
                                                      @RequestParam long sessionId,
                                                      @RequestParam String processId) {

        ApiOperationScenarioWSModel response = apiTransactionMiddleware.apiGetOperationScenarios(agentId,sessionId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
