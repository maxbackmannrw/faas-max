package com.faas.core.api.endpoint.controller.campaign.details;

import com.faas.core.api.middleware.campaign.details.ApiCampaignDetailsMiddleware;
import com.faas.core.api.model.ws.campaign.details.ApiCampaignDetailsWSModel;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationListWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
import com.faas.core.api.model.ws.operation.content.ApiValidateOperationWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/campaign/details/")
public class ApiCampaignDetailsController {


    @Autowired
    ApiCampaignDetailsMiddleware apiCampaignDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_AGENT_CAMPAIGN_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentCampaignDetails(@RequestParam long agentId,
                                                        @RequestParam String campaignId) {

        ApiCampaignDetailsWSModel response = apiCampaignDetailsMiddleware.apiGetAgentCampaignDetails(agentId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_AGENT_CAMPAIGN_DETAILS_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentCampaignDetailsSummary(@RequestParam long agentId,
                                                               @RequestParam String campaignId) {

        ApiSummaryWSModel response = apiCampaignDetailsMiddleware.apiGetAgentCampaignDetailsSummary(agentId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_AGENT_CAMPAIGN_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentCampaignOperations(@RequestParam long agentId,
                                                           @RequestParam String campaignId,
                                                           @RequestParam String operationState,
                                                           @RequestParam int reqPage,
                                                           @RequestParam int reqSize) {

        ApiOperationListWSModel response = apiCampaignDetailsMiddleware.apiGetAgentCampaignOperations(agentId, campaignId, operationState, reqPage, reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_AGENT_CAMPAIGN_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentCampaignOperation(@RequestParam long agentId,
                                                          @RequestParam String operationId) {

        ApiOperationWSModel response = apiCampaignDetailsMiddleware.apiGetAgentCampaignOperation(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_VALIDATE_AGENT_CAMPAIGN_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiValidateAgentCampaignOperation(@RequestParam long agentId,
                                                               @RequestParam String operationId) {

        ApiValidateOperationWSModel response = apiCampaignDetailsMiddleware.apiValidateAgentCampaignOperation(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
