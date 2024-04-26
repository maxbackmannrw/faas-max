package com.faas.core.base.framework.process.details.channel.temp;

import com.faas.core.base.model.db.channel.settings.MessageTypeDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessWappMessageTempWSDTO;
import com.faas.core.base.repo.channel.settings.MessageTypeRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessWappMessageTempRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProcessWappTempFramework {


    @Autowired
    ProcessHelper processHelper;

    @Autowired
    ProcessWappMessageTempRepository processWappMessageTempRepository;

    @Autowired
    MessageTypeRepository messageTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ProcessWappMessageTempWSDTO> getProcessWappMessageTempsService(long userId, String processId) {

        List<ProcessWappMessageTempWSDTO> processWappMessageTempWSDTOS = new ArrayList<>();
        List<ProcessWappMessageTempDBModel> processWappMessageTempDBModels = processWappMessageTempRepository.findByProcessId(processId);
        for (ProcessWappMessageTempDBModel processWappMessageTempDBModel : processWappMessageTempDBModels) {
            processWappMessageTempWSDTOS.add(new ProcessWappMessageTempWSDTO(processWappMessageTempDBModel));
        }
        return processWappMessageTempWSDTOS;
    }

    public ProcessWappMessageTempWSDTO getProcessWappMessageTempService(long userId, String tempId) {

        Optional<ProcessWappMessageTempDBModel> processWappMessageTempDBModel = processWappMessageTempRepository.findById(tempId);
        if (processWappMessageTempDBModel.isPresent()){
            return new ProcessWappMessageTempWSDTO(processWappMessageTempDBModel.get());
        }
        return null;
    }


    public ProcessWappMessageTempWSDTO createProcessWappMessageTempService(String processId, String wappTitle, String wappBody, long typeId) {

        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        if (messageTypeDBModel.isPresent()) {

            ProcessWappMessageTempDBModel processWappMessageTempDBModel = new ProcessWappMessageTempDBModel();
            processWappMessageTempDBModel.setProcessId(processId);
            processWappMessageTempDBModel.setWappTitle(wappTitle);
            processWappMessageTempDBModel.setWappBody(wappBody);
            processWappMessageTempDBModel.setTypeId(typeId);
            processWappMessageTempDBModel.setMessageType(messageTypeDBModel.get().getMessageType());
            processWappMessageTempDBModel.setTempDatas(new ArrayList<>());
            processWappMessageTempDBModel.setTempAssets(new ArrayList<>());
            processWappMessageTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processWappMessageTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processWappMessageTempDBModel.setStatus(1);

            return new ProcessWappMessageTempWSDTO(processWappMessageTempRepository.save(processWappMessageTempDBModel));
        }
        return null;
    }

    public ProcessWappMessageTempWSDTO updateProcessWappMessageTempService(String tempId, String wappTitle, String wappBody, long typeId) {

        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        Optional<ProcessWappMessageTempDBModel> processWappMessageTempDBModel = processWappMessageTempRepository.findById(tempId);
        if (messageTypeDBModel.isPresent() && processWappMessageTempDBModel.isPresent()) {

            processWappMessageTempDBModel.get().setWappTitle(wappTitle);
            processWappMessageTempDBModel.get().setWappBody(wappBody);
            processWappMessageTempDBModel.get().setTypeId(typeId);
            processWappMessageTempDBModel.get().setMessageType(messageTypeDBModel.get().getMessageType());
            processWappMessageTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processWappMessageTempDBModel.get().setStatus(1);

            return new ProcessWappMessageTempWSDTO(processWappMessageTempRepository.save(processWappMessageTempDBModel.get()));
        }
        return null;
    }

    public ProcessWappMessageTempWSDTO removeProcessWappMessageTempService(String tempId) {

        Optional<ProcessWappMessageTempDBModel> processWappMessageTempDBModel = processWappMessageTempRepository.findById(tempId);
        if (processWappMessageTempDBModel.isPresent()) {
            processWappMessageTempRepository.delete(processWappMessageTempDBModel.get());
            return new ProcessWappMessageTempWSDTO(processWappMessageTempDBModel.get());
        }
        return null;
    }



}
