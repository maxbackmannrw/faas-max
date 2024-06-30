package com.faas.core.base.endpoint.controller.campaign.details.channel.temp;

import com.faas.core.base.middleware.campaign.details.channel.temp.CampaignSmsTempMiddleware;
import com.faas.core.base.model.ws.campaign.details.channel.temp.CampaignSmsTempWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/channel/temp/sms/")
public class CampaignSmsTempController {


    @Autowired
    CampaignSmsTempMiddleware campaignSmsTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_SMS_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignSmsTemps(@RequestParam long userId,
                                                 @RequestParam String campaignId) {

        CampaignSmsTempWSModel response = campaignSmsTempMiddleware.getCampaignSmsTemps(userId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_SMS_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignSmsTemp(@RequestParam long userId,
                                                @RequestParam String tempId) {

        CampaignSmsTempWSModel response = campaignSmsTempMiddleware.getCampaignSmsTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_SMS_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignSmsTemp(@RequestParam long userId,
                                                   @RequestParam String campaignId,
                                                   @RequestParam String smsTitle,
                                                   @RequestParam String smsBody,
                                                   @RequestParam String senderId,
                                                   @RequestParam long typeId) {

        CampaignSmsTempWSModel response = campaignSmsTempMiddleware.createCampaignSmsTemp(userId,campaignId,smsTitle,smsBody,senderId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_SMS_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignSmsTemp(@RequestParam long userId,
                                                   @RequestParam String tempId,
                                                   @RequestParam String smsTitle,
                                                   @RequestParam String smsBody,
                                                   @RequestParam String senderId,
                                                   @RequestParam long typeId) {

        CampaignSmsTempWSModel response = campaignSmsTempMiddleware.updateCampaignSmsTemp(userId,tempId,smsTitle,smsBody,senderId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_SMS_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignSmsTemp(@RequestParam long userId,
                                                   @RequestParam String tempId) {

        CampaignSmsTempWSModel response = campaignSmsTempMiddleware.removeCampaignSmsTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
