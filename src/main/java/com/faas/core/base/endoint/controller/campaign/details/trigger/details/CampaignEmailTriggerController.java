package com.faas.core.base.endoint.controller.campaign.details.trigger.details;

import com.faas.core.base.middleware.campaign.details.trigger.details.CampaignEmailTriggerMiddleware;
import com.faas.core.base.model.ws.campaign.details.trigger.details.CampaignEmailTriggerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/trigger/email/")
public class CampaignEmailTriggerController {


    @Autowired
    CampaignEmailTriggerMiddleware campaignEmailTriggerMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_EMAIL_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignEmailTriggers(@RequestParam long userId,
                                                      @RequestParam String campaignId) {

        CampaignEmailTriggerWSModel response = campaignEmailTriggerMiddleware.getCampaignEmailTriggers(userId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_EMAIL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignEmailTrigger(@RequestParam long userId,
                                                     @RequestParam String triggerId) {

        CampaignEmailTriggerWSModel response = campaignEmailTriggerMiddleware.getCampaignEmailTrigger(userId, triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_EMAIL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignEmailTrigger(@RequestParam long userId,
                                                        @RequestParam String campaignId,
                                                        @RequestParam String trigger,
                                                        @RequestParam String accountId,
                                                        @RequestParam String emailSubject,
                                                        @RequestParam String emailTitle,
                                                        @RequestParam String emailBody,
                                                        @RequestParam String emailSender,
                                                        @RequestParam long typeId) {

        CampaignEmailTriggerWSModel response = campaignEmailTriggerMiddleware.createCampaignEmailTrigger(userId, campaignId, trigger, accountId, emailSubject, emailTitle, emailBody, emailSender, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_EMAIL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignEmailTrigger(@RequestParam long userId,
                                                        @RequestParam String triggerId,
                                                        @RequestParam String trigger,
                                                        @RequestParam String accountId,
                                                        @RequestParam String emailSubject,
                                                        @RequestParam String emailTitle,
                                                        @RequestParam String emailBody,
                                                        @RequestParam String emailSender) {

        CampaignEmailTriggerWSModel response = campaignEmailTriggerMiddleware.updateCampaignEmailTrigger(userId, triggerId, trigger, accountId, emailSubject, emailTitle, emailBody, emailSender);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_EMAIL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignEmailTrigger(@RequestParam long userId,
                                                        @RequestParam String triggerId) {

        CampaignEmailTriggerWSModel response = campaignEmailTriggerMiddleware.removeCampaignEmailTrigger(userId, triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
