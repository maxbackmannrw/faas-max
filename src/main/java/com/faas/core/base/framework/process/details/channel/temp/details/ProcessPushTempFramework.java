package com.faas.core.base.framework.process.details.channel.temp.details;

import com.faas.core.base.model.db.channel.settings.PushTypeDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.PushTempDBModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessPushTempWSDTO;
import com.faas.core.base.repo.channel.settings.PushTypeRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.process.ProcessHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProcessPushTempFramework {


    @Autowired
    ProcessHelpers processHelpers;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    PushTypeRepository pushTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ProcessPushTempWSDTO> getProcessPushTempsService(long userId, String processId) {

        List<ProcessPushTempWSDTO> processPushTempWSDTOS = new ArrayList<>();
        List<PushTempDBModel> pushTempDBModels = pushTempRepository.findByProcessId(processId);
        for (PushTempDBModel pushTempDBModel : pushTempDBModels) {
            processPushTempWSDTOS.add(new ProcessPushTempWSDTO(pushTempDBModel));
        }
        return processPushTempWSDTOS;
    }

    public ProcessPushTempWSDTO getProcessPushTempService(long userId,String tempId) {

        Optional<PushTempDBModel> processPushTempDBModel = pushTempRepository.findById(tempId);
        if (processPushTempDBModel.isPresent()){
            return new ProcessPushTempWSDTO(processPushTempDBModel.get());
        }
        return null;
    }

    public ProcessPushTempWSDTO createProcessPushTempService(String processId, String pushHeader, String pushBody, String pushSender, long typeId) {

        Optional<PushTypeDBModel> pushTypeDBModel = pushTypeRepository.findById(typeId);
        if (pushTypeDBModel.isPresent()){

            PushTempDBModel pushTempDBModel = new PushTempDBModel();
            pushTempDBModel.setProcessId(processId);
            pushTempDBModel.setPushHeader(pushHeader);
            pushTempDBModel.setPushBody(pushBody);
            pushTempDBModel.setPushSender(pushSender);
            pushTempDBModel.setTypeId(pushTypeDBModel.get().getId());
            pushTempDBModel.setPushType(pushTypeDBModel.get().getPushType());
            pushTempDBModel.setTempDatas(new ArrayList<>());
            pushTempDBModel.setTempAssets(new ArrayList<>());
            pushTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            pushTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            pushTempDBModel.setStatus(1);

            return new ProcessPushTempWSDTO(pushTempRepository.save(pushTempDBModel));
        }
        return null;
    }

    public ProcessPushTempWSDTO updateProcessPushTempService(String tempId, String pushHeader, String pushBody, String pushSender, long typeId) {

        Optional<PushTempDBModel> processPushTempDBModel = pushTempRepository.findById(tempId);
        Optional<PushTypeDBModel> pushTypeDBModel = pushTypeRepository.findById(typeId);
        if (processPushTempDBModel.isPresent() && pushTypeDBModel.isPresent()){

            processPushTempDBModel.get().setPushHeader(pushHeader);
            processPushTempDBModel.get().setPushBody(pushBody);
            processPushTempDBModel.get().setPushSender(pushSender);
            processPushTempDBModel.get().setTypeId(pushTypeDBModel.get().getId());
            processPushTempDBModel.get().setPushType(pushTypeDBModel.get().getPushType());
            processPushTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processPushTempDBModel.get().setStatus(1);

            return new ProcessPushTempWSDTO(pushTempRepository.save(processPushTempDBModel.get()));
        }
        return null;
    }

    public ProcessPushTempWSDTO removeProcessPushTempService(String tempId) {

        Optional<PushTempDBModel> processPushTempDBModel = pushTempRepository.findById(tempId);
        if (processPushTempDBModel.isPresent()){
            pushTempRepository.delete(processPushTempDBModel.get());
            return new ProcessPushTempWSDTO(processPushTempDBModel.get());
        }
        return null;
    }


}
