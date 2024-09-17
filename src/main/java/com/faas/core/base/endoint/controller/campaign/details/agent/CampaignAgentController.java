package com.faas.core.base.endoint.controller.campaign.details.agent;

import com.faas.core.base.middleware.campaign.details.agent.CampaignAgentMiddleware;
import com.faas.core.base.model.ws.campaign.details.agent.CampaignAgentWSModel;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/agent/")
public class CampaignAgentController {


    @Autowired
    CampaignAgentMiddleware campaignAgentMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_AGENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignAgents(@RequestParam long userId,
                                               @RequestParam String campaignId) {

        CampaignAgentWSModel response = campaignAgentMiddleware.getCampaignAgents(userId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_AGENT, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignAgent(@RequestParam long userId,
                                              @RequestParam String campaignId,
                                              @RequestParam long agentId) {

        CampaignAgentWSModel response = campaignAgentMiddleware.getCampaignAgent(userId, campaignId, agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.ASSIGN_CAMPAIGN_AGENT, method = RequestMethod.POST)
    public ResponseEntity<?> assignCampaignAgent(@RequestParam long userId,
                                                 @RequestParam String campaignId,
                                                 @RequestParam long agentId) {

        CampaignAgentWSModel response = campaignAgentMiddleware.assignCampaignAgent(userId, campaignId, agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_AGENT_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignAgentState(@RequestParam long userId,
                                                      @RequestParam String campaignId,
                                                      @RequestParam long agentId,
                                                      @RequestParam String agentState) {

        CampaignAgentWSModel response = campaignAgentMiddleware.updateCampaignAgentState(userId, campaignId, agentId, agentState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_AGENT, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignAgent(@RequestParam long userId,
                                                 @RequestParam String campaignId,
                                                 @RequestParam long agentId) {

        CampaignAgentWSModel response = campaignAgentMiddleware.removeCampaignAgent(userId, campaignId, agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_ASSIGNABLE_AGENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getAssignableAgents(@RequestParam long userId,
                                                 @RequestParam String campaignId) {

        CampaignAgentWSModel response = campaignAgentMiddleware.getAssignableAgents(userId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
