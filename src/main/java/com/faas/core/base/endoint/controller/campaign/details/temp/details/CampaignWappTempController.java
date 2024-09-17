package com.faas.core.base.endoint.controller.campaign.details.temp.details;

import com.faas.core.base.middleware.campaign.details.temp.details.CampaignWappTempMiddleware;
import com.faas.core.base.model.ws.campaign.details.temp.details.CampaignWappMessageTempWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/temp/wapp/")
public class CampaignWappTempController {


    @Autowired
    CampaignWappTempMiddleware campaignWappTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_WAPP_MESSAGE_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignWappMessageTemps(@RequestParam long userId,
                                                         @RequestParam String campaignId) {

        CampaignWappMessageTempWSModel response = campaignWappTempMiddleware.getCampaignWappMessageTemps(userId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignWappMessageTemp(@RequestParam long userId,
                                                        @RequestParam String tempId) {

        CampaignWappMessageTempWSModel response = campaignWappTempMiddleware.getCampaignWappMessageTemp(userId, tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignWappMessageTemp(@RequestParam long userId,
                                                           @RequestParam String campaignId,
                                                           @RequestParam String wappTitle,
                                                           @RequestParam String wappBody,
                                                           @RequestParam long typeId) {

        CampaignWappMessageTempWSModel response = campaignWappTempMiddleware.createCampaignWappMessageTemp(userId, campaignId, wappTitle, wappBody, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignWappMessageTemp(@RequestParam long userId,
                                                           @RequestParam String tempId,
                                                           @RequestParam String wappTitle,
                                                           @RequestParam String wappBody,
                                                           @RequestParam long typeId) {

        CampaignWappMessageTempWSModel response = campaignWappTempMiddleware.updateCampaignWappMessageTemp(userId, tempId, wappTitle, wappBody, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignWappMessageTemp(@RequestParam long userId,
                                                           @RequestParam String tempId) {

        CampaignWappMessageTempWSModel response = campaignWappTempMiddleware.removeCampaignWappMessageTemp(userId, tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
