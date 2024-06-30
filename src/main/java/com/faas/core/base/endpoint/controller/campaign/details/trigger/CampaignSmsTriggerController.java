package com.faas.core.base.endpoint.controller.campaign.details.trigger;

import com.faas.core.base.middleware.campaign.details.trigger.CampaignSmsTriggerMiddleware;
import com.faas.core.base.model.ws.campaign.details.trigger.CampaignSmsTriggerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/trigger/sms/")
public class CampaignSmsTriggerController {


    @Autowired
    CampaignSmsTriggerMiddleware campaignSmsTriggerMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_SMS_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignSmsTriggers(@RequestParam long userId,
                                                    @RequestParam String campaignId) {

        CampaignSmsTriggerWSModel response = campaignSmsTriggerMiddleware.getCampaignSmsTriggers(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_SMS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignSmsTrigger(@RequestParam long userId,
                                                   @RequestParam String triggerId) {

        CampaignSmsTriggerWSModel response = campaignSmsTriggerMiddleware.getCampaignSmsTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_SMS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignSmsTrigger(@RequestParam long userId,
                                                      @RequestParam String campaignId,
                                                      @RequestParam String trigger,
                                                      @RequestParam String accountId,
                                                      @RequestParam String smsTitle,
                                                      @RequestParam String smsBody,
                                                      @RequestParam String senderId,
                                                      @RequestParam long typeId) {

        CampaignSmsTriggerWSModel response = campaignSmsTriggerMiddleware.createCampaignSmsTrigger(userId,campaignId,trigger,accountId,smsTitle,smsBody,senderId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_SMS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignSmsTrigger(@RequestParam long userId,
                                                      @RequestParam String triggerId,
                                                      @RequestParam String trigger,
                                                      @RequestParam String accountId,
                                                      @RequestParam String smsTitle,
                                                      @RequestParam String smsBody,
                                                      @RequestParam String senderId) {

        CampaignSmsTriggerWSModel response = campaignSmsTriggerMiddleware.updateCampaignSmsTrigger(userId,triggerId,trigger,accountId,smsTitle,smsBody,senderId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_SMS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignSmsTrigger(@RequestParam long userId,
                                                      @RequestParam String triggerId) {

        CampaignSmsTriggerWSModel response = campaignSmsTriggerMiddleware.removeCampaignSmsTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
