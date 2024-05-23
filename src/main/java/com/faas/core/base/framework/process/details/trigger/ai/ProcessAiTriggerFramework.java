package com.faas.core.base.framework.process.details.trigger.ai;

import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.process.details.trigger.ai.dto.ProcessAITriggerWSDTO;
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
public class ProcessAiTriggerFramework {

    @Autowired
    AITriggerRepository aiTriggerRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ProcessAITriggerWSDTO> getProcessAITriggersService(long userId, String processId) {

        List<ProcessAITriggerWSDTO> processAITriggerWSDTOS = new ArrayList<>();
        List<AITriggerDBModel> AITriggerDBModels = aiTriggerRepository.findByProcessId(processId);
        for (AITriggerDBModel aiTriggerDBModel : AITriggerDBModels) {
            processAITriggerWSDTOS.add(new ProcessAITriggerWSDTO(aiTriggerDBModel));
        }
        return processAITriggerWSDTOS;
    }

    public ProcessAITriggerWSDTO getProcessAITriggerService(long userId, String triggerId) {

        Optional<AITriggerDBModel> processAITriggerDBModel = aiTriggerRepository.findById(triggerId);
        if (processAITriggerDBModel.isPresent()){
            return new ProcessAITriggerWSDTO(processAITriggerDBModel.get());
        }
        return null;
    }

    public ProcessAITriggerWSDTO createProcessAITriggerService(long userId, String processId, String trigger, String accountId, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            AITriggerDBModel aiTriggerDBModel = new AITriggerDBModel();
            aiTriggerDBModel.setProcessId(processId);
            aiTriggerDBModel.setTrigger(trigger);
            aiTriggerDBModel.setAccountId(accountId);
            aiTriggerDBModel.setAccount(AppConstant.NONE);
            aiTriggerDBModel.setDatas(new ArrayList<>());
            aiTriggerDBModel.setTypeId(typeId);
            aiTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            aiTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            aiTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            aiTriggerDBModel.setStatus(1);

            return new ProcessAITriggerWSDTO(aiTriggerRepository.save(aiTriggerDBModel));
        }
        return null;
    }

    public ProcessAITriggerWSDTO updateProcessAITriggerService(long userId, String triggerId, String trigger, String accountId) {

        Optional<AITriggerDBModel> processAITriggerDBModel = aiTriggerRepository.findById(triggerId);
        if (processAITriggerDBModel.isPresent()){

            processAITriggerDBModel.get().setTrigger(trigger);
            processAITriggerDBModel.get().setAccountId(accountId);
            processAITriggerDBModel.get().setAccount(AppConstant.NONE);
            processAITriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());

            return new ProcessAITriggerWSDTO(aiTriggerRepository.save(processAITriggerDBModel.get()));
        }
        return null;
    }

    public ProcessAITriggerWSDTO removeProcessAITriggerService(long userId, String triggerId) {

        Optional<AITriggerDBModel> processAITriggerDBModel = aiTriggerRepository.findById(triggerId);
        if (processAITriggerDBModel.isPresent()){
            aiTriggerRepository.delete(processAITriggerDBModel.get());
            return new ProcessAITriggerWSDTO(processAITriggerDBModel.get());
        }
        return null;
    }



}
