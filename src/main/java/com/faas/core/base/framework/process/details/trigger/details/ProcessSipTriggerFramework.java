package com.faas.core.base.framework.process.details.trigger.details;

import com.faas.core.base.model.db.channel.account.SipAccountDBModel;
import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.process.details.trigger.details.dto.ProcessSipTriggerWSDTO;
import com.faas.core.base.repo.channel.account.SipAccountRepository;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.process.settings.TriggerTypeRepository;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProcessSipTriggerFramework {


    @Autowired
    SipTriggerRepository sipTriggerRepository;

    @Autowired
    SipAccountRepository sipAccountRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ProcessSipTriggerWSDTO> getProcessSipTriggersService(long userId, String processId) {

        List<ProcessSipTriggerWSDTO> processSipTriggerWSDTOS = new ArrayList<>();
        List<SipTriggerDBModel> sipTriggerDBModels = sipTriggerRepository.findByProcessId(processId);
        for (SipTriggerDBModel sipTriggerDBModel : sipTriggerDBModels) {
            processSipTriggerWSDTOS.add(new ProcessSipTriggerWSDTO(sipTriggerDBModel));
        }
        return processSipTriggerWSDTOS;
    }

    public ProcessSipTriggerWSDTO getProcessSipTriggerService(long userId, String triggerId) {

        Optional<SipTriggerDBModel> sipTriggerDBModel = sipTriggerRepository.findById(triggerId);
        if (sipTriggerDBModel.isPresent()){
            return new ProcessSipTriggerWSDTO(sipTriggerDBModel.get());
        }
        return null;
    }

    public ProcessSipTriggerWSDTO createProcessSipTriggerService(long userId, String processId, String trigger, String accountId, String callerId, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (triggerTypeDBModel.isPresent() && sipAccountDBModel.isPresent()){

            SipTriggerDBModel sipTriggerDBModel = new SipTriggerDBModel();
            sipTriggerDBModel.setProcessId(processId);
            sipTriggerDBModel.setTrigger(trigger);
            sipTriggerDBModel.setAccountId(accountId);
            sipTriggerDBModel.setAccount(sipAccountDBModel.get().getAccount());
            sipTriggerDBModel.setCallerId(callerId);
            sipTriggerDBModel.setDatas(new ArrayList<>());
            sipTriggerDBModel.setTypeId(typeId);
            sipTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            sipTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            sipTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            sipTriggerDBModel.setStatus(1);

            return new ProcessSipTriggerWSDTO(sipTriggerRepository.save(sipTriggerDBModel));
        }
        return null;
    }

    public ProcessSipTriggerWSDTO updateProcessSipTriggerService(long userId, String triggerId, String trigger, String accountId, String callerId) {

        Optional<SipTriggerDBModel> sipTriggerDBModel = sipTriggerRepository.findById(triggerId);
        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (sipTriggerDBModel.isPresent() && sipAccountDBModel.isPresent()){

            sipTriggerDBModel.get().setTrigger(trigger);
            sipTriggerDBModel.get().setAccountId(accountId);
            sipTriggerDBModel.get().setAccount(sipAccountDBModel.get().getAccount());
            sipTriggerDBModel.get().setCallerId(callerId);
            sipTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            sipTriggerDBModel.get().setStatus(1);

            return new ProcessSipTriggerWSDTO(sipTriggerRepository.save(sipTriggerDBModel.get()));
        }
        return null;
    }

    public ProcessSipTriggerWSDTO removeProcessSipTriggerService(long userId, String triggerId) {

        Optional<SipTriggerDBModel> sipTriggerDBModel = sipTriggerRepository.findById(triggerId);
        if (sipTriggerDBModel.isPresent()){
            sipTriggerRepository.delete(sipTriggerDBModel.get());
            return new ProcessSipTriggerWSDTO(sipTriggerDBModel.get());
        }
        return null;
    }


}
