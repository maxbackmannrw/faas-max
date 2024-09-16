package com.faas.core.base.middleware.campaign.content;

import com.faas.core.base.framework.campaign.content.CampaignFramework;
import com.faas.core.data.ws.base.campaign.content.CampaignWSModel;
import com.faas.core.data.ws.base.campaign.content.dto.CampaignWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CampaignMiddleware {


    @Autowired
    CampaignFramework campaignFramework;


    public CampaignWSModel getCampaigns(long userId) {

        CampaignWSModel response = new CampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignWSDTO> campaignWSDTOS = campaignFramework.getCampaignsService(userId);
        if (campaignWSDTOS != null) {
            response.setCampaigns(campaignWSDTOS);
        }

        general.setOperation("getCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWSModel getCampaignsByCategory(long userId, String campaignCategory) {

        CampaignWSModel response = new CampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignWSDTO> campaignWSDTOS = campaignFramework.getCampaignsByCategoryService(userId, campaignCategory);
        if (campaignWSDTOS != null) {
            response.setCampaigns(campaignWSDTOS);
        }

        general.setOperation("getCampaignsByCategory");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWSModel getCampaignsByState(long userId, String campaignState) {

        CampaignWSModel response = new CampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignWSDTO> campaignWSDTOS = campaignFramework.getCampaignsByStateService(userId, campaignState);
        if (campaignWSDTOS != null) {
            response.setCampaigns(campaignWSDTOS);
        }

        general.setOperation("getCampaignsByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWSModel getCampaign(long userId, String campaignId) {

        CampaignWSModel response = new CampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWSDTO> campaignWSDTOS = new ArrayList<>();

        CampaignWSDTO campaignWSDTO = campaignFramework.getCampaignService(userId, campaignId);
        if (campaignWSDTO != null) {
            campaignWSDTOS.add(campaignWSDTO);
        }

        response.setCampaigns(campaignWSDTOS);
        general.setOperation("getCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWSModel createCampaign(long userId, String campaign, String campaignDesc, long campaignTypeId, String campaignCategory) {

        CampaignWSModel response = new CampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWSDTO> campaignWSDTOS = new ArrayList<>();

        CampaignWSDTO campaignWSDTO = campaignFramework.createCampaignService(userId, campaign, campaignDesc, campaignTypeId, campaignCategory);
        if (campaignWSDTO != null) {
            campaignWSDTOS.add(campaignWSDTO);
        }

        response.setCampaigns(campaignWSDTOS);
        general.setOperation("createCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWSModel updateCampaign(long userId, String campaignId, String campaign, String campaignDesc, String campaignState) {

        CampaignWSModel response = new CampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWSDTO> campaignWSDTOS = new ArrayList<>();

        CampaignWSDTO campaignWSDTO = campaignFramework.updateCampaignService(userId, campaignId, campaign, campaignDesc, campaignState);
        if (campaignWSDTO != null) {
            campaignWSDTOS.add(campaignWSDTO);
        }

        response.setCampaigns(campaignWSDTOS);
        general.setOperation("updateCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWSModel removeCampaign(long userId, String campaignId) {

        CampaignWSModel response = new CampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWSDTO> campaignWSDTOS = new ArrayList<>();

        CampaignWSDTO campaignWSDTO = campaignFramework.removeCampaignService(campaignId);
        if (campaignWSDTO != null) {
            campaignWSDTOS.add(campaignWSDTO);
        }

        response.setCampaigns(campaignWSDTOS);
        general.setOperation("removeCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
