package com.faas.core.base.endpoint.controller.campaign.details.trigger.details;

import com.faas.core.base.middleware.campaign.details.trigger.details.CampaignWappTriggerMiddleware;
import com.faas.core.base.model.ws.campaign.details.trigger.details.CampaignWappCallTriggerWSModel;
import com.faas.core.base.model.ws.campaign.details.trigger.details.CampaignWappMessageTriggerWSModel;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/trigger/wapp/")
public class CampaignWappTriggerController {


    @Autowired
    CampaignWappTriggerMiddleware campaignWappTriggerMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_WAPP_MESSAGE_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignWappMessageTriggers(@RequestParam long userId,
                                                            @RequestParam String campaignId) {

        CampaignWappMessageTriggerWSModel response = campaignWappTriggerMiddleware.getCampaignWappMessageTriggers(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignWappMessageTrigger(@RequestParam long userId,
                                                           @RequestParam String triggerId) {

        CampaignWappMessageTriggerWSModel response = campaignWappTriggerMiddleware.getCampaignWappMessageTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignWappMessageTrigger(@RequestParam long userId,
                                                              @RequestParam String campaignId,
                                                              @RequestParam String trigger,
                                                              @RequestParam String accountId,
                                                              @RequestParam String wappTitle,
                                                              @RequestParam String wappBody,
                                                              @RequestParam long typeId) {

        CampaignWappMessageTriggerWSModel response = campaignWappTriggerMiddleware.createCampaignWappMessageTrigger(userId,campaignId,trigger,accountId,wappTitle,wappBody,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignWappMessageTrigger(@RequestParam long userId,
                                                              @RequestParam String triggerId,
                                                              @RequestParam String trigger,
                                                              @RequestParam String accountId,
                                                              @RequestParam String wappTitle,
                                                              @RequestParam String wappBody) {

        CampaignWappMessageTriggerWSModel response = campaignWappTriggerMiddleware.updateCampaignWappMessageTrigger(userId,triggerId,trigger,accountId,wappTitle,wappBody);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignWappMessageTrigger(@RequestParam long userId,
                                                              @RequestParam String triggerId) {

        CampaignWappMessageTriggerWSModel response = campaignWappTriggerMiddleware.removeCampaignWappMessageTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_WAPP_CALL_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignWappCallTriggers(@RequestParam long userId,
                                                         @RequestParam String campaignId) {

        CampaignWappCallTriggerWSModel response = campaignWappTriggerMiddleware.getCampaignWappCallTriggers(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignWappCallTrigger(@RequestParam long userId,
                                                        @RequestParam String triggerId) {

        CampaignWappCallTriggerWSModel response = campaignWappTriggerMiddleware.getCampaignWappCallTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignWappCallTrigger(@RequestParam long userId,
                                                           @RequestParam String campaignId,
                                                           @RequestParam String trigger,
                                                           @RequestParam String accountId,
                                                           @RequestParam long typeId) {

        CampaignWappCallTriggerWSModel response = campaignWappTriggerMiddleware.createCampaignWappCallTrigger(userId,campaignId,trigger,accountId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignWappCallTrigger(@RequestParam long userId,
                                                           @RequestParam String triggerId,
                                                           @RequestParam String trigger,
                                                           @RequestParam String accountId) {

        CampaignWappCallTriggerWSModel response = campaignWappTriggerMiddleware.updateCampaignWappCallTrigger(userId,triggerId,trigger,accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignWappCallTrigger(@RequestParam long userId,
                                                           @RequestParam String triggerId) {

        CampaignWappCallTriggerWSModel response = campaignWappTriggerMiddleware.removeCampaignWappCallTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
