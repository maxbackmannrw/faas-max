package com.faas.core.base.framework.process.details.trigger.temp.sip;

import com.faas.core.base.model.db.channel.account.SipAccountDBModel;
import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.sip.dto.SipTriggerTempWSDTO;
import com.faas.core.base.repo.channel.account.SipAccountRepository;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.process.settings.TriggerTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SipTriggerTempFramework {

    @Autowired
    SipTriggerTempRepository sipTriggerTempRepository;

    @Autowired
    SipAccountRepository sipAccountRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<SipTriggerTempWSDTO> getSipTriggerTempsService(long userId, String processId) {

        List<SipTriggerTempWSDTO> sipTriggerTempWSDTOS = new ArrayList<>();
        List<SipTriggerTempDBModel> sipTriggerTempDBModels = sipTriggerTempRepository.findByProcessId(processId);
        for (SipTriggerTempDBModel sipTriggerTempDBModel : sipTriggerTempDBModels) {
            sipTriggerTempWSDTOS.add(new SipTriggerTempWSDTO(sipTriggerTempDBModel));
        }
        return sipTriggerTempWSDTOS;
    }

    public SipTriggerTempWSDTO getSipTriggerTempService(long userId, String tempId) {

        Optional<SipTriggerTempDBModel> sipTriggerDBModel = sipTriggerTempRepository.findById(tempId);
        if (sipTriggerDBModel.isPresent()){
            return new SipTriggerTempWSDTO(sipTriggerDBModel.get());
        }
        return null;
    }

    public SipTriggerTempWSDTO createSipTriggerTempService(long userId, String processId, String trigger, String accountId, String callerId, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (triggerTypeDBModel.isPresent() && sipAccountDBModel.isPresent()){

            SipTriggerTempDBModel sipTriggerTempDBModel = new SipTriggerTempDBModel();
            sipTriggerTempDBModel.setProcessId(processId);
            sipTriggerTempDBModel.setTrigger(trigger);
            sipTriggerTempDBModel.setAccountId(accountId);
            sipTriggerTempDBModel.setAccount(sipAccountDBModel.get().getAccount());
            sipTriggerTempDBModel.setCallerId(callerId);
            sipTriggerTempDBModel.setDatas(new ArrayList<>());
            sipTriggerTempDBModel.setTypeId(typeId);
            sipTriggerTempDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            sipTriggerTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            sipTriggerTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            sipTriggerTempDBModel.setStatus(1);

            return new SipTriggerTempWSDTO(sipTriggerTempRepository.save(sipTriggerTempDBModel));
        }
        return null;
    }

    public SipTriggerTempWSDTO updateSipTriggerTempService(long userId, String tempId, String trigger, String accountId, String callerId) {

        Optional<SipTriggerTempDBModel> sipTriggerTempDBModel = sipTriggerTempRepository.findById(tempId);
        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (sipTriggerTempDBModel.isPresent() && sipAccountDBModel.isPresent()){

            sipTriggerTempDBModel.get().setTrigger(trigger);
            sipTriggerTempDBModel.get().setAccountId(accountId);
            sipTriggerTempDBModel.get().setAccount(sipAccountDBModel.get().getAccount());
            sipTriggerTempDBModel.get().setCallerId(callerId);
            sipTriggerTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            sipTriggerTempDBModel.get().setStatus(1);

            return new SipTriggerTempWSDTO(sipTriggerTempRepository.save(sipTriggerTempDBModel.get()));
        }
        return null;
    }

    public SipTriggerTempWSDTO removeSipTriggerTempService(long userId, String tempId) {

        Optional<SipTriggerTempDBModel> sipTriggerTempDBModel = sipTriggerTempRepository.findById(tempId);
        if (sipTriggerTempDBModel.isPresent()){
            sipTriggerTempRepository.delete(sipTriggerTempDBModel.get());
            return new SipTriggerTempWSDTO(sipTriggerTempDBModel.get());
        }
        return null;
    }


}
