package com.faas.core.base.framework.process.details.trigger.temp.wapp.call;

import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.wapp.call.dto.WappCallTriggerTempWSDTO;
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
public class WappCallTriggerTempFramework {


    @Autowired
    WappCallTriggerTempRepository wappCallTriggerTempRepository;

    @Autowired
    WappAccountRepository wappAccountRepository;

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




}
