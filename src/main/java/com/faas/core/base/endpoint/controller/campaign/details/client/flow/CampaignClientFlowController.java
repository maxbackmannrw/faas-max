package com.faas.core.base.endpoint.controller.campaign.details.client.flow;

import com.faas.core.base.middleware.campaign.details.client.flow.CampaignClientFlowMiddleware;
import com.faas.core.base.model.ws.campaign.details.client.flow.CampaignFlowSessionWSModel;
import com.faas.core.base.model.ws.campaign.details.client.flow.CampaignFlowSessionRequest;
import com.faas.core.base.model.ws.operation.flow.OperationFlowSessionWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/client/flow/")
public class CampaignClientFlowController {


    @Autowired
    CampaignClientFlowMiddleware campaignClientFlowMiddleware;


    @RequestMapping(value = BaseRoute.SEARCH_CAMPAIGN_FLOW_SESSIONS, method = RequestMethod.POST)
    public ResponseEntity<?> searchCampaignFlowSessions(@RequestParam long userId,
                                                        @RequestParam String campaignId,
                                                        @RequestParam String city,
                                                        @RequestParam String country,
                                                        @RequestParam int reqPage,
                                                        @RequestParam int reqSize) {

        CampaignFlowSessionWSModel response = campaignClientFlowMiddleware.searchCampaignFlowSessions(userId,campaignId,city,country,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_FLOW_SESSIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignFlowSessions(@RequestParam long userId,
                                                     @RequestParam String campaignId,
                                                     @RequestParam int reqPage,
                                                     @RequestParam int reqSize) {

        CampaignFlowSessionWSModel response = campaignClientFlowMiddleware.getCampaignFlowSessions(userId,campaignId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_FLOW_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignFlowSession(@RequestParam long userId,
                                                    @RequestParam long sessionId) {

        OperationFlowSessionWSModel response = campaignClientFlowMiddleware.getCampaignFlowSession(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_FLOW_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignFlowSession(@RequestBody CampaignFlowSessionRequest flowSessionRequest) {

        OperationFlowSessionWSModel response = campaignClientFlowMiddleware.createCampaignFlowSession(flowSessionRequest);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_FLOW_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignFlowSession(@RequestParam long userId,
                                                       @RequestParam long sessionId,
                                                       @RequestParam long agentId,
                                                       @RequestParam String campaignId,
                                                       @RequestParam String flowState) {

        OperationFlowSessionWSModel response = campaignClientFlowMiddleware.updateCampaignFlowSession(userId,sessionId,agentId,campaignId,flowState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_FLOW_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignFlowSession(@RequestParam long userId,
                                                       @RequestParam long sessionId) {

        OperationFlowSessionWSModel response = campaignClientFlowMiddleware.removeCampaignFlowSession(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
