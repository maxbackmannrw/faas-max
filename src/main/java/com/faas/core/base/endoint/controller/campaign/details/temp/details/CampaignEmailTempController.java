package com.faas.core.base.endoint.controller.campaign.details.temp.details;

import com.faas.core.base.middleware.campaign.details.temp.details.CampaignEmailTempMiddleware;
import com.faas.core.base.model.ws.campaign.details.temp.details.CampaignEmailTempWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/temp/email/")
public class CampaignEmailTempController {


    @Autowired
    CampaignEmailTempMiddleware campaignEmailTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_EMAIL_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignEmailTemps(@RequestParam long userId,
                                                   @RequestParam String campaignId) {

        CampaignEmailTempWSModel response = campaignEmailTempMiddleware.getCampaignEmailTemps(userId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignEmailTemp(@RequestParam long userId,
                                                  @RequestParam String tempId) {

        CampaignEmailTempWSModel response = campaignEmailTempMiddleware.getCampaignEmailTemp(userId, tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignEmailTemp(@RequestParam long userId,
                                                     @RequestParam String campaignId,
                                                     @RequestParam String emailSubject,
                                                     @RequestParam String emailBody,
                                                     @RequestParam String emailSender,
                                                     @RequestParam long typeId) {

        CampaignEmailTempWSModel response = campaignEmailTempMiddleware.createCampaignEmailTemp(userId, campaignId, emailSubject, emailBody, emailSender, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignEmailTemp(@RequestParam long userId,
                                                     @RequestParam String tempId,
                                                     @RequestParam String emailSubject,
                                                     @RequestParam String emailBody,
                                                     @RequestParam String emailSender,
                                                     @RequestParam long typeId) {

        CampaignEmailTempWSModel response = campaignEmailTempMiddleware.updateCampaignEmailTemp(userId, tempId, emailSubject, emailBody, emailSender, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignEmailTemp(@RequestParam long userId,
                                                     @RequestParam String tempId) {

        CampaignEmailTempWSModel response = campaignEmailTempMiddleware.removeCampaignEmailTemp(userId, tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
