package com.faas.core.base.framework.process.details.trigger.wapp;

import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.process.details.trigger.wapp.dto.ProcessWappCallTriggerWSDTO;
import com.faas.core.base.repo.channel.account.WappAccountRepository;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.process.settings.TriggerTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProcessWappCallTriggerFramework {


    @Autowired
    WappCallTriggerRepository wappCallTriggerRepository;

    @Autowired
    WappAccountRepository wappAccountRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ProcessWappCallTriggerWSDTO> getProcessWappCallTriggersService(long userId, String processId) {

        List<ProcessWappCallTriggerWSDTO> processWappCallTriggerWSDTOS = new ArrayList<>();
        List<WappCallTriggerDBModel> wappCallTriggerDBModels = wappCallTriggerRepository.findByProcessId(processId);
        for (WappCallTriggerDBModel wappCallTriggerDBModel : wappCallTriggerDBModels) {
            processWappCallTriggerWSDTOS.add(new ProcessWappCallTriggerWSDTO(wappCallTriggerDBModel));
        }
        return processWappCallTriggerWSDTOS;
    }

    public ProcessWappCallTriggerWSDTO getProcessWappCallTriggerService(long userId, String triggerId) {

        Optional<WappCallTriggerDBModel> wappCallTriggerDBModel = wappCallTriggerRepository.findById(triggerId);
        if (wappCallTriggerDBModel.isPresent()){
            return new ProcessWappCallTriggerWSDTO(wappCallTriggerDBModel.get());
        }
        return null;
    }

    public ProcessWappCallTriggerWSDTO createProcessWappCallTriggerService(long userId, String processId, String trigger, String triggerDesc, String accountId, long typeId) {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (wappAccountDBModel.isPresent() && triggerTypeDBModel.isPresent()){

            WappCallTriggerDBModel wappCallTriggerDBModel = new WappCallTriggerDBModel();
            wappCallTriggerDBModel.setProcessId(processId);
            wappCallTriggerDBModel.setTrigger(trigger);
            wappCallTriggerDBModel.setTriggerDesc(triggerDesc);
            wappCallTriggerDBModel.setAccountId(accountId);
            wappCallTriggerDBModel.setAccount(wappAccountDBModel.get().getAccount());
            wappCallTriggerDBModel.setDatas(new ArrayList<>());
            wappCallTriggerDBModel.setTypeId(typeId);
            wappCallTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            wappCallTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            wappCallTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            wappCallTriggerDBModel.setStatus(1);

            return new ProcessWappCallTriggerWSDTO(wappCallTriggerRepository.save(wappCallTriggerDBModel));
        }
        return null;
    }

    public ProcessWappCallTriggerWSDTO updateProcessWappCallTriggerService(long userId, String triggerId, String trigger, String triggerDesc, String accountId) {

        Optional<WappCallTriggerDBModel> wappCallTriggerDBModel = wappCallTriggerRepository.findById(triggerId);
        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (wappCallTriggerDBModel.isPresent() && wappAccountDBModel.isPresent()){

            wappCallTriggerDBModel.get().setTrigger(trigger);
            wappCallTriggerDBModel.get().setTriggerDesc(triggerDesc);
            wappCallTriggerDBModel.get().setAccountId(accountId);
            wappCallTriggerDBModel.get().setAccount(wappAccountDBModel.get().getAccount());
            wappCallTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            wappCallTriggerDBModel.get().setStatus(1);

            return new ProcessWappCallTriggerWSDTO(wappCallTriggerRepository.save(wappCallTriggerDBModel.get()));
        }
        return null;
    }

    public ProcessWappCallTriggerWSDTO removeProcessWappCallTriggerService(long userId, String triggerId) {

        Optional<WappCallTriggerDBModel> wappCallTriggerDBModel = wappCallTriggerRepository.findById(triggerId);
        if (wappCallTriggerDBModel.isPresent()){
            wappCallTriggerRepository.delete(wappCallTriggerDBModel.get());
            return new ProcessWappCallTriggerWSDTO(wappCallTriggerDBModel.get());
        }
        return null;
    }




}
