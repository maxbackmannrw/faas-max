package com.faas.core.base.middleware.campaign.details.temp.details;

import com.faas.core.base.framework.campaign.details.temp.details.CampaignEmailTempFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.temp.details.CampaignEmailTempWSModel;
import com.faas.core.base.model.ws.campaign.details.temp.details.dto.CampaignEmailTempWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignEmailTempMiddleware {

    @Autowired
    CampaignEmailTempFramework campaignEmailTempFramework;


    public CampaignEmailTempWSModel getCampaignEmailTemps(long userId, String campaignId) {

        CampaignEmailTempWSModel response = new CampaignEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignEmailTempWSDTO> campaignEmailTempWSDTOS = campaignEmailTempFramework.getCampaignEmailTempsService(userId,campaignId);
        if (campaignEmailTempWSDTOS != null) {
            response.setCampaignEmailTemps(campaignEmailTempWSDTOS);
        }

        general.setOperation("getCampaignEmailTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignEmailTempWSModel getCampaignEmailTemp(long userId, String tempId) {

        CampaignEmailTempWSModel response = new CampaignEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignEmailTempWSDTO> campaignEmailTempWSDTOS = new ArrayList<>();

        CampaignEmailTempWSDTO campaignEmailTempWSDTO = campaignEmailTempFramework.getCampaignEmailTempService(userId,tempId);
        if (campaignEmailTempWSDTO != null) {
            campaignEmailTempWSDTOS.add(campaignEmailTempWSDTO);
        }

        response.setCampaignEmailTemps(campaignEmailTempWSDTOS);
        general.setOperation("getCampaignEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignEmailTempWSModel createCampaignEmailTemp(long userId, String campaignId, String emailSubject, String emailBody, String emailSender, long typeId) {

        CampaignEmailTempWSModel response = new CampaignEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignEmailTempWSDTO> campaignEmailTempWSDTOS = new ArrayList<>();

        CampaignEmailTempWSDTO campaignEmailTempWSDTO = campaignEmailTempFramework.createCampaignEmailTempService(userId,campaignId,emailSubject,emailBody,emailSender,typeId);
        if (campaignEmailTempWSDTO != null) {
            campaignEmailTempWSDTOS.add(campaignEmailTempWSDTO);
        }

        response.setCampaignEmailTemps(campaignEmailTempWSDTOS);
        general.setOperation("createCampaignEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignEmailTempWSModel updateCampaignEmailTemp(long userId, String tempId, String emailSubject, String emailBody, String emailSender, long typeId) {

        CampaignEmailTempWSModel response = new CampaignEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignEmailTempWSDTO> campaignEmailTempWSDTOS = new ArrayList<>();

        CampaignEmailTempWSDTO campaignEmailTempWSDTO = campaignEmailTempFramework.updateCampaignEmailTempService(tempId,emailSubject,emailBody,emailSender,typeId);
        if (campaignEmailTempWSDTO != null) {
            campaignEmailTempWSDTOS.add(campaignEmailTempWSDTO);
        }

        response.setCampaignEmailTemps(campaignEmailTempWSDTOS);
        general.setOperation("updateCampaignEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignEmailTempWSModel removeCampaignEmailTemp(long userId, String tempId) {

        CampaignEmailTempWSModel response = new CampaignEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignEmailTempWSDTO> campaignEmailTempWSDTOS = new ArrayList<>();

        CampaignEmailTempWSDTO campaignEmailTempWSDTO = campaignEmailTempFramework.removeCampaignEmailTempService(tempId);
        if (campaignEmailTempWSDTO != null) {
            campaignEmailTempWSDTOS.add(campaignEmailTempWSDTO);
        }

        response.setCampaignEmailTemps(campaignEmailTempWSDTOS);
        general.setOperation("removeCampaignEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
