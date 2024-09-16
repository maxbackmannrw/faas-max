package com.faas.core.base.controller.campaign.details.trigger.content;

import com.faas.core.base.middleware.campaign.details.trigger.content.CampaignTriggerMiddleware;
import com.faas.core.data.ws.base.campaign.details.trigger.content.CampaignTriggerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/trigger/")
public class CampaignTriggerController {


    @Autowired
    CampaignTriggerMiddleware campaignTriggerMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignTriggers(@RequestParam long userId,
                                                 @RequestParam String campaignId) {

        CampaignTriggerWSModel response = campaignTriggerMiddleware.getCampaignTriggers(userId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}