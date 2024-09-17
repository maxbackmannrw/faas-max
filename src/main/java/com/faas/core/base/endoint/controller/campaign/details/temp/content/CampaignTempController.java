package com.faas.core.base.endoint.controller.campaign.details.temp.content;

import com.faas.core.base.middleware.campaign.details.temp.content.CampaignTempMiddleware;
import com.faas.core.base.model.ws.campaign.details.temp.content.CampaignTempWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/temp/")
public class CampaignTempController {


    @Autowired
    CampaignTempMiddleware campaignTempMiddleware;

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignTemps(@RequestParam long userId,
                                              @RequestParam String campaignId) {

        CampaignTempWSModel response = campaignTempMiddleware.getCampaignTemps(userId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
