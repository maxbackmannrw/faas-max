package com.faas.core.api.endpoint.controller.campaign.details.operation;

import com.faas.core.api.middleware.campaign.details.operation.ApiCampaignOperationMiddleware;
import com.faas.core.api.model.ws.operation.content.ApiOperationListWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
import com.faas.core.api.model.ws.operation.details.content.ApiOperationValidateWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/campaign/details/operation/")
public class ApiCampaignOperationController {


    @Autowired
    ApiCampaignOperationMiddleware apiCampaignOperationMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_CAMPAIGN_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetCampaignOperations(@RequestParam long agentId,
                                                      @RequestParam String campaignId,
                                                      @RequestParam String operationState,
                                                      @RequestParam int reqPage,
                                                      @RequestParam int reqSize) {

        ApiOperationListWSModel response = apiCampaignOperationMiddleware.apiGetCampaignOperations(agentId,campaignId,operationState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CAMPAIGN_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetCampaignOperation(@RequestParam long agentId,
                                                     @RequestParam String operationId) {

        ApiOperationWSModel response = apiCampaignOperationMiddleware.apiGetCampaignOperation(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_CAMPAIGN_OPERATION_VALIDATE, method = RequestMethod.POST)
    public ResponseEntity<?> apiCampaignOperationValidate(@RequestParam long agentId,
                                                          @RequestParam String operationId) {

        ApiOperationValidateWSModel response = apiCampaignOperationMiddleware.apiCampaignOperationValidate(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
