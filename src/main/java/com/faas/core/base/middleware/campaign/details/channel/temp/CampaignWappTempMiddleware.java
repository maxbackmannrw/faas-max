package com.faas.core.base.middleware.campaign.details.channel.temp;

import com.faas.core.base.framework.campaign.details.channel.temp.CampaignWappTempFramework;
import com.faas.core.base.model.ws.campaign.details.channel.temp.CampaignWappMessageTempWSModel;
import com.faas.core.base.model.ws.campaign.details.channel.temp.dto.CampaignWappMessageTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignWappTempMiddleware {


    @Autowired
    CampaignWappTempFramework campaignWappTempFramework;


    public CampaignWappMessageTempWSModel getCampaignWappMessageTemps(long userId, String campaignId) {

        CampaignWappMessageTempWSModel response = new CampaignWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignWappMessageTempWSDTO> campaignWappMessageTempWSDTOS = campaignWappTempFramework.getCampaignWappMessageTempsService(userId,campaignId);
        if (campaignWappMessageTempWSDTOS != null){
            response.setCampaignWappMessageTemps(campaignWappMessageTempWSDTOS);
        }

        general.setOperation("getCampaignWappMessageTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWappMessageTempWSModel getCampaignWappMessageTemp(long userId, String tempId) {

        CampaignWappMessageTempWSModel response = new CampaignWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWappMessageTempWSDTO> campaignWappMessageTempWSDTOS = new ArrayList<>();

        CampaignWappMessageTempWSDTO campaignWappMessageTempWSDTO = campaignWappTempFramework.getCampaignWappMessageTempService(userId,tempId);
        if (campaignWappMessageTempWSDTO != null){
            campaignWappMessageTempWSDTOS.add(campaignWappMessageTempWSDTO);
        }

        response.setCampaignWappMessageTemps(campaignWappMessageTempWSDTOS);
        general.setOperation("getCampaignWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWappMessageTempWSModel createCampaignWappMessageTemp(long userId, String campaignId, String wappTitle, String wappBody, long typeId) {

        CampaignWappMessageTempWSModel response = new CampaignWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWappMessageTempWSDTO> campaignWappMessageTempWSDTOS = new ArrayList<>();

        CampaignWappMessageTempWSDTO campaignWappMessageTempWSDTO = campaignWappTempFramework.createCampaignWappMessageTempService(userId,campaignId,wappTitle,wappBody,typeId);
        if (campaignWappMessageTempWSDTO != null) {
            campaignWappMessageTempWSDTOS.add(campaignWappMessageTempWSDTO);
        }

        response.setCampaignWappMessageTemps(campaignWappMessageTempWSDTOS);
        general.setOperation("createCampaignWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWappMessageTempWSModel updateCampaignWappMessageTemp(long userId, String tempId, String wappTitle, String wappBody, long typeId) {

        CampaignWappMessageTempWSModel response = new CampaignWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWappMessageTempWSDTO> campaignWappMessageTempWSDTOS = new ArrayList<>();

        CampaignWappMessageTempWSDTO campaignWappMessageTempWSDTO = campaignWappTempFramework.updateCampaignWappMessageTempService(userId,tempId,wappTitle,wappBody,typeId);
        if (campaignWappMessageTempWSDTO != null) {
            campaignWappMessageTempWSDTOS.add(campaignWappMessageTempWSDTO);
        }

        response.setCampaignWappMessageTemps(campaignWappMessageTempWSDTOS);
        general.setOperation("updateCampaignWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWappMessageTempWSModel removeCampaignWappMessageTemp(long userId, String tempId) {

        CampaignWappMessageTempWSModel response = new CampaignWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWappMessageTempWSDTO> campaignWappMessageTempWSDTOS = new ArrayList<>();

        CampaignWappMessageTempWSDTO campaignWappMessageTempWSDTO = campaignWappTempFramework.removeCampaignWappMessageTempService(tempId);
        if (campaignWappMessageTempWSDTO != null) {
            campaignWappMessageTempWSDTOS.add(campaignWappMessageTempWSDTO);
        }

        response.setCampaignWappMessageTemps(campaignWappMessageTempWSDTOS);
        general.setOperation("removeCampaignWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
