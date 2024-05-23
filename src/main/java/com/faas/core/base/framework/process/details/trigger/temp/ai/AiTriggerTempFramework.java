package com.faas.core.base.framework.process.details.trigger.temp.ai;

import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.ai.dto.AITriggerTempWSDTO;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.process.settings.TriggerTypeRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AiTriggerTempFramework {

    @Autowired
    AITriggerTempRepository aiTriggerTempRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<AITriggerTempWSDTO> getAITriggerTempsService(long userId, String processId) {

        List<AITriggerTempWSDTO> aiTriggerTempWSDTOS = new ArrayList<>();
        List<AITriggerTempDBModel> aiTriggerTempDBModels = aiTriggerTempRepository.findByProcessId(processId);
        for (AITriggerTempDBModel aiTriggerTempDBModel : aiTriggerTempDBModels) {
            aiTriggerTempWSDTOS.add(new AITriggerTempWSDTO(aiTriggerTempDBModel));
        }
        return aiTriggerTempWSDTOS;
    }

    public AITriggerTempWSDTO getAITriggerTempService(long userId, String tempId) {

        Optional<AITriggerTempDBModel> aiTriggerTempDBModel = aiTriggerTempRepository.findById(tempId);
        if (aiTriggerTempDBModel.isPresent()){
            return new AITriggerTempWSDTO(aiTriggerTempDBModel.get());
        }
        return null;
    }

    public AITriggerTempWSDTO createAITriggerTempService(long userId, String processId, String trigger, String accountId, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            AITriggerTempDBModel aiTriggerTempDBModel = new AITriggerTempDBModel();
            aiTriggerTempDBModel.setProcessId(processId);
            aiTriggerTempDBModel.setTrigger(trigger);
            aiTriggerTempDBModel.setAccountId(accountId);
            aiTriggerTempDBModel.setAccount(AppConstant.NONE);
            aiTriggerTempDBModel.setDatas(new ArrayList<>());
            aiTriggerTempDBModel.setTypeId(typeId);
            aiTriggerTempDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            aiTriggerTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            aiTriggerTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            aiTriggerTempDBModel.setStatus(1);

            return new AITriggerTempWSDTO(aiTriggerTempRepository.save(aiTriggerTempDBModel));
        }
        return null;
    }

    public AITriggerTempWSDTO updateAITriggerTempService(long userId, String tempId, String trigger, String accountId) {

        Optional<AITriggerTempDBModel> aiTriggerTempDBModel = aiTriggerTempRepository.findById(tempId);
        if (aiTriggerTempDBModel.isPresent()){

            aiTriggerTempDBModel.get().setTrigger(trigger);
            aiTriggerTempDBModel.get().setAccountId(accountId);
            aiTriggerTempDBModel.get().setAccount(AppConstant.NONE);
            aiTriggerTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());

            return new AITriggerTempWSDTO(aiTriggerTempRepository.save(aiTriggerTempDBModel.get()));
        }
        return null;
    }

    public AITriggerTempWSDTO removeAITriggerTempService(long userId, String tempId) {

        Optional<AITriggerTempDBModel> aiTriggerTempDBModel = aiTriggerTempRepository.findById(tempId);
        if (aiTriggerTempDBModel.isPresent()){
            aiTriggerTempRepository.delete(aiTriggerTempDBModel.get());
            return new AITriggerTempWSDTO(aiTriggerTempDBModel.get());
        }
        return null;
    }



}
