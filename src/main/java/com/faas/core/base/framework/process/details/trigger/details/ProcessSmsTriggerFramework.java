package com.faas.core.base.framework.process.details.trigger.details;

import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessSmsTriggerWSDTO;
import com.faas.core.base.repo.channel.account.SmsAccountRepository;
import com.faas.core.base.repo.channel.settings.MessageTypeRepository;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.process.settings.TriggerTypeRepository;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProcessSmsTriggerFramework {


    @Autowired
    SmsTriggerRepository smsTriggerRepository;

    @Autowired
    SmsAccountRepository smsAccountRepository;

    @Autowired
    MessageTypeRepository messageTypeRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ProcessSmsTriggerWSDTO> getProcessSmsTriggersService(long userId, String processId) {

        List<ProcessSmsTriggerWSDTO> processSmsTriggerWSDTOS = new ArrayList<>();
        List<SmsTriggerDBModel> smsTriggerDBModels = smsTriggerRepository.findByProcessId(processId);
        for (SmsTriggerDBModel smsTriggerDBModel : smsTriggerDBModels) {
            processSmsTriggerWSDTOS.add(new ProcessSmsTriggerWSDTO(smsTriggerDBModel));
        }
        return processSmsTriggerWSDTOS;
    }

    public ProcessSmsTriggerWSDTO getProcessSmsTriggerService(long userId, String triggerId) {

        Optional<SmsTriggerDBModel> smsTriggerDBModel = smsTriggerRepository.findById(triggerId);
        if (smsTriggerDBModel.isPresent()){
            return new ProcessSmsTriggerWSDTO(smsTriggerDBModel.get());
        }
        return null;
    }

    public ProcessSmsTriggerWSDTO createProcessSmsTriggerService(long userId, String processId, String trigger, String accountId, String smsTitle, String smsBody, String senderId, long typeId) {

        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (smsAccountDBModel.isPresent() && triggerTypeDBModel.isPresent()){

            SmsTriggerDBModel smsTriggerDBModel = new SmsTriggerDBModel();
            smsTriggerDBModel.setProcessId(processId);
            smsTriggerDBModel.setTrigger(trigger);
            smsTriggerDBModel.setAccountId(accountId);
            smsTriggerDBModel.setAccount(smsAccountDBModel.get().getAccount());
            smsTriggerDBModel.setSmsTitle(smsTitle);
            smsTriggerDBModel.setSmsBody(smsBody);
            smsTriggerDBModel.setSenderId(senderId);
            smsTriggerDBModel.setDatas(new ArrayList<>());
            smsTriggerDBModel.setTypeId(typeId);
            smsTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            smsTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            smsTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            smsTriggerDBModel.setStatus(1);

            return new ProcessSmsTriggerWSDTO(smsTriggerRepository.save(smsTriggerDBModel));
        }
        return null;
    }

    public ProcessSmsTriggerWSDTO updateProcessSmsTriggerService(long userId, String triggerId, String trigger, String accountId, String smsTitle, String smsBody, String senderId) {

        Optional<SmsTriggerDBModel> smsTriggerDBModel = smsTriggerRepository.findById(triggerId);
        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        if (smsTriggerDBModel.isPresent() && smsAccountDBModel.isPresent()){

            smsTriggerDBModel.get().setTrigger(trigger);
            smsTriggerDBModel.get().setAccountId(accountId);
            smsTriggerDBModel.get().setAccount(smsAccountDBModel.get().getAccount());
            smsTriggerDBModel.get().setSmsTitle(smsTitle);
            smsTriggerDBModel.get().setSmsBody(smsBody);
            smsTriggerDBModel.get().setSenderId(senderId);
            smsAccountDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            smsTriggerDBModel.get().setStatus(1);

            return new ProcessSmsTriggerWSDTO(smsTriggerRepository.save(smsTriggerDBModel.get()));
        }
        return null;
    }

    public ProcessSmsTriggerWSDTO removeProcessSmsTriggerService(long userId, String triggerId) {

        Optional<SmsTriggerDBModel> smsTriggerDBModel = smsTriggerRepository.findById(triggerId);
        if (smsTriggerDBModel.isPresent()){
            smsTriggerRepository.delete(smsTriggerDBModel.get());
            return new ProcessSmsTriggerWSDTO(smsTriggerDBModel.get());
        }
        return null;
    }



}
