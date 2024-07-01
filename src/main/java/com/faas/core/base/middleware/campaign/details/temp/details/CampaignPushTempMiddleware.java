package com.faas.core.base.middleware.campaign.details.temp.details;

import com.faas.core.base.framework.campaign.details.temp.details.CampaignPushTempFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.temp.details.CampaignPushTempWSModel;
import com.faas.core.base.model.ws.campaign.details.temp.details.dto.CampaignPushTempWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignPushTempMiddleware {


    @Autowired
    CampaignPushTempFramework campaignPushTempFramework;


    public CampaignPushTempWSModel getCampaignPushTemps(long userId, String campaignId) {

        CampaignPushTempWSModel response = new CampaignPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignPushTempWSDTO> campaignPushTempWSDTOS = campaignPushTempFramework.getCampaignPushTempsService(userId,campaignId);
        if (campaignPushTempWSDTOS != null) {
            response.setCampaignPushTemps(campaignPushTempWSDTOS);
        }

        general.setOperation("getCampaignPushTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignPushTempWSModel getCampaignPushTemp(long userId, String tempId) {

        CampaignPushTempWSModel response = new CampaignPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignPushTempWSDTO> campaignPushTempWSDTOS = new ArrayList<>();

        CampaignPushTempWSDTO campaignPushTempWSDTO = campaignPushTempFramework.getCampaignPushTempService(userId,tempId);
        if (campaignPushTempWSDTO != null) {
            campaignPushTempWSDTOS.add(campaignPushTempWSDTO);
        }

        response.setCampaignPushTemps(campaignPushTempWSDTOS);
        general.setOperation("getCampaignPushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignPushTempWSModel createCampaignPushTemp(long userId, String campaignId, String pushHeader, String pushBody, String pushSender, long typeId) {

        CampaignPushTempWSModel response = new CampaignPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignPushTempWSDTO> campaignPushTempWSDTOS = new ArrayList<>();

        CampaignPushTempWSDTO campaignPushTempWSDTO = campaignPushTempFramework.createCampaignPushTempService(userId,campaignId,pushHeader,pushBody,pushSender,typeId);
        if (campaignPushTempWSDTO != null) {
            campaignPushTempWSDTOS.add(campaignPushTempWSDTO);
        }

        response.setCampaignPushTemps(campaignPushTempWSDTOS);
        general.setOperation("createCampaignPushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignPushTempWSModel updateCampaignPushTemp(long userId, String tempId, String pushHeader, String pushBody, String pushSender, long typeId) {

        CampaignPushTempWSModel response = new CampaignPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignPushTempWSDTO> campaignPushTempWSDTOS = new ArrayList<>();

        CampaignPushTempWSDTO campaignPushTempWSDTO = campaignPushTempFramework.updateCampaignPushTempService(userId,tempId,pushHeader,pushBody,pushSender,typeId);
        if (campaignPushTempWSDTO != null) {
            campaignPushTempWSDTOS.add(campaignPushTempWSDTO);
        }

        response.setCampaignPushTemps(campaignPushTempWSDTOS);
        general.setOperation("updateCampaignPushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignPushTempWSModel removeCampaignPushTemp(long userId, String tempId) {

        CampaignPushTempWSModel response = new CampaignPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignPushTempWSDTO> campaignPushTempWSDTOS = new ArrayList<>();

        CampaignPushTempWSDTO campaignPushTempWSDTO = campaignPushTempFramework.removeCampaignPushTempService(tempId);
        if (campaignPushTempWSDTO != null) {
            campaignPushTempWSDTOS.add(campaignPushTempWSDTO);
        }

        response.setCampaignPushTemps(campaignPushTempWSDTOS);
        general.setOperation("removeCampaignPushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
