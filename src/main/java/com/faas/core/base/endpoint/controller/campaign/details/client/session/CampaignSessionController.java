package com.faas.core.base.endpoint.controller.campaign.details.client.session;

import com.faas.core.base.middleware.campaign.details.client.session.CampaignSessionMiddleware;
import com.faas.core.base.model.ws.campaign.details.client.session.CampaignSessionWSModel;
import com.faas.core.base.model.ws.session.content.SessionRequest;
import com.faas.core.base.model.ws.session.content.SessionWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/client/session/")
public class CampaignSessionController {


    @Autowired
    CampaignSessionMiddleware campaignSessionMiddleware;


    @RequestMapping(value = BaseRoute.SEARCH_CAMPAIGN_SESSIONS, method = RequestMethod.POST)
    public ResponseEntity<?> searchCampaignSessions(@RequestParam long userId,
                                                    @RequestParam String campaignId,
                                                    @RequestParam String city,
                                                    @RequestParam String country,
                                                    @RequestParam int reqPage,
                                                    @RequestParam int reqSize) {

        CampaignSessionWSModel response = campaignSessionMiddleware.searchCampaignSessions(userId,campaignId,city,country,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_SESSIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignSessions(@RequestParam long userId,
                                                 @RequestParam String campaignId,
                                                 @RequestParam int reqPage,
                                                 @RequestParam int reqSize) {

        CampaignSessionWSModel response = campaignSessionMiddleware.getCampaignSessions(userId,campaignId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignSession(@RequestParam long userId,
                                                @RequestParam long sessionId,
                                                @RequestParam long clientId) {

        SessionWSModel response = campaignSessionMiddleware.getCampaignSession(userId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignSession(@RequestBody SessionRequest sessionRequest) {

        SessionWSModel response = campaignSessionMiddleware.createCampaignSession(sessionRequest);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignSession(@RequestParam long userId,
                                                   @RequestParam long sessionId,
                                                   @RequestParam long clientId,
                                                   @RequestParam long agentId,
                                                   @RequestParam String campaignId,
                                                   @RequestParam String sessionState) {

        SessionWSModel response = campaignSessionMiddleware.updateCampaignSession(userId,sessionId,clientId,agentId,campaignId,sessionState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignSession(@RequestParam long userId,
                                                   @RequestParam long sessionId,
                                                   @RequestParam long clientId) {

        SessionWSModel response = campaignSessionMiddleware.removeCampaignSession(userId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
