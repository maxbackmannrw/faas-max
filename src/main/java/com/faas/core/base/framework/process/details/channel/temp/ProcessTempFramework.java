package com.faas.core.base.framework.process.details.channel.temp;

import com.faas.core.base.model.db.channel.settings.EmailTypeDBModel;
import com.faas.core.base.model.db.channel.settings.MessageTypeDBModel;
import com.faas.core.base.model.db.channel.settings.PushTypeDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsMessageTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.EmailTempWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.PushTempWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.SmsMessageTempWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.WappMessageTempWSDTO;
import com.faas.core.base.repo.channel.settings.EmailTypeRepository;
import com.faas.core.base.repo.channel.settings.MessageTypeRepository;
import com.faas.core.base.repo.channel.settings.PushTypeRepository;
import com.faas.core.base.repo.process.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ProcessTempFramework {


    @Autowired
    SmsMessageTempRepository smsMessageTempRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    EmailTypeRepository emailTypeRepository;

    @Autowired
    MessageTypeRepository messageTypeRepository;

    @Autowired
    PushTypeRepository pushTypeRepository;

    @Autowired
    AppUtils appUtils;


    public SmsMessageTempWSDTO fillSmsMessageTempWSDTO(ProcessSmsMessageTempDBModel processSmsMessageTempDBModel) {

        SmsMessageTempWSDTO smsMessageTempWSDTO = new SmsMessageTempWSDTO();
        smsMessageTempWSDTO.setSmsMessageTemp(processSmsMessageTempDBModel);
        return smsMessageTempWSDTO;
    }


    public ProcessSmsMessageTempDBModel createSmsMessageTempService(String processId, String smsTitle, String smsBody, String senderId, long typeId) {

        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        if (messageTypeDBModel.isPresent()) {

            ProcessSmsMessageTempDBModel processSmsMessageTempDBModel = new ProcessSmsMessageTempDBModel();
            processSmsMessageTempDBModel.setProcessId(processId);
            processSmsMessageTempDBModel.setSmsTitle(smsTitle);
            processSmsMessageTempDBModel.setSmsBody(smsBody);
            processSmsMessageTempDBModel.setSenderId(senderId);
            processSmsMessageTempDBModel.setTypeId(typeId);
            processSmsMessageTempDBModel.setMessageType(messageTypeDBModel.get().getMessageType());
            processSmsMessageTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processSmsMessageTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processSmsMessageTempDBModel.setStatus(1);

            return smsMessageTempRepository.save(processSmsMessageTempDBModel);
        }
        return null;
    }



    public ProcessSmsMessageTempDBModel updateSmsMessageTempService(String tempId, String smsTitle, String smsBody, String senderId, long typeId) {

        Optional<ProcessSmsMessageTempDBModel> smsMessageTempDBModel = smsMessageTempRepository.findById(tempId);
        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        if (smsMessageTempDBModel.isPresent() && messageTypeDBModel.isPresent()) {

            smsMessageTempDBModel.get().setSmsTitle(smsTitle);
            smsMessageTempDBModel.get().setSmsBody(smsBody);
            smsMessageTempDBModel.get().setSenderId(senderId);
            smsMessageTempDBModel.get().setTypeId(typeId);
            smsMessageTempDBModel.get().setMessageType(messageTypeDBModel.get().getMessageType());
            smsMessageTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            smsMessageTempDBModel.get().setStatus(1);

            return smsMessageTempRepository.save(smsMessageTempDBModel.get());
        }
        return null;
    }


    public ProcessSmsMessageTempDBModel removeSmsMessageTempService(String tempId) {

        Optional<ProcessSmsMessageTempDBModel> smsMessageTempDBModel = smsMessageTempRepository.findById(tempId);
        if (smsMessageTempDBModel.isPresent()) {
            smsMessageTempRepository.delete(smsMessageTempDBModel.get());
            return smsMessageTempDBModel.get();
        }
        return null;
    }



    public WappMessageTempWSDTO fillWappMessageTempWSDTO(ProcessWappMessageTempDBModel processWappMessageTempDBModel) {

        WappMessageTempWSDTO wappMessageTempWSDTO = new WappMessageTempWSDTO();
        wappMessageTempWSDTO.setWappMessageTemp(processWappMessageTempDBModel);
        return wappMessageTempWSDTO;
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
            processWappMessageTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processWappMessageTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processWappMessageTempDBModel.setStatus(1);

            return wappMessageTempRepository.save(processWappMessageTempDBModel);
        }
        return null;
    }

    public ProcessWappMessageTempDBModel updateWappMessageTempService(String tempId, String wappTitle, String wappBody, long typeId) {

        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        Optional<ProcessWappMessageTempDBModel> wappMessageTempDBModel = wappMessageTempRepository.findById(tempId);
        if (messageTypeDBModel.isPresent() && wappMessageTempDBModel.isPresent()) {

            wappMessageTempDBModel.get().setWappTitle(wappTitle);
            wappMessageTempDBModel.get().setWappBody(wappBody);
            wappMessageTempDBModel.get().setTypeId(typeId);
            wappMessageTempDBModel.get().setMessageType(messageTypeDBModel.get().getMessageType());
            wappMessageTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            wappMessageTempDBModel.get().setStatus(1);

            return wappMessageTempRepository.save(wappMessageTempDBModel.get());
        }
        return null;
    }

    public ProcessWappMessageTempDBModel removeWappMessageTempService(String tempId) {

        Optional<ProcessWappMessageTempDBModel> wappMessageDBModel = wappMessageTempRepository.findById(tempId);
        if (wappMessageDBModel.isPresent()) {
            wappMessageTempRepository.delete(wappMessageDBModel.get());
            return wappMessageDBModel.get();
        }
        return null;
    }


    public EmailTempWSDTO fillEmailTempWSDTO(ProcessEmailTempDBModel processEmailTempDBModel) {

        EmailTempWSDTO emailTempWSDTO = new EmailTempWSDTO();
        emailTempWSDTO.setEmailTemp(processEmailTempDBModel);
        return emailTempWSDTO;
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
        processEmailTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
        processEmailTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
        processEmailTempDBModel.setStatus(1);

        return emailTempRepository.save(processEmailTempDBModel);
    }


    public ProcessEmailTempDBModel updateEmailTempService(String tempId, String emailSubject, String emailBody, String emailFooter, String emailSender, long typeId) {

        Optional<ProcessEmailTempDBModel> emailTempDBModel = emailTempRepository.findById(tempId);
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

            return emailTempRepository.save(emailTempDBModel.get());
        }
        return null;
    }


    public ProcessEmailTempDBModel removeEmailTempService(String tempId) {

        Optional<ProcessEmailTempDBModel> emailTempDBModel = emailTempRepository.findById(tempId);
        if (emailTempDBModel.isPresent()){
            emailTempRepository.delete(emailTempDBModel.get());
            return emailTempDBModel.get();
        }
        return null;
    }



    public PushTempWSDTO fillPushTempWSDTO(ProcessPushTempDBModel processPushTempDBModel) {

        PushTempWSDTO pushTempWSDTO = new PushTempWSDTO();
        pushTempWSDTO.setPushTemp(processPushTempDBModel);
        return pushTempWSDTO;
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
            processPushTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processPushTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processPushTempDBModel.setStatus(1);

            return pushTempRepository.save(processPushTempDBModel);
        }
        return null;
    }

    public ProcessPushTempDBModel updatePushTempService(String tempId, String pushHeader, String pushBody, String pushFooter, String pushSender, long typeId) {

        Optional<ProcessPushTempDBModel> pushTempDBModel = pushTempRepository.findById(tempId);
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

            return pushTempRepository.save(pushTempDBModel.get());
        }
        return null;
    }


    public ProcessPushTempDBModel removePushTempService(String tempId) {

        Optional<ProcessPushTempDBModel> pushTempDBModel = pushTempRepository.findById(tempId);
        if (pushTempDBModel.isPresent()){
            pushTempRepository.delete(pushTempDBModel.get());
            return pushTempDBModel.get();
        }
        return null;
    }




}
