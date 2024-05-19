package com.faas.core.base.framework.process.details.channel.temp;

import com.faas.core.base.model.db.channel.settings.PushTypeDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessPushTempWSDTO;
import com.faas.core.base.repo.channel.settings.PushTypeRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessPushTempRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.process.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProcessPushTempFramework {


    @Autowired
    ProcessHelper processHelper;

    @Autowired
    ProcessPushTempRepository processPushTempRepository;

    @Autowired
    PushTypeRepository pushTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ProcessPushTempWSDTO> getProcessPushTempsService(long userId, String processId) {

        List<ProcessPushTempWSDTO> processPushTempWSDTOS = new ArrayList<>();
        List<ProcessPushTempDBModel> processPushTempDBModels = processPushTempRepository.findByProcessId(processId);
        for (ProcessPushTempDBModel processPushTempDBModel : processPushTempDBModels) {
            processPushTempWSDTOS.add(new ProcessPushTempWSDTO(processPushTempDBModel));
        }
        return processPushTempWSDTOS;
    }

    public ProcessPushTempWSDTO getProcessPushTempService(long userId,String tempId) {

        Optional<ProcessPushTempDBModel> processPushTempDBModel = processPushTempRepository.findById(tempId);
        if (processPushTempDBModel.isPresent()){
            return new ProcessPushTempWSDTO(processPushTempDBModel.get());
        }
        return null;
    }

    public ProcessPushTempWSDTO createProcessPushTempService(String processId, String pushHeader, String pushBody, String pushSender, long typeId) {

        Optional<PushTypeDBModel> pushTypeDBModel = pushTypeRepository.findById(typeId);
        if (pushTypeDBModel.isPresent()){

            ProcessPushTempDBModel processPushTempDBModel = new ProcessPushTempDBModel();
            processPushTempDBModel.setProcessId(processId);
            processPushTempDBModel.setPushHeader(pushHeader);
            processPushTempDBModel.setPushBody(pushBody);
            processPushTempDBModel.setPushSender(pushSender);
            processPushTempDBModel.setTypeId(pushTypeDBModel.get().getId());
            processPushTempDBModel.setPushType(pushTypeDBModel.get().getPushType());
            processPushTempDBModel.setTempDatas(new ArrayList<>());
            processPushTempDBModel.setTempAssets(new ArrayList<>());
            processPushTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processPushTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processPushTempDBModel.setStatus(1);

            return new ProcessPushTempWSDTO(processPushTempRepository.save(processPushTempDBModel));
        }
        return null;
    }

    public ProcessPushTempWSDTO updateProcessPushTempService(String tempId, String pushHeader, String pushBody, String pushSender, long typeId) {

        Optional<ProcessPushTempDBModel> processPushTempDBModel = processPushTempRepository.findById(tempId);
        Optional<PushTypeDBModel> pushTypeDBModel = pushTypeRepository.findById(typeId);
        if (processPushTempDBModel.isPresent() && pushTypeDBModel.isPresent()){

            processPushTempDBModel.get().setPushHeader(pushHeader);
            processPushTempDBModel.get().setPushBody(pushBody);
            processPushTempDBModel.get().setPushSender(pushSender);
            processPushTempDBModel.get().setTypeId(pushTypeDBModel.get().getId());
            processPushTempDBModel.get().setPushType(pushTypeDBModel.get().getPushType());
            processPushTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processPushTempDBModel.get().setStatus(1);

            return new ProcessPushTempWSDTO(processPushTempRepository.save(processPushTempDBModel.get()));
        }
        return null;
    }

    public ProcessPushTempWSDTO removeProcessPushTempService(String tempId) {

        Optional<ProcessPushTempDBModel> processPushTempDBModel = processPushTempRepository.findById(tempId);
        if (processPushTempDBModel.isPresent()){
            processPushTempRepository.delete(processPushTempDBModel.get());
            return new ProcessPushTempWSDTO(processPushTempDBModel.get());
        }
        return null;
    }


}
