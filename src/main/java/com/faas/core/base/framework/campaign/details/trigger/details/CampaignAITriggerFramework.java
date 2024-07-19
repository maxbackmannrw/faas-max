package com.faas.core.base.framework.campaign.details.trigger.details;

import com.faas.core.base.model.db.campaign.details.trigger.*;
import com.faas.core.base.model.db.campaign.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.campaign.details.trigger.details.dto.CampaignAITriggerWSDTO;
import com.faas.core.base.repo.campaign.details.trigger.*;
import com.faas.core.base.repo.campaign.settings.TriggerTypeRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignAITriggerFramework {


    @Autowired
    AITriggerRepository aiTriggerRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<CampaignAITriggerWSDTO> getCampaignAITriggersService(long userId, String campaignId) {

        List<CampaignAITriggerWSDTO> campaignAiTriggerWSDTOS = new ArrayList<>();
        List<AITriggerDBModel> aiTriggerDBModels = aiTriggerRepository.findByCampaignId(campaignId);
        for (AITriggerDBModel aiTriggerDBModel : aiTriggerDBModels) {
            campaignAiTriggerWSDTOS.add(new CampaignAITriggerWSDTO(aiTriggerDBModel));
        }
        return campaignAiTriggerWSDTOS;
    }

    public CampaignAITriggerWSDTO getCampaignAITriggerService(long userId, String triggerId) {

        Optional<AITriggerDBModel> aiTriggerDBModel = aiTriggerRepository.findById(triggerId);
        if (aiTriggerDBModel.isPresent()){
            return new CampaignAITriggerWSDTO(aiTriggerDBModel.get());
        }
        return null;
    }

    public CampaignAITriggerWSDTO createCampaignAITriggerService(long userId, String campaignId, String trigger, String accountId, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            AITriggerDBModel aiTriggerDBModel = new AITriggerDBModel();
            aiTriggerDBModel.setCampaignId(campaignId);
            aiTriggerDBModel.setTrigger(trigger);
            aiTriggerDBModel.setAccountId(accountId);
            aiTriggerDBModel.setAccount(AppConstant.NONE);
            aiTriggerDBModel.setTriggerDatas(new ArrayList<>());
            aiTriggerDBModel.setTypeId(typeId);
            aiTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            aiTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            aiTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            aiTriggerDBModel.setStatus(1);

            return new CampaignAITriggerWSDTO(aiTriggerRepository.save(aiTriggerDBModel));
        }
        return null;
    }

    public CampaignAITriggerWSDTO updateCampaignAITriggerService(long userId, String triggerId, String trigger, String accountId) {

        Optional<AITriggerDBModel> aiTriggerDBModel = aiTriggerRepository.findById(triggerId);
        if (aiTriggerDBModel.isPresent()){

            aiTriggerDBModel.get().setTrigger(trigger);
            aiTriggerDBModel.get().setAccountId(accountId);
            aiTriggerDBModel.get().setAccount(AppConstant.NONE);
            aiTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            aiTriggerDBModel.get().setStatus(1);

            return new CampaignAITriggerWSDTO(aiTriggerRepository.save(aiTriggerDBModel.get()));
        }
        return null;
    }

    public CampaignAITriggerWSDTO removeCampaignAITriggerService(long userId, String triggerId) {

        Optional<AITriggerDBModel> aiTriggerDBModel = aiTriggerRepository.findById(triggerId);
        if (aiTriggerDBModel.isPresent()){
            aiTriggerRepository.delete(aiTriggerDBModel.get());
            return new CampaignAITriggerWSDTO(aiTriggerDBModel.get());
        }
        return null;
    }



}
