package com.faas.core.base.framework.process.details.trigger.wapp;

import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.process.details.trigger.wapp.dto.ProcessWappMessageTriggerWSDTO;
import com.faas.core.base.repo.channel.account.WappAccountRepository;
import com.faas.core.base.repo.channel.settings.MessageTypeRepository;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.process.settings.TriggerTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProcessWappMessageTriggerFramework {


    @Autowired
    WappMessageTriggerRepository wappMessageTriggerRepository;

    @Autowired
    WappAccountRepository wappAccountRepository;

    @Autowired
    MessageTypeRepository messageTypeRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ProcessWappMessageTriggerWSDTO> getProcessWappMessageTriggersService(long userId, String processId) {

        List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggerWSDTOS = new ArrayList<>();
        List<WappMessageTriggerDBModel> wappMessageTriggerDBModels = wappMessageTriggerRepository.findByProcessId(processId);
        for (WappMessageTriggerDBModel wappMessageTriggerDBModel : wappMessageTriggerDBModels) {
            processWappMessageTriggerWSDTOS.add(new ProcessWappMessageTriggerWSDTO(wappMessageTriggerDBModel));
        }
        return processWappMessageTriggerWSDTOS;
    }

    public ProcessWappMessageTriggerWSDTO getProcessWappMessageTriggerService(long userId, String triggerId) {

        Optional<WappMessageTriggerDBModel> wappMessageTriggerDBModel = wappMessageTriggerRepository.findById(triggerId);
        if (wappMessageTriggerDBModel.isPresent()){
            return new ProcessWappMessageTriggerWSDTO(wappMessageTriggerDBModel.get());
        }
        return null;
    }

    public ProcessWappMessageTriggerWSDTO createProcessWappMessageTriggerService(long userId, String processId, String trigger, String accountId, String wappTitle, String wappBody, long typeId) {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (wappAccountDBModel.isPresent() && triggerTypeDBModel.isPresent()){

            WappMessageTriggerDBModel wappMessageTriggerDBModel = new WappMessageTriggerDBModel();
            wappMessageTriggerDBModel.setProcessId(processId);
            wappMessageTriggerDBModel.setTrigger(trigger);
            wappMessageTriggerDBModel.setAccountId(accountId);
            wappMessageTriggerDBModel.setAccount(wappAccountDBModel.get().getAccount());
            wappMessageTriggerDBModel.setWappTitle(wappTitle);
            wappMessageTriggerDBModel.setWappBody(wappBody);
            wappMessageTriggerDBModel.setDatas(new ArrayList<>());
            wappMessageTriggerDBModel.setTypeId(typeId);
            wappMessageTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            wappMessageTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            wappMessageTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            wappMessageTriggerDBModel.setStatus(1);

            return new ProcessWappMessageTriggerWSDTO(wappMessageTriggerRepository.save(wappMessageTriggerDBModel));
        }
        return null;
    }

    public ProcessWappMessageTriggerWSDTO updateProcessWappMessageTriggerService(long userId, String triggerId, String trigger, String accountId, String wappTitle, String wappBody) {

        Optional<WappMessageTriggerDBModel> wappMessageTriggerDBModel = wappMessageTriggerRepository.findById(triggerId);
        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (wappMessageTriggerDBModel.isPresent() && wappAccountDBModel.isPresent()){

            wappMessageTriggerDBModel.get().setTrigger(trigger);
            wappMessageTriggerDBModel.get().setAccountId(accountId);
            wappMessageTriggerDBModel.get().setAccount(wappAccountDBModel.get().getAccount());
            wappMessageTriggerDBModel.get().setWappTitle(wappTitle);
            wappMessageTriggerDBModel.get().setWappBody(wappBody);
            wappMessageTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            wappMessageTriggerDBModel.get().setStatus(1);

            return new ProcessWappMessageTriggerWSDTO(wappMessageTriggerRepository.save(wappMessageTriggerDBModel.get()));
        }
        return null;
    }

    public ProcessWappMessageTriggerWSDTO removeProcessWappMessageTriggerService(long userId, String triggerId) {

        Optional<WappMessageTriggerDBModel> wappMessageTriggerDBModel = wappMessageTriggerRepository.findById(triggerId);
        if (wappMessageTriggerDBModel.isPresent()){

            wappMessageTriggerRepository.delete(wappMessageTriggerDBModel.get());
            return new ProcessWappMessageTriggerWSDTO(wappMessageTriggerDBModel.get());
        }
        return null;
    }



}
