package com.faas.core.api.endpoint.controller.campaign.details.process;

import com.faas.core.utils.config.ApiRoute;
import com.faas.core.api.middleware.campaign.details.process.ApiCampaignProcessMiddleware;
import com.faas.core.api.model.ws.campaign.details.process.content.ApiProcessWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/campaign/process/")
public class ApiCampaignProcessController {


    @Autowired
    ApiCampaignProcessMiddleware apiCampaignProcessMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_AGENT_CAMPAIGN_PROCESSES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentCampaignProcesses(@RequestParam long agentId) {

        ApiProcessWSModel response = apiCampaignProcessMiddleware.apiGetAgentCampaignProcesses(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CAMPAIGN_PROCESSES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetCampaignProcesses(@RequestParam long agentId,
                                                     @RequestParam String campaignId,
                                                     @RequestParam String processId) {

        ApiProcessWSModel response = apiCampaignProcessMiddleware.apiGetCampaignProcesses(agentId,campaignId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CAMPAIGN_PROCESS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetCampaignProcess(@RequestParam long agentId,
                                                   @RequestParam String campaignId,
                                                   @RequestParam String processId) {

        ApiProcessWSModel response = apiCampaignProcessMiddleware.apiGetCampaignProcess(agentId,campaignId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
