package com.faas.core.base.middleware.campaign.details.temp.details;

import com.faas.core.base.framework.campaign.details.temp.details.CampaignSmsTempFramework;
import com.faas.core.base.model.ws.campaign.details.temp.details.CampaignSmsTempWSModel;
import com.faas.core.base.model.ws.campaign.details.temp.details.dto.CampaignSmsTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignSmsTempMiddleware {


    @Autowired
    CampaignSmsTempFramework campaignSmsTempFramework;


    public CampaignSmsTempWSModel getCampaignSmsTemps(long userId, String campaignId) {

        CampaignSmsTempWSModel response = new CampaignSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignSmsTempWSDTO> campaignSmsTempWSDTOS = campaignSmsTempFramework.getCampaignSmsTempsService(userId, campaignId);
        if (campaignSmsTempWSDTOS != null) {
            response.setCampaignSmsTemps(campaignSmsTempWSDTOS);
        }

        general.setOperation("getCampaignSmsTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignSmsTempWSModel getCampaignSmsTemp(long userId, String tempId) {

        CampaignSmsTempWSModel response = new CampaignSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignSmsTempWSDTO> campaignSmsTempWSDTOS = new ArrayList<>();

        CampaignSmsTempWSDTO campaignSmsTempWSDTO = campaignSmsTempFramework.getCampaignSmsTempService(userId, tempId);
        if (campaignSmsTempWSDTO != null) {
            campaignSmsTempWSDTOS.add(campaignSmsTempWSDTO);
        }

        response.setCampaignSmsTemps(campaignSmsTempWSDTOS);
        general.setOperation("getCampaignSmsTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignSmsTempWSModel createCampaignSmsTemp(long userId, String campaignId, String smsTitle, String smsBody, String senderId, long typeId) {

        CampaignSmsTempWSModel response = new CampaignSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignSmsTempWSDTO> campaignSmsTempWSDTOS = new ArrayList<>();

        CampaignSmsTempWSDTO campaignSmsTempWSDTO = campaignSmsTempFramework.createCampaignSmsTempService(userId, campaignId, smsTitle, smsBody, senderId, typeId);
        if (campaignSmsTempWSDTO != null) {
            campaignSmsTempWSDTOS.add(campaignSmsTempWSDTO);
        }

        response.setCampaignSmsTemps(campaignSmsTempWSDTOS);
        general.setOperation("createCampaignSmsTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignSmsTempWSModel updateCampaignSmsTemp(long userId, String tempId, String smsTitle, String smsBody, String senderId, long typeId) {

        CampaignSmsTempWSModel response = new CampaignSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignSmsTempWSDTO> campaignSmsTempWSDTOS = new ArrayList<>();

        CampaignSmsTempWSDTO campaignSmsTempWSDTO = campaignSmsTempFramework.updateCampaignSmsTempService(userId, tempId, smsTitle, smsBody, senderId, typeId);
        if (campaignSmsTempWSDTO != null) {
            campaignSmsTempWSDTOS.add(campaignSmsTempWSDTO);
        }

        response.setCampaignSmsTemps(campaignSmsTempWSDTOS);
        general.setOperation("updateCampaignSmsTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignSmsTempWSModel removeCampaignSmsTemp(long userId, String tempId) {

        CampaignSmsTempWSModel response = new CampaignSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignSmsTempWSDTO> campaignSmsTempWSDTOS = new ArrayList<>();

        CampaignSmsTempWSDTO campaignSmsTempWSDTO = campaignSmsTempFramework.removeCampaignSmsTempService(userId, tempId);
        if (campaignSmsTempWSDTO != null) {
            campaignSmsTempWSDTOS.add(campaignSmsTempWSDTO);
        }

        response.setCampaignSmsTemps(campaignSmsTempWSDTOS);
        general.setOperation("removeCampaignSmsTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
