package com.faas.core.base.middleware.campaign.content;

import com.faas.core.base.framework.campaign.content.CampaignFramework;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.ws.campaign.content.CampaignWSModel;
import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CampaignMiddleware {

    @Autowired
    CampaignFramework campaignFramework;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignWSModel getAllCampaigns(long userId) {

        CampaignWSModel response = new CampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWSDTO> campaignWSDTOS = new ArrayList<>();

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByStatus(1);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            campaignWSDTOS.add(campaignFramework.fillCampaignWSDTO(campaignDBModel));
        }

        response.setCampaigns(campaignWSDTOS);
        general.setOperation("getAllCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignWSModel getCampaignsByState(long userId, String campaignState) {

        CampaignWSModel response = new CampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWSDTO> campaignWSDTOS = new ArrayList<>();

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignState(campaignState);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            campaignWSDTOS.add(campaignFramework.fillCampaignWSDTO(campaignDBModel));
        }

        response.setCampaigns(campaignWSDTOS);
        general.setOperation("getCampaignsByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignWSModel getCampaignsByType(long userId, String campaignType) {

        CampaignWSModel response = new CampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWSDTO> campaignWSDTOS = new ArrayList<>();

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignType(campaignType);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            campaignWSDTOS.add(campaignFramework.fillCampaignWSDTO(campaignDBModel));
        }

        response.setCampaigns(campaignWSDTOS);
        general.setOperation("getCampaignsByType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignWSModel getCampaignsByCategory(long userId, String campaignCategory) {

        CampaignWSModel response = new CampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWSDTO> campaignWSDTOS = new ArrayList<>();

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(campaignCategory);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            campaignWSDTOS.add(campaignFramework.fillCampaignWSDTO(campaignDBModel));
        }

        response.setCampaigns(campaignWSDTOS);
        general.setOperation("getCampaignsByCategory");
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

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {
            campaignWSDTOS.add(campaignFramework.fillCampaignWSDTO(campaignDBModel.get()));
        }

        response.setCampaigns(campaignWSDTOS);
        general.setOperation("getCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignWSModel createCampaign(long userId,String campaign,String campaignDesc,String category,long typeId,String processId) {

        CampaignWSModel response = new CampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWSDTO> campaignWSDTOS = new ArrayList<>();

        CampaignDBModel campaignDBModel = campaignFramework.createCampaignService(campaign,campaignDesc,category,typeId,processId);
        if (campaignDBModel != null) {
            campaignWSDTOS.add(campaignFramework.fillCampaignWSDTO(campaignDBModel));
        }

        response.setCampaigns(campaignWSDTOS);
        general.setOperation("createCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignWSModel updateCampaign(long userId,String campaignId,String campaign,String campaignDesc,String campaignState) {

        CampaignWSModel response = new CampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWSDTO> campaignWSDTOS = new ArrayList<>();

        CampaignDBModel campaignDBModel = campaignFramework.updateCampaignService(campaignId,campaign,campaignDesc,campaignState);
        if (campaignDBModel != null) {
            campaignWSDTOS.add(campaignFramework.fillCampaignWSDTO(campaignDBModel));
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

        CampaignDBModel campaignDBModel = campaignFramework.removeCampaignService(campaignId);
        if (campaignDBModel != null) {
            campaignWSDTOS.add(campaignFramework.fillCampaignWSDTO(campaignDBModel));
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
