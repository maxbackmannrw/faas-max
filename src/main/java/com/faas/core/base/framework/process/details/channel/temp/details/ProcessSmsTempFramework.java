package com.faas.core.base.framework.process.details.channel.temp.details;

import com.faas.core.base.model.db.channel.settings.MessageTypeDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.SmsTempDBModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessSmsTempWSDTO;
import com.faas.core.base.repo.channel.settings.MessageTypeRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsTempRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.process.ProcessHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProcessSmsTempFramework {


    @Autowired
    ProcessHelpers processHelpers;

    @Autowired
    SmsTempRepository smsTempRepository;

    @Autowired
    MessageTypeRepository messageTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ProcessSmsTempWSDTO> getProcessSmsTempsService(long userId, String processId) {

        List<ProcessSmsTempWSDTO> processSmsTempWSDTOS = new ArrayList<>();
        List<SmsTempDBModel> smsTempDBModels = smsTempRepository.findByProcessId(processId);
        for (SmsTempDBModel smsTempDBModel : smsTempDBModels) {
            processSmsTempWSDTOS.add(new ProcessSmsTempWSDTO(smsTempDBModel));
        }
        return processSmsTempWSDTOS;
    }

    public ProcessSmsTempWSDTO getProcessSmsTempService(long userId, String tempId) {

        Optional<SmsTempDBModel> processSmsTempDBModel = smsTempRepository.findById(tempId);
        if (processSmsTempDBModel.isPresent()) {
            return new ProcessSmsTempWSDTO(processSmsTempDBModel.get());
        }
        return null;
    }

    public ProcessSmsTempWSDTO createProcessSmsTempService(long userId, String processId, String smsTitle, String smsBody, String senderId, long typeId) {

        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        if (messageTypeDBModel.isPresent()) {

            SmsTempDBModel smsTempDBModel = new SmsTempDBModel();
            smsTempDBModel.setProcessId(processId);
            smsTempDBModel.setSmsTitle(smsTitle);
            smsTempDBModel.setSmsBody(smsBody);
            smsTempDBModel.setSenderId(senderId);
            smsTempDBModel.setTypeId(typeId);
            smsTempDBModel.setMessageType(messageTypeDBModel.get().getMessageType());
            smsTempDBModel.setTempDatas(new ArrayList<>());
            smsTempDBModel.setTempAssets(new ArrayList<>());
            smsTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            smsTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            smsTempDBModel.setStatus(1);

            return new ProcessSmsTempWSDTO(smsTempRepository.save(smsTempDBModel));
        }
        return null;
    }

    public ProcessSmsTempWSDTO updateProcessSmsTempService(String tempId, String smsTitle, String smsBody, String senderId, long typeId) {

        Optional<SmsTempDBModel> smsMessageTempDBModel = smsTempRepository.findById(tempId);
        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        if (smsMessageTempDBModel.isPresent() && messageTypeDBModel.isPresent()) {

            smsMessageTempDBModel.get().setSmsTitle(smsTitle);
            smsMessageTempDBModel.get().setSmsBody(smsBody);
            smsMessageTempDBModel.get().setSenderId(senderId);
            smsMessageTempDBModel.get().setTypeId(typeId);
            smsMessageTempDBModel.get().setMessageType(messageTypeDBModel.get().getMessageType());
            smsMessageTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            smsMessageTempDBModel.get().setStatus(1);

            return new ProcessSmsTempWSDTO(smsTempRepository.save(smsMessageTempDBModel.get()));
        }
        return null;
    }

    public ProcessSmsTempWSDTO removeProcessSmsTempService(String tempId) {

        Optional<SmsTempDBModel> processSmsTempDBModel = smsTempRepository.findById(tempId);
        if (processSmsTempDBModel.isPresent()) {
            smsTempRepository.delete(processSmsTempDBModel.get());
            return new ProcessSmsTempWSDTO(processSmsTempDBModel.get());
        }
        return null;
    }


}
