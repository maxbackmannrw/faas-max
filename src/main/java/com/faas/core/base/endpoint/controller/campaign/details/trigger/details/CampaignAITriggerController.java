package com.faas.core.base.endpoint.controller.campaign.details.trigger.details;

import com.faas.core.base.middleware.campaign.details.trigger.details.CampaignAITriggerMiddleware;
import com.faas.core.base.model.ws.campaign.details.trigger.details.CampaignAITriggerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/trigger/ai/")
public class CampaignAITriggerController {


    @Autowired
    CampaignAITriggerMiddleware campaignAiTriggerMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_AI_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignAITriggers(@RequestParam long userId,
                                                   @RequestParam String campaignId) {

        CampaignAITriggerWSModel response = campaignAiTriggerMiddleware.getCampaignAITriggers(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignAITrigger(@RequestParam long userId,
                                                  @RequestParam String triggerId) {

        CampaignAITriggerWSModel response = campaignAiTriggerMiddleware.getCampaignAITrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignAITrigger(@RequestParam long userId,
                                                     @RequestParam String campaignId,
                                                     @RequestParam String trigger,
                                                     @RequestParam String accountId,
                                                     @RequestParam long typeId) {

        CampaignAITriggerWSModel response = campaignAiTriggerMiddleware.createCampaignAITrigger(userId,campaignId,trigger,accountId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignAITrigger(@RequestParam long userId,
                                                     @RequestParam String triggerId,
                                                     @RequestParam String trigger,
                                                     @RequestParam String accountId) {

        CampaignAITriggerWSModel response = campaignAiTriggerMiddleware.updateCampaignAITrigger(userId,triggerId,trigger,accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignAITrigger(@RequestParam long userId,
                                                     @RequestParam String triggerId) {

        CampaignAITriggerWSModel response = campaignAiTriggerMiddleware.removeCampaignAITrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
