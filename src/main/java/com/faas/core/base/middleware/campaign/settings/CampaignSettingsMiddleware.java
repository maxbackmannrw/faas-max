package com.faas.core.base.middleware.campaign.settings;

import com.faas.core.base.framework.campaign.settings.CampaignSettingsFramework;
import com.faas.core.base.model.db.campaign.settings.CampaignTypeDBModel;
import com.faas.core.base.model.ws.campaign.settings.CampaignTypeWSModel;
import com.faas.core.base.model.ws.campaign.settings.dto.CampaignTypeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.campaign.settings.CampaignTypeRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CampaignSettingsMiddleware {


    @Autowired
    CampaignSettingsFramework campaignSettingsFramework;

    @Autowired
    CampaignTypeRepository campaignTypeRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignTypeWSModel getAllCampaignTypes(long userId) {

        CampaignTypeWSModel response = new CampaignTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignTypeWSDTO> campaignTypeWSDTOS = new ArrayList<>();

        List<CampaignTypeDBModel> campaignTypeDBModels = campaignTypeRepository.findByStatus(1);
        if (campaignTypeDBModels.size() > 0) {
            for (CampaignTypeDBModel campaignTypeDBModel : campaignTypeDBModels) {
                campaignTypeWSDTOS.add(campaignSettingsFramework.fillCampaignTypeWSDTO(campaignTypeDBModel));
            }
        }

        response.setCampaignTypes(campaignTypeWSDTOS);
        general.setOperation("getAllCampaignTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignTypeWSModel getCampaignType(long userId, long typeId) {

        CampaignTypeWSModel response = new CampaignTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignTypeWSDTO> campaignTypeWSDTOS = new ArrayList<>();

        Optional<CampaignTypeDBModel> campaignTypeDBModel = campaignTypeRepository.findById(typeId);
        if (campaignTypeDBModel.isPresent()) {
            campaignTypeWSDTOS.add(campaignSettingsFramework.fillCampaignTypeWSDTO(campaignTypeDBModel.get()));
        }

        response.setCampaignTypes(campaignTypeWSDTOS);
        general.setOperation("getCampaignType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignTypeWSModel createCampaignType(long userId, String campaignType) {

        CampaignTypeWSModel response = new CampaignTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignTypeWSDTO> campaignTypeWSDTOS = new ArrayList<>();

        CampaignTypeDBModel campaignTypeDBModel = campaignSettingsFramework.createCampaignType(campaignType);
        if (campaignTypeDBModel != null) {
            campaignTypeWSDTOS.add(campaignSettingsFramework.fillCampaignTypeWSDTO(campaignTypeDBModel));
        }

        response.setCampaignTypes(campaignTypeWSDTOS);
        general.setOperation("createCampaignType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignTypeWSModel updateCampaignType(long userId, long typeId, String campaignType) {

        CampaignTypeWSModel response = new CampaignTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignTypeWSDTO> campaignTypeWSDTOS = new ArrayList<>();

        CampaignTypeDBModel campaignTypeDBModel = campaignSettingsFramework.updateCampaignType(typeId, campaignType);
        if (campaignTypeDBModel != null) {
            campaignTypeWSDTOS.add(campaignSettingsFramework.fillCampaignTypeWSDTO(campaignTypeDBModel));
        }

        response.setCampaignTypes(campaignTypeWSDTOS);
        general.setOperation("updateCampaignType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignTypeWSModel removeCampaignType(long userId, long typeId) {

        CampaignTypeWSModel response = new CampaignTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignTypeWSDTO> campaignTypeWSDTOS = new ArrayList<>();

        CampaignTypeDBModel campaignTypeDBModel = campaignSettingsFramework.removeCampaignType(typeId);
        if (campaignTypeDBModel != null) {
            campaignTypeWSDTOS.add(campaignSettingsFramework.fillCampaignTypeWSDTO(campaignTypeDBModel));
        }

        response.setCampaignTypes(campaignTypeWSDTOS);
        general.setOperation("removeCampaignType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
