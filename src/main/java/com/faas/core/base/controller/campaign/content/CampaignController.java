package com.faas.core.base.controller.campaign.content;

import com.faas.core.base.middleware.campaign.content.CampaignMiddleware;
import com.faas.core.data.ws.base.campaign.content.CampaignWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/")
public class CampaignController {


    @Autowired
    CampaignMiddleware campaignMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaigns(@RequestParam long userId) {

        CampaignWSModel response = campaignMiddleware.getCampaigns(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGNS_BY_CATEGORY, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignsByCategory(@RequestParam long userId,
                                                    @RequestParam String campaignCategory) {

        CampaignWSModel response = campaignMiddleware.getCampaignsByCategory(userId, campaignCategory);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGNS_BY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignsByState(@RequestParam long userId,
                                                 @RequestParam String campaignState) {

        CampaignWSModel response = campaignMiddleware.getCampaignsByState(userId, campaignState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaign(@RequestParam long userId,
                                         @RequestParam String campaignId) {

        CampaignWSModel response = campaignMiddleware.getCampaign(userId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaign(@RequestParam long userId,
                                            @RequestParam String campaign,
                                            @RequestParam String campaignDesc,
                                            @RequestParam long campaignTypeId,
                                            @RequestParam String campaignCategory) {

        CampaignWSModel response = campaignMiddleware.createCampaign(userId, campaign, campaignDesc, campaignTypeId, campaignCategory);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaign(@RequestParam long userId,
                                            @RequestParam String campaignId,
                                            @RequestParam String campaign,
                                            @RequestParam String campaignDesc,
                                            @RequestParam String campaignState) {

        CampaignWSModel response = campaignMiddleware.updateCampaign(userId, campaignId, campaign, campaignDesc, campaignState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaign(@RequestParam long userId,
                                            @RequestParam String campaignId) {

        CampaignWSModel response = campaignMiddleware.removeCampaign(userId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
