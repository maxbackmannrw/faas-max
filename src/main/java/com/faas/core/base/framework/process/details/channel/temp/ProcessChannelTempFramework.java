package com.faas.core.base.framework.process.details.channel.temp;

import com.faas.core.base.model.db.channel.settings.EmailTypeDBModel;
import com.faas.core.base.model.db.channel.settings.MessageTypeDBModel;
import com.faas.core.base.model.db.channel.settings.PushTypeDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.*;
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
public class ProcessChannelTempFramework {


    @Autowired
    ProcessHelper processHelper;

    @Autowired
    ProcessSmsTempRepository processSmsTempRepository;

    @Autowired
    ProcessWappMessageTempRepository processWappMessageTempRepository;

    @Autowired
    ProcessEmailTempRepository processEmailTempRepository;

    @Autowired
    ProcessPushTempRepository processPushTempRepository;

    @Autowired
    EmailTypeRepository emailTypeRepository;

    @Autowired
    MessageTypeRepository messageTypeRepository;

    @Autowired
    PushTypeRepository pushTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessTempWSDTO getProcessTempService(long userId, String processId) {
        return processHelper.createProcessTempWSDTO(processId);
    }


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

    public ProcessSmsTempWSDTO createProcessSmsTempService(String processId, String smsTitle, String smsBody, String senderId, long typeId) {

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
            processWappMessageTempDBModel.setDatas(new ArrayList<>());
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



    public List<ProcessEmailTempWSDTO> getProcessEmailTempsService(long userId, String processId) {

        List<ProcessEmailTempWSDTO> processEmailTempWSDTOS = new ArrayList<>();
        List<ProcessEmailTempDBModel> processEmailTempDBModels = processEmailTempRepository.findByProcessId(processId);
        for (ProcessEmailTempDBModel processEmailTempDBModel : processEmailTempDBModels) {
            processEmailTempWSDTOS.add(new ProcessEmailTempWSDTO(processEmailTempDBModel));
        }
        return processEmailTempWSDTOS;
    }

    public ProcessEmailTempWSDTO getProcessEmailTempService(long userId, String tempId) {

        Optional<ProcessEmailTempDBModel> processEmailTempDBModel = processEmailTempRepository.findById(tempId);
        if (processEmailTempDBModel.isPresent()) {
            new ProcessEmailTempWSDTO(processEmailTempDBModel.get());
        }
        return null;
    }

    public ProcessEmailTempWSDTO createProcessEmailTempService(String processId, String emailSubject, String emailBody, String emailFooter, String emailSender, long typeId) {

        ProcessEmailTempDBModel processEmailTempDBModel = new ProcessEmailTempDBModel();
        processEmailTempDBModel.setProcessId(processId);
        processEmailTempDBModel.setEmailSubject(emailSubject);
        processEmailTempDBModel.setEmailBody(emailBody);
        processEmailTempDBModel.setEmailFooter(emailFooter);
        processEmailTempDBModel.setEmailSender(emailSender);
        Optional<EmailTypeDBModel> emailTypeDBModel = emailTypeRepository.findById(typeId);
        if (emailTypeDBModel.isPresent()){
            processEmailTempDBModel.setTypeId(typeId);
            processEmailTempDBModel.setEmailType(emailTypeDBModel.get().getEmailType());
        }
        processEmailTempDBModel.setDatas(new ArrayList<>());
        processEmailTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
        processEmailTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
        processEmailTempDBModel.setStatus(1);

        return new ProcessEmailTempWSDTO(processEmailTempRepository.save(processEmailTempDBModel));
    }


    public ProcessEmailTempWSDTO updateProcessEmailTempService(String tempId, String emailSubject, String emailBody, String emailFooter, String emailSender, long typeId) {

        Optional<ProcessEmailTempDBModel> processEmailTempDBModel = processEmailTempRepository.findById(tempId);
        Optional<EmailTypeDBModel> emailTypeDBModel = emailTypeRepository.findById(typeId);
        if (processEmailTempDBModel.isPresent() && emailTypeDBModel.isPresent()){

            processEmailTempDBModel.get().setEmailSubject(emailSubject);
            processEmailTempDBModel.get().setEmailBody(emailBody);
            processEmailTempDBModel.get().setEmailFooter(emailFooter);
            processEmailTempDBModel.get().setEmailSender(emailSender);
            processEmailTempDBModel.get().setTypeId(typeId);
            processEmailTempDBModel.get().setEmailType(emailTypeDBModel.get().getEmailType());
            processEmailTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processEmailTempDBModel.get().setStatus(1);

            return new ProcessEmailTempWSDTO(processEmailTempRepository.save(processEmailTempDBModel.get()));
        }
        return null;
    }

    public ProcessEmailTempWSDTO removeProcessEmailTempService(String tempId) {

        Optional<ProcessEmailTempDBModel> processEmailTempDBModel = processEmailTempRepository.findById(tempId);
        if (processEmailTempDBModel.isPresent()){
            processEmailTempRepository.delete(processEmailTempDBModel.get());
            return new ProcessEmailTempWSDTO(processEmailTempDBModel.get());
        }
        return null;
    }



    public List<ProcessPushTempWSDTO> getProcessPushTempsService(long userId,String processId) {

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

    public ProcessPushTempWSDTO createProcessPushTempService(String processId, String pushHeader, String pushBody, String pushFooter, String pushSender, long typeId) {

        Optional<PushTypeDBModel> pushTypeDBModel = pushTypeRepository.findById(typeId);
        if (pushTypeDBModel.isPresent()){

            ProcessPushTempDBModel processPushTempDBModel = new ProcessPushTempDBModel();
            processPushTempDBModel.setProcessId(processId);
            processPushTempDBModel.setPushHeader(pushHeader);
            processPushTempDBModel.setPushBody(pushBody);
            processPushTempDBModel.setPushFooter(pushFooter);
            processPushTempDBModel.setPushSender(pushSender);
            processPushTempDBModel.setTypeId(pushTypeDBModel.get().getId());
            processPushTempDBModel.setPushType(pushTypeDBModel.get().getPushType());
            processPushTempDBModel.setDatas(new ArrayList<>());
            processPushTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processPushTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processPushTempDBModel.setStatus(1);

            return new ProcessPushTempWSDTO(processPushTempRepository.save(processPushTempDBModel));
        }
        return null;
    }

    public ProcessPushTempWSDTO updateProcessPushTempService(String tempId, String pushHeader, String pushBody, String pushFooter, String pushSender, long typeId) {

        Optional<ProcessPushTempDBModel> processPushTempDBModel = processPushTempRepository.findById(tempId);
        Optional<PushTypeDBModel> pushTypeDBModel = pushTypeRepository.findById(typeId);
        if (processPushTempDBModel.isPresent() && pushTypeDBModel.isPresent()){

            processPushTempDBModel.get().setPushHeader(pushHeader);
            processPushTempDBModel.get().setPushBody(pushBody);
            processPushTempDBModel.get().setPushFooter(pushFooter);
            processPushTempDBModel.get().setPushSender(pushSender);
            processPushTempDBModel.get().setTypeId(pushTypeDBModel.get().getId());
            processPushTempDBModel.get().setPushType(pushTypeDBModel.get().getPushType());
            processPushTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processPushTempDBModel.get().setStatus(1);

            return new ProcessPushTempWSDTO(processPushTempRepository.save(processPushTempDBModel.get()));
        }
        return null;
    }

    public ProcessPushTempWSDTO removePushTempService(String tempId) {

        Optional<ProcessPushTempDBModel> processPushTempDBModel = processPushTempRepository.findById(tempId);
        if (processPushTempDBModel.isPresent()){
            processPushTempRepository.delete(processPushTempDBModel.get());
            return new ProcessPushTempWSDTO(processPushTempDBModel.get());
        }
        return null;
    }




}
