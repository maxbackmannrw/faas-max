package com.faas.core.api.endpoint.controller.campaign.details;

import com.faas.core.api.middleware.campaign.details.ApiCampaignDetailsMiddleware;
import com.faas.core.api.model.ws.campaign.details.ApiCampaignDetailsWSModel;
import com.faas.core.api.model.ws.campaign.details.ApiCampaignProcessWSModel;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/campaign/details/")
public class ApiCampaignDetailsController {


    @Autowired
    ApiCampaignDetailsMiddleware apiCampaignDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_CAMPAIGN_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetCampaignDetails(@RequestParam long agentId,
                                                   @RequestParam String campaignId) {

        ApiCampaignDetailsWSModel response = apiCampaignDetailsMiddleware.apiGetCampaignDetails(agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CAMPAIGN_PROCESS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetCampaignProcess(@RequestParam long agentId,
                                                   @RequestParam String campaignId) {

        ApiCampaignProcessWSModel response = apiCampaignDetailsMiddleware.apiGetCampaignProcess(agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_AGENT_CAMPAIGN_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentCampaignSummary(@RequestParam long agentId) {

        ApiSummaryWSModel response = apiCampaignDetailsMiddleware.apiGetAgentCampaignSummary(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
