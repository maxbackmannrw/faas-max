package com.faas.core.base.endpoint.controller.campaign.settings;

import com.faas.core.base.middleware.campaign.settings.CampaignSettingsMiddleware;
import com.faas.core.base.model.ws.campaign.settings.CampaignTypeWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/settings/")
public class CampaignSettingsController {


    @Autowired
    CampaignSettingsMiddleware campaignSettingsMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_CAMPAIGN_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllCampaignTypes(@RequestParam long userId) {

        CampaignTypeWSModel response = campaignSettingsMiddleware.getAllCampaignTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignType(@RequestParam long userId,
                                             @RequestParam long typeId) {

        CampaignTypeWSModel response = campaignSettingsMiddleware.getCampaignType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignType(@RequestParam long userId,
                                                @RequestParam String campaignType) {

        CampaignTypeWSModel response = campaignSettingsMiddleware.createCampaignType(userId, campaignType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignType(@RequestParam long userId,
                                                @RequestParam long typeId,
                                                @RequestParam String campaignType) {

        CampaignTypeWSModel response = campaignSettingsMiddleware.updateCampaignType(userId, typeId, campaignType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignType(@RequestParam long userId,
                                                @RequestParam long typeId) {

        CampaignTypeWSModel response = campaignSettingsMiddleware.removeCampaignType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }




}

