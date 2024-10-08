package com.faas.core.api.endpoint.controller.operation.manager.campaign;

import com.faas.core.api.middleware.operation.manager.campaign.ApiOperationCampaignMiddleware;
import com.faas.core.api.model.ws.campaign.details.ApiCampaignDetailsWSModel;
import com.faas.core.api.model.ws.operation.manager.campaign.ApiOperationScenarioWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/manager/campaign/")
public class ApiOperationCampaignController {


    @Autowired
    ApiOperationCampaignMiddleware apiOperationCampaignMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationCampaign(@RequestParam long agentId,
                                                     @RequestParam String operationId) {

        ApiCampaignDetailsWSModel response = apiOperationCampaignMiddleware.apiGetOperationCampaign(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SCENARIOS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationScenarios(@RequestParam long agentId,
                                                      @RequestParam String operationId) {

        ApiOperationScenarioWSModel response = apiOperationCampaignMiddleware.apiGetOperationScenarios(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationScenario(@RequestParam long agentId,
                                                     @RequestParam String operationId,
                                                     @RequestParam String executeId) {

        ApiOperationScenarioWSModel response = apiOperationCampaignMiddleware.apiGetOperationScenario(agentId, operationId, executeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_OPERATION_EXECUTE_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiOperationExecuteScenario(@RequestParam long agentId,
                                                         @RequestParam String operationId,
                                                         @RequestParam String scenarioId) {

        ApiOperationScenarioWSModel response = apiOperationCampaignMiddleware.apiOperationExecuteScenario(agentId, operationId, scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperationScenario(@RequestParam long agentId,
                                                        @RequestParam String operationId,
                                                        @RequestParam String executeId) {

        ApiOperationScenarioWSModel response = apiOperationCampaignMiddleware.apiUpdateOperationScenario(agentId, operationId, executeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationScenario(@RequestParam long agentId,
                                                        @RequestParam String operationId,
                                                        @RequestParam String executeId) {

        ApiOperationScenarioWSModel response = apiOperationCampaignMiddleware.apiRemoveOperationScenario(agentId, operationId, executeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
