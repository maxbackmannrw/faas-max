package com.faas.core.base.middleware.campaign.settings;

import com.faas.core.base.framework.campaign.settings.CampaignSettingsFramework;
import com.faas.core.base.model.ws.campaign.settings.CampaignTypeWSModel;
import com.faas.core.base.model.ws.campaign.settings.TriggerTypeWSModel;
import com.faas.core.base.model.ws.campaign.settings.dto.CampaignTypeWSDTO;
import com.faas.core.base.model.ws.campaign.settings.dto.TriggerTypeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.data.repo.campaign.settings.CampaignTypeRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CampaignSettingsMiddleware {


    @Autowired
    CampaignSettingsFramework campaignSettingsFramework;

    @Autowired
    CampaignTypeRepository campaignTypeRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignTypeWSModel getCampaignTypes(long userId) {

        CampaignTypeWSModel response = new CampaignTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignTypeWSDTO> campaignTypeWSDTOS = campaignSettingsFramework.getCampaignTypesService(userId);
        if (campaignTypeWSDTOS != null) {
            response.setCampaignTypes(campaignTypeWSDTOS);
        }

        general.setOperation("getCampaignTypes");
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

        CampaignTypeWSDTO campaignTypeWSDTO = campaignSettingsFramework.getCampaignTypeService(userId, typeId);
        if (campaignTypeWSDTO != null) {
            campaignTypeWSDTOS.add(campaignTypeWSDTO);
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

        CampaignTypeWSDTO campaignTypeWSDTO = campaignSettingsFramework.createCampaignTypeService(campaignType);
        if (campaignTypeWSDTO != null) {
            campaignTypeWSDTOS.add(campaignTypeWSDTO);
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

        CampaignTypeWSDTO campaignTypeWSDTO = campaignSettingsFramework.updateCampaignTypeService(typeId, campaignType);
        if (campaignTypeWSDTO != null) {
            campaignTypeWSDTOS.add(campaignTypeWSDTO);
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

        CampaignTypeWSDTO campaignTypeWSDTO = campaignSettingsFramework.removeCampaignTypeService(typeId);
        if (campaignTypeWSDTO != null) {
            campaignTypeWSDTOS.add(campaignTypeWSDTO);
        }

        response.setCampaignTypes(campaignTypeWSDTOS);
        general.setOperation("removeCampaignType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public TriggerTypeWSModel getTriggerTypes(long userId) {

        TriggerTypeWSModel response = new TriggerTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<TriggerTypeWSDTO> triggerTypeWSDTOS = campaignSettingsFramework.getTriggerTypesService(userId);
        if (triggerTypeWSDTOS != null) {
            response.setTriggerTypes(triggerTypeWSDTOS);
        }

        general.setOperation("getTriggerTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public TriggerTypeWSModel getTriggerTypesByBase(long userId, String baseType) {

        TriggerTypeWSModel response = new TriggerTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<TriggerTypeWSDTO> triggerTypeWSDTOS = campaignSettingsFramework.getTriggerTypesByBaseService(userId, baseType);
        if (triggerTypeWSDTOS != null) {
            response.setTriggerTypes(triggerTypeWSDTOS);
        }

        general.setOperation("getTriggerTypesByBase");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public TriggerTypeWSModel getTriggerType(long userId, long typeId) {

        TriggerTypeWSModel response = new TriggerTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerTypeWSDTO> triggerTypeWSDTOS = new ArrayList<>();

        TriggerTypeWSDTO triggerTypeWSDTO = campaignSettingsFramework.getTriggerTypeService(userId, typeId);
        if (triggerTypeWSDTO != null) {
            triggerTypeWSDTOS.add(triggerTypeWSDTO);
        }

        response.setTriggerTypes(triggerTypeWSDTOS);
        general.setOperation("getTriggerType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public TriggerTypeWSModel createTriggerType(long userId, String triggerType, String baseType) {

        TriggerTypeWSModel response = new TriggerTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerTypeWSDTO> triggerTypeWSDTOS = new ArrayList<>();

        TriggerTypeWSDTO triggerTypeWSDTO = campaignSettingsFramework.createTriggerTypeService(userId, triggerType, baseType);
        if (triggerTypeWSDTO != null) {
            triggerTypeWSDTOS.add(triggerTypeWSDTO);
        }

        response.setTriggerTypes(triggerTypeWSDTOS);
        general.setOperation("createTriggerType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public TriggerTypeWSModel updateTriggerType(long userId, long typeId, String triggerType, String baseType) {

        TriggerTypeWSModel response = new TriggerTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerTypeWSDTO> triggerTypeWSDTOS = new ArrayList<>();

        TriggerTypeWSDTO triggerTypeWSDTO = campaignSettingsFramework.updateTriggerTypeService(userId, typeId, triggerType, baseType);
        if (triggerTypeWSDTO != null) {
            triggerTypeWSDTOS.add(triggerTypeWSDTO);
        }

        response.setTriggerTypes(triggerTypeWSDTOS);
        general.setOperation("updateTriggerType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public TriggerTypeWSModel removeTriggerType(long userId, long typeId) {

        TriggerTypeWSModel response = new TriggerTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerTypeWSDTO> triggerTypeWSDTOS = new ArrayList<>();

        TriggerTypeWSDTO triggerTypeWSDTO = campaignSettingsFramework.removeTriggerTypeService(userId, typeId);
        if (triggerTypeWSDTO != null) {
            triggerTypeWSDTOS.add(triggerTypeWSDTO);
        }

        response.setTriggerTypes(triggerTypeWSDTOS);
        general.setOperation("removeTriggerType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
