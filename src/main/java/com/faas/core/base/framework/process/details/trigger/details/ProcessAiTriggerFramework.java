package com.faas.core.base.framework.process.details.trigger.details;

import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.process.details.trigger.details.dto.ProcessAITriggerWSDTO;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.process.settings.TriggerTypeRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
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

        List<ProcessAITriggerWSDTO> processAiTriggerWSDTOS = new ArrayList<>();
        List<AITriggerDBModel> aiTriggerDBModels = aiTriggerRepository.findByProcessId(processId);
        for (AITriggerDBModel aiTriggerDBModel : aiTriggerDBModels) {
            processAiTriggerWSDTOS.add(new ProcessAITriggerWSDTO(aiTriggerDBModel));
        }
        return processAiTriggerWSDTOS;
    }

    public ProcessAITriggerWSDTO getProcessAITriggerService(long userId, String triggerId) {

        Optional<AITriggerDBModel> aiTriggerDBModel = aiTriggerRepository.findById(triggerId);
        if (aiTriggerDBModel.isPresent()){
            return new ProcessAITriggerWSDTO(aiTriggerDBModel.get());
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

        Optional<AITriggerDBModel> aiTriggerDBModel = aiTriggerRepository.findById(triggerId);
        if (aiTriggerDBModel.isPresent()){

            aiTriggerDBModel.get().setTrigger(trigger);
            aiTriggerDBModel.get().setAccountId(accountId);
            aiTriggerDBModel.get().setAccount(AppConstant.NONE);
            aiTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());

            return new ProcessAITriggerWSDTO(aiTriggerRepository.save(aiTriggerDBModel.get()));
        }
        return null;
    }

    public ProcessAITriggerWSDTO removeProcessAITriggerService(long userId, String triggerId) {

        Optional<AITriggerDBModel> aiTriggerDBModel = aiTriggerRepository.findById(triggerId);
        if (aiTriggerDBModel.isPresent()){
            aiTriggerRepository.delete(aiTriggerDBModel.get());
            return new ProcessAITriggerWSDTO(aiTriggerDBModel.get());
        }
        return null;
    }



}
