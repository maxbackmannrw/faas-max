package com.faas.core.api.endpoint.controller.operation.content;

import com.faas.core.api.middleware.operation.content.ApiOperationMiddleware;
import com.faas.core.api.model.ws.operation.content.ApiAgentOperationWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationListWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/")
public class ApiOperationController {

    @Autowired
    ApiOperationMiddleware apiOperationMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_AGENT_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentOperations(@RequestParam long agentId,
                                                   @RequestParam int reqPage,
                                                   @RequestParam int reqSize) {

        ApiAgentOperationWSModel response = apiOperationMiddleware.apiGetAgentOperations(agentId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CAMPAIGN_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetCampaignOperations(@RequestParam long agentId,
                                                      @RequestParam String campaignId,
                                                      @RequestParam String operationState,
                                                      @RequestParam int reqPage,
                                                      @RequestParam int reqSize) {

        ApiOperationListWSModel response = apiOperationMiddleware.apiGetCampaignOperations(agentId,campaignId,operationState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperations(@RequestParam long agentId,
                                              @RequestParam String operationType,
                                              @RequestParam String operationState,
                                              @RequestParam String operationInquiryState,
                                              @RequestParam String operationFlowState,
                                              @RequestParam int reqPage,
                                              @RequestParam int reqSize) {

        ApiOperationListWSModel response = apiOperationMiddleware.apiGetOperations(agentId,operationType,operationState,operationInquiryState,operationFlowState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperation(@RequestParam long agentId,
                                             @RequestParam String operationId) {

        ApiOperationWSModel response = apiOperationMiddleware.apiGetOperation(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperation(@RequestParam long agentId,
                                                @RequestParam String operationId,
                                                @RequestParam String operationState) {

        ApiOperationWSModel response = apiOperationMiddleware.apiUpdateOperation(agentId,operationId,operationState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperation(@RequestParam long agentId,
                                                @RequestParam String operationId) {

        ApiOperationWSModel response = apiOperationMiddleware.apiRemoveOperation(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
