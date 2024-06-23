package com.faas.core.base.framework.process.details.channel.temp.details;

import com.faas.core.base.model.db.channel.settings.MessageTypeDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.WappMessageTempDBModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessWappMessageTempWSDTO;
import com.faas.core.base.repo.channel.settings.MessageTypeRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.process.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProcessWappTempFramework {


    @Autowired
    ProcessHelper processHelper;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    MessageTypeRepository messageTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ProcessWappMessageTempWSDTO> getProcessWappMessageTempsService(long userId, String processId) {

        List<ProcessWappMessageTempWSDTO> processWappMessageTempWSDTOS = new ArrayList<>();
        List<WappMessageTempDBModel> wappMessageTempDBModels = wappMessageTempRepository.findByProcessId(processId);
        for (WappMessageTempDBModel wappMessageTempDBModel : wappMessageTempDBModels) {
            processWappMessageTempWSDTOS.add(new ProcessWappMessageTempWSDTO(wappMessageTempDBModel));
        }
        return processWappMessageTempWSDTOS;
    }

    public ProcessWappMessageTempWSDTO getProcessWappMessageTempService(long userId, String tempId) {

        Optional<WappMessageTempDBModel> processWappMessageTempDBModel = wappMessageTempRepository.findById(tempId);
        if (processWappMessageTempDBModel.isPresent()){
            return new ProcessWappMessageTempWSDTO(processWappMessageTempDBModel.get());
        }
        return null;
    }


    public ProcessWappMessageTempWSDTO createProcessWappMessageTempService(String processId, String wappTitle, String wappBody, long typeId) {

        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        if (messageTypeDBModel.isPresent()) {

            WappMessageTempDBModel wappMessageTempDBModel = new WappMessageTempDBModel();
            wappMessageTempDBModel.setProcessId(processId);
            wappMessageTempDBModel.setWappTitle(wappTitle);
            wappMessageTempDBModel.setWappBody(wappBody);
            wappMessageTempDBModel.setTypeId(typeId);
            wappMessageTempDBModel.setMessageType(messageTypeDBModel.get().getMessageType());
            wappMessageTempDBModel.setTempDatas(new ArrayList<>());
            wappMessageTempDBModel.setTempAssets(new ArrayList<>());
            wappMessageTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            wappMessageTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            wappMessageTempDBModel.setStatus(1);

            return new ProcessWappMessageTempWSDTO(wappMessageTempRepository.save(wappMessageTempDBModel));
        }
        return null;
    }

    public ProcessWappMessageTempWSDTO updateProcessWappMessageTempService(String tempId, String wappTitle, String wappBody, long typeId) {

        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        Optional<WappMessageTempDBModel> processWappMessageTempDBModel = wappMessageTempRepository.findById(tempId);
        if (messageTypeDBModel.isPresent() && processWappMessageTempDBModel.isPresent()) {

            processWappMessageTempDBModel.get().setWappTitle(wappTitle);
            processWappMessageTempDBModel.get().setWappBody(wappBody);
            processWappMessageTempDBModel.get().setTypeId(typeId);
            processWappMessageTempDBModel.get().setMessageType(messageTypeDBModel.get().getMessageType());
            processWappMessageTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processWappMessageTempDBModel.get().setStatus(1);

            return new ProcessWappMessageTempWSDTO(wappMessageTempRepository.save(processWappMessageTempDBModel.get()));
        }
        return null;
    }

    public ProcessWappMessageTempWSDTO removeProcessWappMessageTempService(String tempId) {

        Optional<WappMessageTempDBModel> processWappMessageTempDBModel = wappMessageTempRepository.findById(tempId);
        if (processWappMessageTempDBModel.isPresent()) {
            wappMessageTempRepository.delete(processWappMessageTempDBModel.get());
            return new ProcessWappMessageTempWSDTO(processWappMessageTempDBModel.get());
        }
        return null;
    }



}
