package com.faas.core.base.endpoint.controller.campaign.details.channel;

import com.faas.core.base.middleware.campaign.details.channel.CampaignChannelMiddleware;
import com.faas.core.base.model.ws.campaign.details.channel.CampaignChannelWSModel;
import com.faas.core.base.model.ws.campaign.details.channel.CampaignSipChannelWSModel;
import com.faas.core.base.model.ws.campaign.details.channel.CampaignWappChannelWSModel;
import com.faas.core.base.model.ws.campaign.details.channel.CampaignEmailChannelWSModel;
import com.faas.core.base.model.ws.campaign.details.channel.CampaignPushChannelWSModel;
import com.faas.core.base.model.ws.campaign.details.channel.CampaignSmsChannelWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/channel/")
public class CampaignChannelController {


    @Autowired
    CampaignChannelMiddleware campaignChannelMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_CHANNELS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignChannels(@RequestParam long userId,
                                                 @RequestParam String campaignId) {

        CampaignChannelWSModel response = campaignChannelMiddleware.getCampaignChannels(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_SIP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignSipChannel(@RequestParam long userId,
                                                   @RequestParam String campaignId) {

        CampaignSipChannelWSModel response = campaignChannelMiddleware.getCampaignSipChannel(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_SIP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignSipChannel(@RequestParam long userId,
                                                      @RequestParam String campaignId,
                                                      @RequestParam String callerId,
                                                      @RequestParam String state) {

        CampaignSipChannelWSModel response = campaignChannelMiddleware.createCampaignSipChannel(userId,campaignId,callerId,state);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_SIP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignSipChannel(@RequestParam long userId,
                                                      @RequestParam String campaignId) {

        CampaignSipChannelWSModel response = campaignChannelMiddleware.removeCampaignSipChannel(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_SMS_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignSmsChannel(@RequestParam long userId,
                                                   @RequestParam String campaignId) {

        CampaignSmsChannelWSModel response = campaignChannelMiddleware.getCampaignSmsChannel(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_SMS_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignSmsChannel(@RequestParam long userId,
                                                      @RequestParam String campaignId,
                                                      @RequestParam String accountId,
                                                      @RequestParam String state) {

        CampaignSmsChannelWSModel response = campaignChannelMiddleware.createCampaignSmsChannel(userId,campaignId,accountId,state);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_SMS_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignSmsChannel(@RequestParam long userId,
                                                      @RequestParam String campaignId) {

        CampaignSmsChannelWSModel response = campaignChannelMiddleware.removeCampaignSmsChannel(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_WAPP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignWappChannel(@RequestParam long userId,
                                                    @RequestParam String campaignId) {

        CampaignWappChannelWSModel response = campaignChannelMiddleware.getCampaignWappChannel(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_WAPP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignWappChannel(@RequestParam long userId,
                                                       @RequestParam String campaignId,
                                                       @RequestParam String callState,
                                                       @RequestParam String messageState) {

        CampaignWappChannelWSModel response = campaignChannelMiddleware.createCampaignWappChannel(userId,campaignId,callState,messageState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_WAPP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignWappChannel(@RequestParam long userId,
                                                       @RequestParam String campaignId) {

        CampaignWappChannelWSModel response = campaignChannelMiddleware.removeCampaignWappChannel(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_EMAIL_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignEmailChannel(@RequestParam long userId,
                                                     @RequestParam String campaignId) {

        CampaignEmailChannelWSModel response = campaignChannelMiddleware.getCampaignEmailChannel(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_EMAIL_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignEmailChannel(@RequestParam long userId,
                                                        @RequestParam String campaignId,
                                                        @RequestParam String accountId,
                                                        @RequestParam String state) {

        CampaignEmailChannelWSModel response = campaignChannelMiddleware.createCampaignEmailChannel(userId,campaignId,accountId,state);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_EMAIL_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignEmailChannel(@RequestParam long userId,
                                                        @RequestParam String campaignId) {

        CampaignEmailChannelWSModel response = campaignChannelMiddleware.removeCampaignEmailChannel(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_PUSH_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignPushChannel(@RequestParam long userId,
                                                    @RequestParam String campaignId) {

        CampaignPushChannelWSModel response = campaignChannelMiddleware.getCampaignPushChannel(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_PUSH_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignPushChannel(@RequestParam long userId,
                                                       @RequestParam String campaignId,
                                                       @RequestParam String accountId,
                                                       @RequestParam String state) {

        CampaignPushChannelWSModel response = campaignChannelMiddleware.createCampaignPushChannel(userId,campaignId,accountId,state);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_PUSH_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignPushChannel(@RequestParam long userId,
                                                       @RequestParam String campaignId) {

        CampaignPushChannelWSModel response = campaignChannelMiddleware.removeCampaignPushChannel(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
