package com.faas.core.base.framework.process.details.trigger.temp;

import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.dto.WappCallTriggerTempWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.temp.dto.WappMessageTriggerTempWSDTO;
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
public class WappTriggerTempFramework {


    @Autowired
    WappCallTriggerTempRepository wappCallTriggerTempRepository;

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


    public List<WappCallTriggerTempWSDTO> getWappCallTriggerTempsService(long userId, String processId) {

        List<WappCallTriggerTempWSDTO> wappCallTriggerTempWSDTOS = new ArrayList<>();
        List<WappCallTriggerTempDBModel> wappCallTriggerTempDBModels = wappCallTriggerTempRepository.findByProcessId(processId);
        for (WappCallTriggerTempDBModel wappCallTriggerTempDBModel : wappCallTriggerTempDBModels) {
            wappCallTriggerTempWSDTOS.add(new WappCallTriggerTempWSDTO(wappCallTriggerTempDBModel));
        }
        return wappCallTriggerTempWSDTOS;
    }

    public WappCallTriggerTempWSDTO getWappCallTriggerTempService(long userId, String tempId) {

        Optional<WappCallTriggerTempDBModel> wappCallTriggerDBModel = wappCallTriggerTempRepository.findById(tempId);
        if (wappCallTriggerDBModel.isPresent()){
            return new WappCallTriggerTempWSDTO(wappCallTriggerDBModel.get());
        }
        return null;
    }

    public WappCallTriggerTempWSDTO createWappCallTriggerTempService(long userId, String processId, String trigger, String accountId, long typeId) {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (wappAccountDBModel.isPresent() && triggerTypeDBModel.isPresent()){

            WappCallTriggerTempDBModel wappCallTriggerTempDBModel = new WappCallTriggerTempDBModel();
            wappCallTriggerTempDBModel.setProcessId(processId);
            wappCallTriggerTempDBModel.setTrigger(trigger);
            wappCallTriggerTempDBModel.setAccountId(accountId);
            wappCallTriggerTempDBModel.setAccount(wappAccountDBModel.get().getAccount());
            wappCallTriggerTempDBModel.setDatas(new ArrayList<>());
            wappCallTriggerTempDBModel.setTypeId(typeId);
            wappCallTriggerTempDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            wappCallTriggerTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            wappCallTriggerTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            wappCallTriggerTempDBModel.setStatus(1);

            return new WappCallTriggerTempWSDTO(wappCallTriggerTempRepository.save(wappCallTriggerTempDBModel));
        }
        return null;
    }

    public WappCallTriggerTempWSDTO updateWappCallTriggerTempService(long userId, String tempId, String trigger, String accountId) {

        Optional<WappCallTriggerTempDBModel> wappCallTriggerDBModel = wappCallTriggerTempRepository.findById(tempId);
        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (wappCallTriggerDBModel.isPresent() && wappAccountDBModel.isPresent()){

            wappCallTriggerDBModel.get().setTrigger(trigger);
            wappCallTriggerDBModel.get().setAccountId(accountId);
            wappCallTriggerDBModel.get().setAccount(wappAccountDBModel.get().getAccount());
            wappCallTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            wappCallTriggerDBModel.get().setStatus(1);

            return new WappCallTriggerTempWSDTO(wappCallTriggerTempRepository.save(wappCallTriggerDBModel.get()));
        }
        return null;
    }

    public WappCallTriggerTempWSDTO removeWappCallTriggerTempService(long userId, String tempId) {

        Optional<WappCallTriggerTempDBModel> wappCallTriggerDBModel = wappCallTriggerTempRepository.findById(tempId);
        if (wappCallTriggerDBModel.isPresent()){
            wappCallTriggerTempRepository.delete(wappCallTriggerDBModel.get());
            return new WappCallTriggerTempWSDTO(wappCallTriggerDBModel.get());
        }
        return null;
    }


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
