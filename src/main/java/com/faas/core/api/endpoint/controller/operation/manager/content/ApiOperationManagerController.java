package com.faas.core.api.endpoint.controller.operation.manager.content;

import com.faas.core.api.middleware.operation.manager.content.ApiOperationManagerMiddleware;
import com.faas.core.api.model.ws.campaign.details.ApiCampaignDetailsWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
import com.faas.core.api.model.ws.operation.content.ApiValidateOperationWSModel;
import com.faas.core.api.model.ws.operation.manager.content.ApiCheckAgentOperationWSModel;
import com.faas.core.api.model.ws.operation.manager.content.ApiOperationActivityWSModel;
import com.faas.core.api.model.ws.operation.manager.content.ApiOperationManagerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/manager/")
public class ApiOperationManagerController {


    @Autowired
    ApiOperationManagerMiddleware apiOperationDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_CHECK_AGENT_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiCheckAgentOperation(@RequestParam long agentId,
                                                    @RequestParam String operationId) {

        ApiCheckAgentOperationWSModel response = apiOperationDetailsMiddleware.apiCheckAgentOperation(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_MANAGER, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationManager(@RequestParam long agentId,
                                                    @RequestParam String operationId) {

        ApiOperationManagerWSModel response = apiOperationDetailsMiddleware.apiGetOperationManager(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_START_AGENT_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiStartAgentOperation(@RequestParam long agentId,
                                                      @RequestParam String operationId) {

        ApiOperationWSModel response = apiOperationDetailsMiddleware.apiStartOperationManager(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_COMPLETE_AGENT_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiCompleteAgentOperation(@RequestParam long agentId,
                                                         @RequestParam String operationId,
                                                         @RequestParam String operationResult) {

        ApiOperationWSModel response = apiOperationDetailsMiddleware.apiCompleteOperationManager(agentId, operationId, operationResult);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_AGENT_SWITCHABLE_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentSwitchableOperations(@RequestParam long agentId,
                                                             @RequestParam String operationId) {

        ApiOperationWSModel response = apiOperationDetailsMiddleware.apiGetSwitchOperationManagers(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_SWITCH_AGENT_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiSwitchAgentOperation(@RequestParam long agentId,
                                                       @RequestParam String operationId,
                                                       @RequestParam String selectedId) {

        ApiOperationWSModel response = apiOperationDetailsMiddleware.apiSwitchOperationManager(agentId, operationId, selectedId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationCampaign(@RequestParam long agentId,
                                                            @RequestParam String operationId) {

        ApiCampaignDetailsWSModel response = apiOperationDetailsMiddleware.apiGetOperationManagerCampaign(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_ACTIVITIES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationActivities(@RequestParam long agentId,
                                                              @RequestParam String operationId) {

        ApiOperationActivityWSModel response = apiOperationDetailsMiddleware.apiGetOperationManagerActivities(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_ACTIVITY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationActivity(@RequestParam long agentId,
                                                            @RequestParam String operationId,
                                                            @RequestParam String activityId) {

        ApiOperationActivityWSModel response = apiOperationDetailsMiddleware.apiGetOperationManagerActivity(agentId, operationId, activityId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
