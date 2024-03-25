package com.faas.core.base.framework.process.details.channel.temp;

import com.faas.core.base.model.db.channel.settings.EmailTypeDBModel;
import com.faas.core.base.model.db.channel.settings.MessageTypeDBModel;
import com.faas.core.base.model.db.channel.settings.PushTypeDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessEmailTempWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessPushTempWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessSmsTempWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessWappMessageTempWSDTO;
import com.faas.core.base.repo.channel.settings.EmailTypeRepository;
import com.faas.core.base.repo.channel.settings.MessageTypeRepository;
import com.faas.core.base.repo.channel.settings.PushTypeRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessEmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessPushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessSmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessWappMessageTempRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;


@Component
public class ProcessChannelTempFramework {


    @Autowired
    ProcessSmsMessageTempRepository processSmsMessageTempRepository;

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


    public ProcessSmsTempWSDTO fillSmsMessageTempWSDTO(ProcessSmsTempDBModel processSmsTempDBModel) {

        ProcessSmsTempWSDTO processSmsTempWSDTO = new ProcessSmsTempWSDTO();
        processSmsTempWSDTO.setSmsMessageTemp(processSmsTempDBModel);
        return processSmsTempWSDTO;
    }


    public ProcessSmsTempDBModel createSmsMessageTempService(String processId, String smsTitle, String smsBody, String senderId, long typeId) {

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

            return processSmsMessageTempRepository.save(processSmsTempDBModel);
        }
        return null;
    }



    public ProcessSmsTempDBModel updateSmsMessageTempService(String tempId, String smsTitle, String smsBody, String senderId, long typeId) {

        Optional<ProcessSmsTempDBModel> smsMessageTempDBModel = processSmsMessageTempRepository.findById(tempId);
        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        if (smsMessageTempDBModel.isPresent() && messageTypeDBModel.isPresent()) {

            smsMessageTempDBModel.get().setSmsTitle(smsTitle);
            smsMessageTempDBModel.get().setSmsBody(smsBody);
            smsMessageTempDBModel.get().setSenderId(senderId);
            smsMessageTempDBModel.get().setTypeId(typeId);
            smsMessageTempDBModel.get().setMessageType(messageTypeDBModel.get().getMessageType());
            smsMessageTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            smsMessageTempDBModel.get().setStatus(1);

            return processSmsMessageTempRepository.save(smsMessageTempDBModel.get());
        }
        return null;
    }


    public ProcessSmsTempDBModel removeSmsMessageTempService(String tempId) {

        Optional<ProcessSmsTempDBModel> smsMessageTempDBModel = processSmsMessageTempRepository.findById(tempId);
        if (smsMessageTempDBModel.isPresent()) {
            processSmsMessageTempRepository.delete(smsMessageTempDBModel.get());
            return smsMessageTempDBModel.get();
        }
        return null;
    }



    public ProcessWappMessageTempWSDTO fillWappMessageTempWSDTO(ProcessWappMessageTempDBModel processWappMessageTempDBModel) {

        ProcessWappMessageTempWSDTO processWappMessageTempWSDTO = new ProcessWappMessageTempWSDTO();
        processWappMessageTempWSDTO.setWappMessageTemp(processWappMessageTempDBModel);
        return processWappMessageTempWSDTO;
    }


    public ProcessWappMessageTempDBModel createWappMessageTempService(String processId, String wappTitle, String wappBody, long typeId) {

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

            return processWappMessageTempRepository.save(processWappMessageTempDBModel);
        }
        return null;
    }

    public ProcessWappMessageTempDBModel updateWappMessageTempService(String tempId, String wappTitle, String wappBody, long typeId) {

        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        Optional<ProcessWappMessageTempDBModel> wappMessageTempDBModel = processWappMessageTempRepository.findById(tempId);
        if (messageTypeDBModel.isPresent() && wappMessageTempDBModel.isPresent()) {

            wappMessageTempDBModel.get().setWappTitle(wappTitle);
            wappMessageTempDBModel.get().setWappBody(wappBody);
            wappMessageTempDBModel.get().setTypeId(typeId);
            wappMessageTempDBModel.get().setMessageType(messageTypeDBModel.get().getMessageType());
            wappMessageTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            wappMessageTempDBModel.get().setStatus(1);

            return processWappMessageTempRepository.save(wappMessageTempDBModel.get());
        }
        return null;
    }

    public ProcessWappMessageTempDBModel removeWappMessageTempService(String tempId) {

        Optional<ProcessWappMessageTempDBModel> wappMessageDBModel = processWappMessageTempRepository.findById(tempId);
        if (wappMessageDBModel.isPresent()) {
            processWappMessageTempRepository.delete(wappMessageDBModel.get());
            return wappMessageDBModel.get();
        }
        return null;
    }


    public ProcessEmailTempWSDTO fillEmailTempWSDTO(ProcessEmailTempDBModel processEmailTempDBModel) {

        ProcessEmailTempWSDTO processEmailTempWSDTO = new ProcessEmailTempWSDTO();
        processEmailTempWSDTO.setEmailTemp(processEmailTempDBModel);
        return processEmailTempWSDTO;
    }


    public ProcessEmailTempDBModel createEmailTempService(String processId, String emailSubject, String emailBody, String emailFooter, String emailSender, long typeId) {

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

        return processEmailTempRepository.save(processEmailTempDBModel);
    }


    public ProcessEmailTempDBModel updateEmailTempService(String tempId, String emailSubject, String emailBody, String emailFooter, String emailSender, long typeId) {

        Optional<ProcessEmailTempDBModel> emailTempDBModel = processEmailTempRepository.findById(tempId);
        Optional<EmailTypeDBModel> emailTypeDBModel = emailTypeRepository.findById(typeId);
        if (emailTempDBModel.isPresent() && emailTypeDBModel.isPresent()){

            emailTempDBModel.get().setEmailSubject(emailSubject);
            emailTempDBModel.get().setEmailBody(emailBody);
            emailTempDBModel.get().setEmailFooter(emailFooter);
            emailTempDBModel.get().setEmailSender(emailSender);
            emailTempDBModel.get().setTypeId(typeId);
            emailTempDBModel.get().setEmailType(emailTypeDBModel.get().getEmailType());
            emailTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            emailTempDBModel.get().setStatus(1);

            return processEmailTempRepository.save(emailTempDBModel.get());
        }
        return null;
    }


    public ProcessEmailTempDBModel removeEmailTempService(String tempId) {

        Optional<ProcessEmailTempDBModel> emailTempDBModel = processEmailTempRepository.findById(tempId);
        if (emailTempDBModel.isPresent()){
            processEmailTempRepository.delete(emailTempDBModel.get());
            return emailTempDBModel.get();
        }
        return null;
    }



    public ProcessPushTempWSDTO fillPushTempWSDTO(ProcessPushTempDBModel processPushTempDBModel) {

        ProcessPushTempWSDTO processPushTempWSDTO = new ProcessPushTempWSDTO();
        processPushTempWSDTO.setPushTemp(processPushTempDBModel);
        return processPushTempWSDTO;
    }

    public ProcessPushTempDBModel createPushTempService(String processId, String pushHeader, String pushBody, String pushFooter, String pushSender, long typeId) {

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

            return processPushTempRepository.save(processPushTempDBModel);
        }
        return null;
    }

    public ProcessPushTempDBModel updatePushTempService(String tempId, String pushHeader, String pushBody, String pushFooter, String pushSender, long typeId) {

        Optional<ProcessPushTempDBModel> pushTempDBModel = processPushTempRepository.findById(tempId);
        Optional<PushTypeDBModel> pushTypeDBModel = pushTypeRepository.findById(typeId);
        if (pushTempDBModel.isPresent() && pushTypeDBModel.isPresent()){

            pushTempDBModel.get().setPushHeader(pushHeader);
            pushTempDBModel.get().setPushBody(pushBody);
            pushTempDBModel.get().setPushFooter(pushFooter);
            pushTempDBModel.get().setPushSender(pushSender);
            pushTempDBModel.get().setTypeId(pushTypeDBModel.get().getId());
            pushTempDBModel.get().setPushType(pushTypeDBModel.get().getPushType());
            pushTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            pushTempDBModel.get().setStatus(1);

            return processPushTempRepository.save(pushTempDBModel.get());
        }
        return null;
    }


    public ProcessPushTempDBModel removePushTempService(String tempId) {

        Optional<ProcessPushTempDBModel> pushTempDBModel = processPushTempRepository.findById(tempId);
        if (pushTempDBModel.isPresent()){
            processPushTempRepository.delete(pushTempDBModel.get());
            return pushTempDBModel.get();
        }
        return null;
    }




}
