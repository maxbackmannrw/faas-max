package com.faas.core.base.endpoint.controller.campaign.details.trigger;

import com.faas.core.base.middleware.campaign.details.trigger.CampaignSipTriggerMiddleware;
import com.faas.core.base.model.ws.campaign.details.trigger.CampaignSipTriggerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/trigger/sip/")
public class CampaignSipTriggerController {


    @Autowired
    CampaignSipTriggerMiddleware campaignSipTriggerMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_SMS_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignSipTriggers(@RequestParam long userId,
                                                    @RequestParam String campaignId){

        CampaignSipTriggerWSModel response = campaignSipTriggerMiddleware.getCampaignSipTriggers(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_SIP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignSipTrigger(@RequestParam long userId,
                                                   @RequestParam String triggerId) {

        CampaignSipTriggerWSModel response = campaignSipTriggerMiddleware.getCampaignSipTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_SIP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignSipTrigger(@RequestParam long userId,
                                                      @RequestParam String campaignId,
                                                      @RequestParam String trigger,
                                                      @RequestParam String accountId,
                                                      @RequestParam String callerId,
                                                      @RequestParam long typeId) {

        CampaignSipTriggerWSModel response = campaignSipTriggerMiddleware.createCampaignSipTrigger(userId,campaignId,trigger,accountId,callerId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_SIP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignSipTrigger(@RequestParam long userId,
                                                      @RequestParam String triggerId,
                                                      @RequestParam String trigger,
                                                      @RequestParam String accountId,
                                                      @RequestParam String callerId) {

        CampaignSipTriggerWSModel response = campaignSipTriggerMiddleware.updateCampaignSipTrigger(userId,triggerId,trigger,accountId,callerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_SIP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignSipTrigger(@RequestParam long userId,
                                                      @RequestParam String triggerId) {

        CampaignSipTriggerWSModel response = campaignSipTriggerMiddleware.removeCampaignSipTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
