package com.faas.core.base.endpoint.controller.campaign.details.client.manual;

import com.faas.core.base.middleware.campaign.details.client.manual.CampaignClientManualMiddleware;
import com.faas.core.base.model.ws.campaign.details.client.manual.CampaignManualSessionWSModel;
import com.faas.core.base.model.ws.campaign.details.client.manual.CampaignManualSessionRequest;
import com.faas.core.base.model.ws.client.session.content.SessionWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/client/manual/")
public class CampaignClientManualController {


    @Autowired
    CampaignClientManualMiddleware campaignClientManualMiddleware;


    @RequestMapping(value = BaseRoute.SEARCH_CAMPAIGN_MANUAL_SESSIONS, method = RequestMethod.POST)
    public ResponseEntity<?> searchCampaignManualSessions(@RequestParam long userId,
                                                          @RequestParam String campaignId,
                                                          @RequestParam String city,
                                                          @RequestParam String country,
                                                          @RequestParam int reqPage,
                                                          @RequestParam int reqSize) {

        CampaignManualSessionWSModel response = campaignClientManualMiddleware.searchCampaignManualSessions(userId,campaignId,city,country,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_MANUAL_SESSIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignManualSessions(@RequestParam long userId,
                                                       @RequestParam String campaignId,
                                                       @RequestParam int reqPage,
                                                       @RequestParam int reqSize) {

        CampaignManualSessionWSModel response = campaignClientManualMiddleware.getCampaignManualSessions(userId,campaignId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_MANUAL_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignManualSession(@RequestParam long userId,
                                                      @RequestParam long sessionId) {

        SessionWSModel response = campaignClientManualMiddleware.getCampaignManualSession(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_MANUAL_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignManualSession(@RequestBody CampaignManualSessionRequest manualSessionRequest) {

        SessionWSModel response = campaignClientManualMiddleware.createCampaignManualSession(manualSessionRequest);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_MANUAL_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignManualSession(@RequestParam long userId,
                                                         @RequestParam long sessionId,
                                                         @RequestParam long agentId,
                                                         @RequestParam String campaignId,
                                                         @RequestParam String sessionState) {

        SessionWSModel response = campaignClientManualMiddleware.updateCampaignManualSession(userId,sessionId,agentId,campaignId,sessionState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_MANUAL_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignManualSession(@RequestParam long userId,
                                                         @RequestParam long sessionId) {

        SessionWSModel response = campaignClientManualMiddleware.removeCampaignManualSession(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
