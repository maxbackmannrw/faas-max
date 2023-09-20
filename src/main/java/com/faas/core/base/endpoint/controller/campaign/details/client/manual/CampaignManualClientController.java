package com.faas.core.base.endpoint.controller.campaign.details.client.manual;

import com.faas.core.base.middleware.campaign.details.client.manual.CampaignManualClientMiddleware;
import com.faas.core.base.model.ws.campaign.details.client.session.CampaignSessionWSModel;
import com.faas.core.base.model.ws.client.session.content.SessionRequest;
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
public class CampaignManualClientController {


    @Autowired
    CampaignManualClientMiddleware campaignManualClientMiddleware;


    @RequestMapping(value = BaseRoute.SEARCH_CAMPAIGN_MANUAL_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> searchCampaignManualClients(@RequestParam long userId,
                                                         @RequestParam String campaignId,
                                                         @RequestParam String city,
                                                         @RequestParam String country,
                                                         @RequestParam int reqPage,
                                                         @RequestParam int reqSize) {

        CampaignSessionWSModel response = campaignManualClientMiddleware.searchCampaignManualClients(userId,campaignId,city,country,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_MANUAL_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignManualClients(@RequestParam long userId,
                                                      @RequestParam String campaignId,
                                                      @RequestParam int reqPage,
                                                      @RequestParam int reqSize) {

        CampaignSessionWSModel response = campaignManualClientMiddleware.getCampaignManualClients(userId,campaignId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_MANUAL_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignManualClient(@RequestParam long userId,
                                                     @RequestParam long sessionId) {

        SessionWSModel response = campaignManualClientMiddleware.getCampaignManualClient(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_MANUAL_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignManualClient(@RequestBody SessionRequest sessionRequest) {

        SessionWSModel response = campaignManualClientMiddleware.createCampaignManualClient(sessionRequest);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_MANUAL_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignManualClient(@RequestParam long userId,
                                                        @RequestParam long sessionId,
                                                        @RequestParam long agentId,
                                                        @RequestParam String campaignId,
                                                        @RequestParam String sessionState) {

        SessionWSModel response = campaignManualClientMiddleware.updateCampaignManualClient(userId,sessionId,agentId,campaignId,sessionState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_MANUAL_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignManualClient(@RequestParam long userId,
                                                        @RequestParam long sessionId) {

        SessionWSModel response = campaignManualClientMiddleware.removeCampaignManualClient(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
