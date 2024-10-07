package com.faas.core.api.endpoint.controller.operation.manager.details;

import com.faas.core.api.middleware.operation.manager.details.ApiOperationManagerDetailsMiddleware;
import com.faas.core.api.model.ws.campaign.details.ApiCampaignDetailsWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
import com.faas.core.api.model.ws.operation.manager.content.ApiOperationActivityWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/manager/details/")
public class ApiOperationManagerDetailsController {


    @Autowired
    ApiOperationManagerDetailsMiddleware apiOperationManagerDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_START_AGENT_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiStartAgentOperation(@RequestParam long agentId,
                                                    @RequestParam String operationId) {

        ApiOperationWSModel response = apiOperationManagerDetailsMiddleware.apiStartOperationManager(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_COMPLETE_AGENT_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiCompleteAgentOperation(@RequestParam long agentId,
                                                       @RequestParam String operationId,
                                                       @RequestParam String operationResult) {

        ApiOperationWSModel response = apiOperationManagerDetailsMiddleware.apiCompleteOperationManager(agentId, operationId, operationResult);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_AGENT_SWITCHABLE_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentSwitchableOperations(@RequestParam long agentId,
                                                             @RequestParam String operationId) {

        ApiOperationWSModel response = apiOperationManagerDetailsMiddleware.apiGetSwitchOperationManagers(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_SWITCH_AGENT_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiSwitchAgentOperation(@RequestParam long agentId,
                                                     @RequestParam String operationId,
                                                     @RequestParam String selectedId) {

        ApiOperationWSModel response = apiOperationManagerDetailsMiddleware.apiSwitchOperationManager(agentId, operationId, selectedId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
