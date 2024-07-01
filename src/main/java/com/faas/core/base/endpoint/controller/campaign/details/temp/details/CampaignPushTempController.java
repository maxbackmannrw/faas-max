package com.faas.core.base.endpoint.controller.campaign.details.temp.details;

import com.faas.core.base.middleware.campaign.details.temp.details.CampaignPushTempMiddleware;
import com.faas.core.base.model.ws.campaign.details.temp.details.CampaignPushTempWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/temp/push/")
public class CampaignPushTempController {


    @Autowired
    CampaignPushTempMiddleware campaignPushTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_PUSH_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignPushTemps(@RequestParam long userId,
                                                  @RequestParam String campaignId) {

        CampaignPushTempWSModel response = campaignPushTempMiddleware.getCampaignPushTemps(userId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignPushTemp(@RequestParam long userId,
                                                 @RequestParam String tempId) {

        CampaignPushTempWSModel response = campaignPushTempMiddleware.getCampaignPushTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignPushTemp(@RequestParam long userId,
                                                    @RequestParam String campaignId,
                                                    @RequestParam String pushHeader,
                                                    @RequestParam String pushBody,
                                                    @RequestParam String pushSender,
                                                    @RequestParam long typeId) {

        CampaignPushTempWSModel response = campaignPushTempMiddleware.createCampaignPushTemp(userId,campaignId,pushHeader,pushBody,pushSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignPushTemp(@RequestParam long userId,
                                                    @RequestParam String tempId,
                                                    @RequestParam String pushHeader,
                                                    @RequestParam String pushBody,
                                                    @RequestParam String pushSender,
                                                    @RequestParam long typeId) {

        CampaignPushTempWSModel response = campaignPushTempMiddleware.updateCampaignPushTemp(userId,tempId,pushHeader,pushBody,pushSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignPushTemp(@RequestParam long userId,
                                                    @RequestParam String tempId) {

        CampaignPushTempWSModel response = campaignPushTempMiddleware.removeCampaignPushTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
