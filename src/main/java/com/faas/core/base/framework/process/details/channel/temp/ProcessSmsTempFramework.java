package com.faas.core.base.framework.process.details.channel.temp;

import com.faas.core.base.model.db.channel.settings.EmailTypeDBModel;
import com.faas.core.base.model.db.channel.settings.MessageTypeDBModel;
import com.faas.core.base.model.db.channel.settings.PushTypeDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessTempWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessEmailTempWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessPushTempWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessSmsTempWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessWappMessageTempWSDTO;
import com.faas.core.base.repo.channel.settings.EmailTypeRepository;
import com.faas.core.base.repo.channel.settings.MessageTypeRepository;
import com.faas.core.base.repo.channel.settings.PushTypeRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessEmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessPushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessSmsTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessWappMessageTempRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ProcessSmsTempFramework {


    @Autowired
    ProcessHelper processHelper;

    @Autowired
    ProcessSmsTempRepository processSmsTempRepository;

    @Autowired
    MessageTypeRepository messageTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ProcessSmsTempWSDTO> getProcessSmsTempsService(long userId, String processId) {

        List<ProcessSmsTempWSDTO> processSmsTempWSDTOS = new ArrayList<>();
        List<ProcessSmsTempDBModel> processSmsTempDBModels = processSmsTempRepository.findByProcessId(processId);
        for (ProcessSmsTempDBModel processSmsTempDBModel : processSmsTempDBModels) {
            processSmsTempWSDTOS.add(new ProcessSmsTempWSDTO(processSmsTempDBModel));
        }
        return processSmsTempWSDTOS;
    }

    public ProcessSmsTempWSDTO getProcessSmsTempService(long userId, String tempId) {

        Optional<ProcessSmsTempDBModel> processSmsTempDBModel = processSmsTempRepository.findById(tempId);
        if (processSmsTempDBModel.isPresent()) {
            return new ProcessSmsTempWSDTO(processSmsTempDBModel.get());
        }
        return null;
    }

    public ProcessSmsTempWSDTO createProcessSmsTempService(long userId, String processId, String smsTitle, String smsBody, String senderId, String processRemoteId, String remoteUrlId, long typeId) {

        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        if (messageTypeDBModel.isPresent()) {

            ProcessSmsTempDBModel processSmsTempDBModel = new ProcessSmsTempDBModel();
            processSmsTempDBModel.setProcessId(processId);
            processSmsTempDBModel.setSmsTitle(smsTitle);
            processSmsTempDBModel.setSmsBody(smsBody);
            processSmsTempDBModel.setSenderId(senderId);
            processSmsTempDBModel.setTypeId(typeId);
            processSmsTempDBModel.setMessageType(messageTypeDBModel.get().getMessageType());
            processSmsTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processSmsTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processSmsTempDBModel.setStatus(1);

            return new ProcessSmsTempWSDTO(processSmsTempRepository.save(processSmsTempDBModel));
        }
        return null;
    }

    public ProcessSmsTempWSDTO updateProcessSmsTempService(String tempId, String smsTitle, String smsBody, String senderId, long typeId) {

        Optional<ProcessSmsTempDBModel> smsMessageTempDBModel = processSmsTempRepository.findById(tempId);
        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        if (smsMessageTempDBModel.isPresent() && messageTypeDBModel.isPresent()) {

            smsMessageTempDBModel.get().setSmsTitle(smsTitle);
            smsMessageTempDBModel.get().setSmsBody(smsBody);
            smsMessageTempDBModel.get().setSenderId(senderId);
            smsMessageTempDBModel.get().setTypeId(typeId);
            smsMessageTempDBModel.get().setMessageType(messageTypeDBModel.get().getMessageType());
            smsMessageTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            smsMessageTempDBModel.get().setStatus(1);

            return new ProcessSmsTempWSDTO(processSmsTempRepository.save(smsMessageTempDBModel.get()));
        }
        return null;
    }

    public ProcessSmsTempWSDTO removeProcessSmsTempService(String tempId) {

        Optional<ProcessSmsTempDBModel> processSmsTempDBModel = processSmsTempRepository.findById(tempId);
        if (processSmsTempDBModel.isPresent()) {
            processSmsTempRepository.delete(processSmsTempDBModel.get());
            return new ProcessSmsTempWSDTO(processSmsTempDBModel.get());
        }
        return null;
    }


}
