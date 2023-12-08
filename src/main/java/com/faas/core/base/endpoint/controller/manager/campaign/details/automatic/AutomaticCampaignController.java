package com.faas.core.base.endpoint.controller.manager.campaign.details.automatic;

import com.faas.core.base.middleware.manager.campaign.details.automatic.AutomaticCampaignMiddleware;
import com.faas.core.base.model.ws.manager.campaign.content.CampaignManagerWSModel;
import com.faas.core.base.model.ws.manager.campaign.details.automatic.AutomaticCampaignWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/manager/campaign/automatic/")
public class AutomaticCampaignController {


    @Autowired
    AutomaticCampaignMiddleware automaticCampaignMiddleware;


    @RequestMapping(value = BaseRoute.GET_AUTOMATIC_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomaticCampaigns(@RequestParam long userId) {

        AutomaticCampaignWSModel response = automaticCampaignMiddleware.getAutomaticCampaigns(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_AUTOMATIC_CAMPAIGNS_BY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomaticCampaignsByState(@RequestParam long userId,
                                                          @RequestParam String campaignState) {

        AutomaticCampaignWSModel response = automaticCampaignMiddleware.getAutomaticCampaignsByState(userId,campaignState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_AUTOMATIC_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomaticCampaign(@RequestParam long userId,
                                                  @RequestParam String campaignId) {

        AutomaticCampaignWSModel response = automaticCampaignMiddleware.getAutomaticCampaign(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
