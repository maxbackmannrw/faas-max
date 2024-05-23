package com.faas.core.base.framework.process.details.trigger.temp.sms;

import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.sms.dto.SmsTriggerTempWSDTO;
import com.faas.core.base.repo.channel.account.SmsAccountRepository;
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
public class SmsTriggerTempFramework {


    @Autowired
    SmsTriggerTempRepository smsTriggerTempRepository;

    @Autowired
    SmsAccountRepository smsAccountRepository;

    @Autowired
    MessageTypeRepository messageTypeRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<SmsTriggerTempWSDTO> getSmsTriggerTempsService(long userId, String processId) {

        List<SmsTriggerTempWSDTO> smsTriggerTempWSDTOS = new ArrayList<>();
        List<SmsTriggerTempDBModel> smsTriggerTempDBModels = smsTriggerTempRepository.findByProcessId(processId);
        for (SmsTriggerTempDBModel smsTriggerTempDBModel : smsTriggerTempDBModels) {
            smsTriggerTempWSDTOS.add(new SmsTriggerTempWSDTO(smsTriggerTempDBModel));
        }
        return smsTriggerTempWSDTOS;
    }

    public SmsTriggerTempWSDTO getSmsTriggerTempService(long userId, String tempId) {

        Optional<SmsTriggerTempDBModel> smsTriggerTempDBModel = smsTriggerTempRepository.findById(tempId);
        if (smsTriggerTempDBModel.isPresent()){
            return new SmsTriggerTempWSDTO(smsTriggerTempDBModel.get());
        }
        return null;
    }

    public SmsTriggerTempWSDTO createSmsTriggerTempService(long userId, String processId, String trigger, String accountId, String smsTitle, String smsBody, String senderId, long typeId) {

        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (smsAccountDBModel.isPresent() && triggerTypeDBModel.isPresent()){

            SmsTriggerTempDBModel smsTriggerTempDBModel = new SmsTriggerTempDBModel();
            smsTriggerTempDBModel.setProcessId(processId);
            smsTriggerTempDBModel.setTrigger(trigger);
            smsTriggerTempDBModel.setAccountId(accountId);
            smsTriggerTempDBModel.setAccount(smsAccountDBModel.get().getAccount());
            smsTriggerTempDBModel.setSmsTitle(smsTitle);
            smsTriggerTempDBModel.setSmsBody(smsBody);
            smsTriggerTempDBModel.setSenderId(senderId);
            smsTriggerTempDBModel.setDatas(new ArrayList<>());
            smsTriggerTempDBModel.setTypeId(typeId);
            smsTriggerTempDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            smsTriggerTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            smsTriggerTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            smsTriggerTempDBModel.setStatus(1);

            return new SmsTriggerTempWSDTO(smsTriggerTempRepository.save(smsTriggerTempDBModel));
        }
        return null;
    }

    public SmsTriggerTempWSDTO updateSmsTriggerTempService(long userId, String tempId, String trigger, String accountId, String smsTitle, String smsBody, String senderId) {

        Optional<SmsTriggerTempDBModel> smsTriggerTempDBModel = smsTriggerTempRepository.findById(tempId);
        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        if (smsTriggerTempDBModel.isPresent() && smsAccountDBModel.isPresent()){

            smsTriggerTempDBModel.get().setTrigger(trigger);
            smsTriggerTempDBModel.get().setAccountId(accountId);
            smsTriggerTempDBModel.get().setAccount(smsAccountDBModel.get().getAccount());
            smsTriggerTempDBModel.get().setSmsTitle(smsTitle);
            smsTriggerTempDBModel.get().setSmsBody(smsBody);
            smsTriggerTempDBModel.get().setSenderId(senderId);
            smsTriggerTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            smsTriggerTempDBModel.get().setStatus(1);

            return new SmsTriggerTempWSDTO(smsTriggerTempRepository.save(smsTriggerTempDBModel.get()));
        }
        return null;
    }

    public SmsTriggerTempWSDTO removeSmsTriggerTempService(long userId, String tempId) {

        Optional<SmsTriggerTempDBModel> smsTriggerTempDBModel = smsTriggerTempRepository.findById(tempId);
        if (smsTriggerTempDBModel.isPresent()){
            smsTriggerTempRepository.delete(smsTriggerTempDBModel.get());
            return new SmsTriggerTempWSDTO(smsTriggerTempDBModel.get());
        }
        return null;
    }



}
