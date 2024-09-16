package com.faas.core.base.middleware.campaign.details.channel;

import com.faas.core.base.framework.campaign.details.channel.CampaignChannelFramework;
import com.faas.core.data.ws.base.campaign.details.channel.*;
import com.faas.core.data.ws.base.campaign.details.channel.dto.*;
import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CampaignChannelMiddleware {


    @Autowired
    CampaignChannelFramework campaignChannelFramework;


    public CampaignChannelWSModel getCampaignChannels(long userId, String campaignId) {

        CampaignChannelWSModel response = new CampaignChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignChannelWSDTO campaignChannelWSDTO = campaignChannelFramework.getCampaignChannelsService(userId, campaignId);
        if (campaignChannelWSDTO != null) {
            response.setCampaignChannel(campaignChannelWSDTO);
        }

        general.setOperation("getCampaignChannels");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignSipChannelWSModel getCampaignSipChannel(long userId, String campaignId) {

        CampaignSipChannelWSModel response = new CampaignSipChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignSipChannelWSDTO campaignSipChannelWSDTO = campaignChannelFramework.getCampaignSipChannelService(userId, campaignId);
        if (campaignSipChannelWSDTO != null) {
            response.setCampaignSipChannel(campaignSipChannelWSDTO);
        }

        general.setOperation("getCampaignSipChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignSipChannelWSModel createCampaignSipChannel(long userId, String campaignId, String callerId, String state) {

        CampaignSipChannelWSModel response = new CampaignSipChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignSipChannelWSDTO campaignSipChannelWSDTO = campaignChannelFramework.createCampaignSipChannelService(userId, campaignId, callerId, state);
        if (campaignSipChannelWSDTO != null) {
            response.setCampaignSipChannel(campaignSipChannelWSDTO);
        }

        general.setOperation("createCampaignSipChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignSipChannelWSModel removeCampaignSipChannel(long userId, String campaignId) {

        CampaignSipChannelWSModel response = new CampaignSipChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignSipChannelWSDTO campaignSipChannelWSDTO = campaignChannelFramework.removeCampaignSipChannelService(userId, campaignId);
        if (campaignSipChannelWSDTO != null) {
            response.setCampaignSipChannel(campaignSipChannelWSDTO);
        }

        general.setOperation("removeCampaignSipChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignSmsChannelWSModel getCampaignSmsChannel(long userId, String campaignId) {

        CampaignSmsChannelWSModel response = new CampaignSmsChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignSmsChannelWSDTO campaignSmsChannelWSDTO = campaignChannelFramework.getCampaignSmsChannelService(userId, campaignId);
        if (campaignSmsChannelWSDTO != null) {
            response.setCampaignSmsChannel(campaignSmsChannelWSDTO);
        }

        general.setOperation("getCampaignSmsChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignSmsChannelWSModel createCampaignSmsChannel(long userId, String campaignId, String accountId, String state) {

        CampaignSmsChannelWSModel response = new CampaignSmsChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignSmsChannelWSDTO campaignSmsChannelWSDTO = campaignChannelFramework.createCampaignSmsChannelService(userId, campaignId, accountId, state);
        if (campaignSmsChannelWSDTO != null) {
            response.setCampaignSmsChannel(campaignSmsChannelWSDTO);
        }

        general.setOperation("createCampaignSmsChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignSmsChannelWSModel removeCampaignSmsChannel(long userId, String campaignId) {

        CampaignSmsChannelWSModel response = new CampaignSmsChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignSmsChannelWSDTO campaignSmsChannelWSDTO = campaignChannelFramework.removeCampaignSmsChannelService(campaignId);
        if (campaignSmsChannelWSDTO != null) {
            response.setCampaignSmsChannel(campaignSmsChannelWSDTO);
        }

        general.setOperation("removeCampaignSmsChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignWappChannelWSModel getCampaignWappChannel(long userId, String campaignId) {

        CampaignWappChannelWSModel response = new CampaignWappChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignWappChannelWSDTO campaignWappChannelWSDTO = campaignChannelFramework.getCampaignWappChannelService(userId, campaignId);
        if (campaignWappChannelWSDTO != null) {
            response.setCampaignWappChannel(campaignWappChannelWSDTO);
        }

        general.setOperation("getCampaignWappChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWappChannelWSModel createCampaignWappChannel(long userId, String campaignId, String callState, String messageState) {

        CampaignWappChannelWSModel response = new CampaignWappChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignWappChannelWSDTO campaignWappChannelWSDTO = campaignChannelFramework.createCampaignWappChannelService(userId, campaignId, callState, messageState);
        if (campaignWappChannelWSDTO != null) {
            response.setCampaignWappChannel(campaignWappChannelWSDTO);
        }

        general.setOperation("createCampaignWappChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWappChannelWSModel removeCampaignWappChannel(long userId, String campaignId) {

        CampaignWappChannelWSModel response = new CampaignWappChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignWappChannelWSDTO campaignWappChannelWSDTO = campaignChannelFramework.removeCampaignWappChannelService(userId, campaignId);
        if (campaignWappChannelWSDTO != null) {
            response.setCampaignWappChannel(campaignWappChannelWSDTO);
        }

        general.setOperation("removeCampaignWappChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignEmailChannelWSModel getCampaignEmailChannel(long userId, String campaignId) {

        CampaignEmailChannelWSModel response = new CampaignEmailChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignEmailChannelWSDTO campaignEmailChannelWSDTO = campaignChannelFramework.getCampaignEmailChannelService(userId, campaignId);
        if (campaignEmailChannelWSDTO != null) {
            response.setCampaignEmailChannel(campaignEmailChannelWSDTO);
        }

        general.setOperation("getCampaignEmailChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignEmailChannelWSModel createCampaignEmailChannel(long userId, String campaignId, String accountId, String state) {

        CampaignEmailChannelWSModel response = new CampaignEmailChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignEmailChannelWSDTO campaignEmailChannelWSDTO = campaignChannelFramework.createCampaignEmailChannelService(userId, campaignId, accountId, state);
        if (campaignEmailChannelWSDTO != null) {
            response.setCampaignEmailChannel(campaignEmailChannelWSDTO);
        }

        general.setOperation("createCampaignEmailChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignEmailChannelWSModel removeCampaignEmailChannel(long userId, String campaignId) {

        CampaignEmailChannelWSModel response = new CampaignEmailChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignEmailChannelWSDTO campaignEmailChannelWSDTO = campaignChannelFramework.removeCampaignEmailChannelService(userId, campaignId);
        if (campaignEmailChannelWSDTO != null) {
            response.setCampaignEmailChannel(campaignEmailChannelWSDTO);
        }

        general.setOperation("removeCampaignEmailChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignPushChannelWSModel getCampaignPushChannel(long userId, String campaignId) {

        CampaignPushChannelWSModel response = new CampaignPushChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignPushChannelWSDTO campaignPushChannelWSDTO = campaignChannelFramework.getCampaignPushChannelService(userId, campaignId);
        if (campaignPushChannelWSDTO != null) {
            response.setCampaignPushChannel(campaignPushChannelWSDTO);
        }

        general.setOperation("getCampaignPushChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignPushChannelWSModel createCampaignPushChannel(long userId, String campaignId, String accountId, String state) {

        CampaignPushChannelWSModel response = new CampaignPushChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignPushChannelWSDTO campaignPushChannelWSDTO = campaignChannelFramework.createCampaignPushChannelService(userId, campaignId, accountId, state);
        if (campaignPushChannelWSDTO != null) {
            response.setCampaignPushChannel(campaignPushChannelWSDTO);
        }

        general.setOperation("createCampaignPushChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignPushChannelWSModel removeCampaignPushChannel(long userId, String campaignId) {

        CampaignPushChannelWSModel response = new CampaignPushChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignPushChannelWSDTO campaignPushChannelWSDTO = campaignChannelFramework.removeCampaignPushChannelService(userId, campaignId);
        if (campaignPushChannelWSDTO != null) {
            response.setCampaignPushChannel(campaignPushChannelWSDTO);
        }

        general.setOperation("removeCampaignPushChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
