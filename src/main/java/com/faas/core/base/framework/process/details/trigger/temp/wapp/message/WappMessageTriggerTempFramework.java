package com.faas.core.base.framework.process.details.trigger.temp.wapp.message;

import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.wapp.message.dto.WappMessageTriggerTempWSDTO;
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
public class WappMessageTriggerTempFramework {


    @Autowired
    WappMessageTriggerTempRepository wappMessageTriggerTempRepository;

    @Autowired
    WappAccountRepository wappAccountRepository;

    @Autowired
    MessageTypeRepository messageTypeRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<WappMessageTriggerTempWSDTO> getWappMessageTriggerTempsService(long userId, String processId) {

        List<WappMessageTriggerTempWSDTO> wappMessageTriggerTempWSDTOS = new ArrayList<>();
        List<WappMessageTriggerTempDBModel> wappMessageTriggerTempDBModels = wappMessageTriggerTempRepository.findByProcessId(processId);
        for (WappMessageTriggerTempDBModel wappMessageTriggerTempDBModel : wappMessageTriggerTempDBModels) {
            wappMessageTriggerTempWSDTOS.add(new WappMessageTriggerTempWSDTO(wappMessageTriggerTempDBModel));
        }
        return wappMessageTriggerTempWSDTOS;
    }

    public WappMessageTriggerTempWSDTO getWappMessageTriggerTempService(long userId, String tempId) {

        Optional<WappMessageTriggerTempDBModel> wappMessageTriggerDBModel = wappMessageTriggerTempRepository.findById(tempId);
        if (wappMessageTriggerDBModel.isPresent()){
            return new WappMessageTriggerTempWSDTO(wappMessageTriggerDBModel.get());
        }
        return null;
    }

    public WappMessageTriggerTempWSDTO createWappMessageTriggerTempService(long userId, String processId, String trigger, String accountId, String wappTitle, String wappBody, long typeId) {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (wappAccountDBModel.isPresent() && triggerTypeDBModel.isPresent()){

            WappMessageTriggerTempDBModel wappMessageTriggerTempDBModel = new WappMessageTriggerTempDBModel();
            wappMessageTriggerTempDBModel.setProcessId(processId);
            wappMessageTriggerTempDBModel.setTrigger(trigger);
            wappMessageTriggerTempDBModel.setAccountId(accountId);
            wappMessageTriggerTempDBModel.setAccount(wappAccountDBModel.get().getAccount());
            wappMessageTriggerTempDBModel.setWappTitle(wappTitle);
            wappMessageTriggerTempDBModel.setWappBody(wappBody);
            wappMessageTriggerTempDBModel.setDatas(new ArrayList<>());
            wappMessageTriggerTempDBModel.setTypeId(typeId);
            wappMessageTriggerTempDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            wappMessageTriggerTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            wappMessageTriggerTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            wappMessageTriggerTempDBModel.setStatus(1);

            return new WappMessageTriggerTempWSDTO(wappMessageTriggerTempRepository.save(wappMessageTriggerTempDBModel));
        }
        return null;
    }

    public WappMessageTriggerTempWSDTO updateWappMessageTriggerTempService(long userId, String tempId, String trigger, String accountId, String wappTitle, String wappBody) {

        Optional<WappMessageTriggerTempDBModel> wappMessageTriggerDBModel = wappMessageTriggerTempRepository.findById(tempId);
        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (wappMessageTriggerDBModel.isPresent() && wappAccountDBModel.isPresent()){

            wappMessageTriggerDBModel.get().setTrigger(trigger);
            wappMessageTriggerDBModel.get().setAccountId(accountId);
            wappMessageTriggerDBModel.get().setAccount(wappAccountDBModel.get().getAccount());
            wappMessageTriggerDBModel.get().setWappTitle(wappTitle);
            wappMessageTriggerDBModel.get().setWappBody(wappBody);
            wappMessageTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            wappMessageTriggerDBModel.get().setStatus(1);

            return new WappMessageTriggerTempWSDTO(wappMessageTriggerTempRepository.save(wappMessageTriggerDBModel.get()));
        }
        return null;
    }

    public WappMessageTriggerTempWSDTO removeWappMessageTriggerTempService(long userId, String tempId) {

        Optional<WappMessageTriggerTempDBModel> wappMessageTriggerTempDBModel = wappMessageTriggerTempRepository.findById(tempId);
        if (wappMessageTriggerTempDBModel.isPresent()){
            wappMessageTriggerTempRepository.delete(wappMessageTriggerTempDBModel.get());
            return new WappMessageTriggerTempWSDTO(wappMessageTriggerTempDBModel.get());
        }
        return null;
    }



}
