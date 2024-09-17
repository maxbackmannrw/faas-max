package com.faas.core.base.framework.campaign.settings;

import com.faas.core.data.db.campaign.settings.CampaignTypeDBModel;
import com.faas.core.data.db.campaign.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.campaign.settings.dto.CampaignTypeWSDTO;
import com.faas.core.base.model.ws.campaign.settings.dto.TriggerTypeWSDTO;
import com.faas.core.data.repo.campaign.settings.CampaignTypeRepository;
import com.faas.core.data.repo.campaign.settings.TriggerTypeRepository;
import com.faas.core.data.repo.scenario.settings.ScenarioTypeRepository;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CampaignSettingsFramework {

    @Autowired
    CampaignTypeRepository campaignTypeRepository;

    @Autowired
    ScenarioTypeRepository scenarioTypeRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<CampaignTypeWSDTO> getCampaignTypesService(long userId) {


        List<CampaignTypeWSDTO> campaignTypeWSDTOS = new ArrayList<>();
        List<CampaignTypeDBModel> campaignTypeDBModels = campaignTypeRepository.findByStatus(1);
        for (CampaignTypeDBModel campaignTypeDBModel : campaignTypeDBModels) {
            campaignTypeWSDTOS.add(new CampaignTypeWSDTO(campaignTypeDBModel));
        }
        return campaignTypeWSDTOS;
    }

    public CampaignTypeWSDTO getCampaignTypeService(long userId, long typeId) {

        Optional<CampaignTypeDBModel> campaignTypeDBModel = campaignTypeRepository.findById(typeId);
        if (campaignTypeDBModel.isPresent()) {
            return new CampaignTypeWSDTO(campaignTypeDBModel.get());
        }
        return null;
    }

    public CampaignTypeWSDTO createCampaignTypeService(String campaignType) {

        CampaignTypeDBModel campaignTypeDBModel = new CampaignTypeDBModel();
        campaignTypeDBModel.setCampaignType(campaignType);
        campaignTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        campaignTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        campaignTypeDBModel.setStatus(1);

        return new CampaignTypeWSDTO(campaignTypeRepository.save(campaignTypeDBModel));
    }

    public CampaignTypeWSDTO updateCampaignTypeService(long typeId, String campaignType) {

        Optional<CampaignTypeDBModel> campaignTypeDBModel = campaignTypeRepository.findById(typeId);
        if (campaignTypeDBModel.isPresent()) {
            campaignTypeDBModel.get().setCampaignType(campaignType);
            campaignTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            campaignTypeDBModel.get().setStatus(1);

            return new CampaignTypeWSDTO(campaignTypeRepository.save(campaignTypeDBModel.get()));
        }
        return null;
    }

    public CampaignTypeWSDTO removeCampaignTypeService(long typeId) {

        Optional<CampaignTypeDBModel> campaignTypeDBModel = campaignTypeRepository.findById(typeId);
        if (campaignTypeDBModel.isPresent()) {
            campaignTypeRepository.delete(campaignTypeDBModel.get());
            return new CampaignTypeWSDTO(campaignTypeDBModel.get());
        }
        return null;
    }


    public List<TriggerTypeWSDTO> getTriggerTypesService(long userId) {

        List<TriggerTypeWSDTO> triggerTypeWSDTOS = new ArrayList<>();
        List<TriggerTypeDBModel> triggerTypeDBModels = triggerTypeRepository.findByStatus(1);
        for (TriggerTypeDBModel triggerTypeDBModel : triggerTypeDBModels) {
            triggerTypeWSDTOS.add(new TriggerTypeWSDTO(triggerTypeDBModel));
        }
        return triggerTypeWSDTOS;
    }

    public List<TriggerTypeWSDTO> getTriggerTypesByBaseService(long userId, String baseType) {

        List<TriggerTypeWSDTO> triggerTypeWSDTOS = new ArrayList<>();
        List<TriggerTypeDBModel> triggerTypeDBModels = triggerTypeRepository.findByBaseType(baseType);
        for (TriggerTypeDBModel triggerTypeDBModel : triggerTypeDBModels) {
            triggerTypeWSDTOS.add(new TriggerTypeWSDTO(triggerTypeDBModel));
        }
        return triggerTypeWSDTOS;
    }

    public TriggerTypeWSDTO getTriggerTypeService(long userId, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()) {
            return new TriggerTypeWSDTO(triggerTypeDBModel.get());
        }
        return null;
    }

    public TriggerTypeWSDTO createTriggerTypeService(long userId, String triggerType, String baseType) {

        TriggerTypeDBModel triggerTypeDBModel = new TriggerTypeDBModel();
        triggerTypeDBModel.setTriggerType(triggerType);
        triggerTypeDBModel.setBaseType(baseType);
        triggerTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        triggerTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        triggerTypeDBModel.setStatus(1);

        return new TriggerTypeWSDTO(triggerTypeRepository.save(triggerTypeDBModel));
    }

    public TriggerTypeWSDTO updateTriggerTypeService(long userId, long typeId, String triggerType, String baseType) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()) {

            triggerTypeDBModel.get().setTriggerType(triggerType);
            triggerTypeDBModel.get().setBaseType(baseType);
            triggerTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());

            return new TriggerTypeWSDTO(triggerTypeRepository.save(triggerTypeDBModel.get()));
        }
        return null;
    }

    public TriggerTypeWSDTO removeTriggerTypeService(long userId, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()) {
            triggerTypeRepository.delete(triggerTypeDBModel.get());
            return new TriggerTypeWSDTO(triggerTypeDBModel.get());
        }
        return null;
    }


}
