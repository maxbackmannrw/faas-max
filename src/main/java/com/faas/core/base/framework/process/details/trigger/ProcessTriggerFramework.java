package com.faas.core.base.framework.process.details.trigger;

import com.faas.core.base.model.db.channel.account.EmailAccountDBModel;
import com.faas.core.base.model.db.channel.account.SipAccountDBModel;
import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.*;
import com.faas.core.base.repo.channel.account.EmailAccountRepository;
import com.faas.core.base.repo.channel.account.SipAccountRepository;
import com.faas.core.base.repo.channel.account.SmsAccountRepository;
import com.faas.core.base.repo.channel.account.WappAccountRepository;
import com.faas.core.base.repo.channel.settings.MessageTypeRepository;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.process.settings.TriggerTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProcessTriggerFramework {

    @Autowired
    AiTriggerRepository aiTriggerRepository;

    @Autowired
    EmailTriggerRepository emailTriggerRepository;

    @Autowired
    SipCallTriggerRepository sipCallTriggerRepository;

    @Autowired
    SmsMessageTriggerRepository smsMessageTriggerRepository;

    @Autowired
    WappCallTriggerRepository wappCallTriggerRepository;

    @Autowired
    WappMessageTriggerRepository wappMessageTriggerRepository;

    @Autowired
    SmsAccountRepository smsAccountRepository;

    @Autowired
    WappAccountRepository wappAccountRepository;

    @Autowired
    EmailAccountRepository emailAccountRepository;

    @Autowired
    SipAccountRepository sipAccountRepository;

    @Autowired
    MessageTypeRepository messageTypeRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessTriggerWSDTO getProcessTriggersService(long userId, String processId) {

        ProcessTriggerWSDTO processTriggerWSDTO = new ProcessTriggerWSDTO();

        processTriggerWSDTO.setAiTriggers(getAITriggersService(userId,processId));
        processTriggerWSDTO.setEmailTriggers(getEmailTriggersService(userId,processId));
        processTriggerWSDTO.setSipCallTriggers(getSipCallTriggersService(userId,processId));
        processTriggerWSDTO.setSmsMessageTriggers(getSmsMessageTriggersService(userId,processId));
        processTriggerWSDTO.setWappCallTriggers(getWappCallTriggersService(userId,processId));
        processTriggerWSDTO.setWappMessageTriggers(getWappMessageTriggersService(userId,processId));

        return processTriggerWSDTO;
    }


    public List<AiTriggerWSDTO> getAITriggersService(long userId, String processId) {

        List<AiTriggerWSDTO>aiTriggerWSDTOS = new ArrayList<>();
        List<AiTriggerDBModel> aiTriggerDBModels = aiTriggerRepository.findByProcessId(processId);
        for (AiTriggerDBModel aiTriggerDBModel : aiTriggerDBModels) {
            aiTriggerWSDTOS.add(new AiTriggerWSDTO(aiTriggerDBModel));
        }
        return aiTriggerWSDTOS;
    }

    public AiTriggerWSDTO getAITriggerService(long userId, String triggerId) {

        Optional<AiTriggerDBModel> aiTriggerDBModel = aiTriggerRepository.findById(triggerId);
        if (aiTriggerDBModel.isPresent()){
            return new AiTriggerWSDTO(aiTriggerDBModel.get());
        }
        return null;
    }

    public AiTriggerWSDTO createAITriggerService(long userId,String processId,String trigger,String triggerDesc,String accountId,long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            AiTriggerDBModel aiTriggerDBModel = new AiTriggerDBModel();
            aiTriggerDBModel.setProcessId(processId);
            aiTriggerDBModel.setTrigger(trigger);
            aiTriggerDBModel.setTriggerDesc(triggerDesc);
            aiTriggerDBModel.setAccountId(accountId);
            aiTriggerDBModel.setAccount("");
            aiTriggerDBModel.setDatas(new ArrayList<>());
            aiTriggerDBModel.setTypeId(typeId);
            aiTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            aiTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            aiTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            aiTriggerDBModel.setStatus(1);

            return new AiTriggerWSDTO(aiTriggerRepository.save(aiTriggerDBModel));
        }
        return null;
    }

    public AiTriggerWSDTO updateAITriggerService(long userId,String triggerId,String trigger,String triggerDesc,String accountId) {

        Optional<AiTriggerDBModel> aiTriggerDBModel = aiTriggerRepository.findById(triggerId);
        if (aiTriggerDBModel.isPresent()){

            aiTriggerDBModel.get().setTrigger(trigger);
            aiTriggerDBModel.get().setTriggerDesc(triggerDesc);
            aiTriggerDBModel.get().setAccountId(accountId);
            aiTriggerDBModel.get().setAccount("");
            aiTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());

            return new AiTriggerWSDTO(aiTriggerRepository.save(aiTriggerDBModel.get()));
        }
        return null;
    }

    public AiTriggerWSDTO removeAITriggerService(long userId, String triggerId) {

        Optional<AiTriggerDBModel> aiTriggerDBModel = aiTriggerRepository.findById(triggerId);
        if (aiTriggerDBModel.isPresent()){
            aiTriggerRepository.delete(aiTriggerDBModel.get());
            return new AiTriggerWSDTO(aiTriggerDBModel.get());
        }
        return null;
    }


    public List<EmailTriggerWSDTO> getEmailTriggersService(long userId, String processId) {

        List<EmailTriggerWSDTO> emailTriggerWSDTOS = new ArrayList<>();
        List<EmailTriggerDBModel> emailTriggerDBModels = emailTriggerRepository.findByProcessId(processId);
        for (EmailTriggerDBModel emailTriggerDBModel : emailTriggerDBModels) {
            emailTriggerWSDTOS.add(new EmailTriggerWSDTO(emailTriggerDBModel));
        }
        return emailTriggerWSDTOS;
    }

    public EmailTriggerWSDTO getEmailTriggerService(long userId,String triggerId) {

        Optional<EmailTriggerDBModel> emailTriggerDBModel = emailTriggerRepository.findById(triggerId);
        if (emailTriggerDBModel.isPresent()){
            return new EmailTriggerWSDTO(emailTriggerDBModel.get());
        }
        return null;
    }

    public EmailTriggerWSDTO createEmailTriggerService(long userId,String processId,String trigger,String triggerDesc,String accountId,String emailSubject,String emailTitle,String emailBody,String emailSender,long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        if (triggerTypeDBModel.isPresent() && emailAccountDBModel.isPresent()){

            EmailTriggerDBModel emailTriggerDBModel = new EmailTriggerDBModel();
            emailTriggerDBModel.setProcessId(processId);
            emailTriggerDBModel.setTrigger(trigger);
            emailTriggerDBModel.setTriggerDesc(triggerDesc);
            emailTriggerDBModel.setAccountId(accountId);
            emailTriggerDBModel.setAccount(emailAccountDBModel.get().getAccount());
            emailTriggerDBModel.setEmailSubject(emailSubject);
            emailTriggerDBModel.setEmailTitle(emailTitle);
            emailTriggerDBModel.setEmailBody(emailBody);
            emailTriggerDBModel.setEmailSender(emailSender);
            emailTriggerDBModel.setDatas(new ArrayList<>());
            emailTriggerDBModel.setTypeId(typeId);
            emailTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            emailTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            emailTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            emailTriggerDBModel.setStatus(1);

            return new EmailTriggerWSDTO(emailTriggerRepository.save(emailTriggerDBModel));
        }
        return null;
    }

    public EmailTriggerWSDTO updateEmailTriggerService(long userId,String triggerId,String trigger,String triggerDesc,String accountId,String emailSubject,String emailTitle,String emailBody,String emailSender) {

        Optional<EmailTriggerDBModel> emailTriggerDBModel = emailTriggerRepository.findById(triggerId);
        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        if (emailTriggerDBModel.isPresent() && emailAccountDBModel.isPresent()){

            emailTriggerDBModel.get().setTrigger(trigger);
            emailTriggerDBModel.get().setTriggerDesc(triggerDesc);
            emailTriggerDBModel.get().setAccountId(accountId);
            emailTriggerDBModel.get().setAccount(emailAccountDBModel.get().getAccount());
            emailTriggerDBModel.get().setEmailSubject(emailSubject);
            emailTriggerDBModel.get().setEmailTitle(emailTitle);
            emailTriggerDBModel.get().setEmailBody(emailBody);
            emailTriggerDBModel.get().setEmailSender(emailSender);
            emailTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            emailTriggerDBModel.get().setStatus(1);

            return new EmailTriggerWSDTO(emailTriggerRepository.save(emailTriggerDBModel.get()));
        }
        return null;
    }

    public EmailTriggerWSDTO removeEmailTriggerService(long userId, String triggerId) {

        Optional<EmailTriggerDBModel> emailTriggerDBModel = emailTriggerRepository.findById(triggerId);
        if (emailTriggerDBModel.isPresent()){
            emailTriggerRepository.delete(emailTriggerDBModel.get());
            return new EmailTriggerWSDTO(emailTriggerDBModel.get());
        }
        return null;
    }


    public List<SipCallTriggerWSDTO> getSipCallTriggersService(long userId,String processId) {

        List<SipCallTriggerWSDTO> sipCallTriggerWSDTOS = new ArrayList<>();
        List<SipCallTriggerDBModel> sipCallTriggerDBModels = sipCallTriggerRepository.findByProcessId(processId);
        for (SipCallTriggerDBModel sipCallTriggerDBModel : sipCallTriggerDBModels) {
            sipCallTriggerWSDTOS.add(new SipCallTriggerWSDTO(sipCallTriggerDBModel));
        }
        return sipCallTriggerWSDTOS;
    }


    public SipCallTriggerWSDTO getSipCallTriggerService(long userId,String triggerId) {

        Optional<SipCallTriggerDBModel> sipCallTriggerDBModel = sipCallTriggerRepository.findById(triggerId);
        if (sipCallTriggerDBModel.isPresent()){
            return new SipCallTriggerWSDTO(sipCallTriggerDBModel.get());
        }
        return null;
    }

    public SipCallTriggerWSDTO createSipCallTriggerService(long userId,String processId,String trigger,String triggerDesc,String accountId,String callerId,long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (triggerTypeDBModel.isPresent() && sipAccountDBModel.isPresent()){

            SipCallTriggerDBModel sipCallTriggerDBModel = new SipCallTriggerDBModel();
            sipCallTriggerDBModel.setProcessId(processId);
            sipCallTriggerDBModel.setTrigger(trigger);
            sipCallTriggerDBModel.setTriggerDesc(triggerDesc);
            sipCallTriggerDBModel.setAccountId(accountId);
            sipCallTriggerDBModel.setAccount(sipAccountDBModel.get().getAccount());
            sipCallTriggerDBModel.setCallerId(callerId);
            sipCallTriggerDBModel.setTypeId(typeId);
            sipCallTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            sipCallTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            sipCallTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            sipCallTriggerDBModel.setStatus(1);

            return new SipCallTriggerWSDTO(sipCallTriggerRepository.save(sipCallTriggerDBModel));
        }
        return null;
    }

    public SipCallTriggerWSDTO updateSipCallTriggerService(long userId,String triggerId,String trigger,String triggerDesc,String accountId,String callerId) {

        Optional<SipCallTriggerDBModel> sipCallTriggerDBModel = sipCallTriggerRepository.findById(triggerId);
        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (sipCallTriggerDBModel.isPresent() && sipAccountDBModel.isPresent()){

            sipCallTriggerDBModel.get().setTrigger(trigger);
            sipCallTriggerDBModel.get().setTriggerDesc(triggerDesc);
            sipCallTriggerDBModel.get().setAccountId(accountId);
            sipCallTriggerDBModel.get().setAccount(sipAccountDBModel.get().getAccount());
            sipCallTriggerDBModel.get().setCallerId(callerId);
            sipCallTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            sipCallTriggerDBModel.get().setStatus(1);

            return new SipCallTriggerWSDTO(sipCallTriggerRepository.save(sipCallTriggerDBModel.get()));
        }
        return null;
    }

    public SipCallTriggerWSDTO removeSipCallTriggerService(long userId,String triggerId) {

        Optional<SipCallTriggerDBModel> sipCallTriggerDBModel = sipCallTriggerRepository.findById(triggerId);
        if (sipCallTriggerDBModel.isPresent()){
            sipCallTriggerRepository.delete(sipCallTriggerDBModel.get());
            return new SipCallTriggerWSDTO(sipCallTriggerDBModel.get());
        }
        return null;
    }



    public List<SmsMessageTriggerWSDTO> getSmsMessageTriggersService(long userId,String processId) {

        List<SmsMessageTriggerWSDTO>smsMessageTriggerWSDTOS = new ArrayList<>();
        List<SmsMessageTriggerDBModel> smsMessageTriggerDBModels = smsMessageTriggerRepository.findByProcessId(processId);
        for (SmsMessageTriggerDBModel smsMessageTriggerDBModel : smsMessageTriggerDBModels) {
            smsMessageTriggerWSDTOS.add(new SmsMessageTriggerWSDTO(smsMessageTriggerDBModel));
        }
        return smsMessageTriggerWSDTOS;
    }

    public SmsMessageTriggerWSDTO getSmsMessageTriggerService(long userId, String triggerId) {

        Optional<SmsMessageTriggerDBModel> smsMessageTriggerDBModel = smsMessageTriggerRepository.findById(triggerId);
        if (smsMessageTriggerDBModel.isPresent()){
            return new SmsMessageTriggerWSDTO(smsMessageTriggerDBModel.get());
        }
        return null;
    }


    public SmsMessageTriggerWSDTO createSmsMessageTriggerService(long userId,String processId,String trigger,String triggerDesc,String accountId,String smsTitle,String smsBody,String senderId,long typeId) {

        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (smsAccountDBModel.isPresent() && triggerTypeDBModel.isPresent()){

            SmsMessageTriggerDBModel smsMessageTriggerDBModel = new SmsMessageTriggerDBModel();
            smsMessageTriggerDBModel.setProcessId(processId);
            smsMessageTriggerDBModel.setTrigger(trigger);
            smsMessageTriggerDBModel.setTriggerDesc(triggerDesc);
            smsMessageTriggerDBModel.setAccountId(accountId);
            smsMessageTriggerDBModel.setAccount(smsAccountDBModel.get().getAccount());
            smsMessageTriggerDBModel.setSmsTitle(smsTitle);
            smsMessageTriggerDBModel.setSmsBody(smsBody);
            smsMessageTriggerDBModel.setSenderId(senderId);
            smsMessageTriggerDBModel.setDatas(new ArrayList<>());
            smsMessageTriggerDBModel.setTypeId(typeId);
            smsMessageTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            smsMessageTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            smsMessageTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            smsMessageTriggerDBModel.setStatus(1);

            return new SmsMessageTriggerWSDTO(smsMessageTriggerRepository.save(smsMessageTriggerDBModel));
        }
        return null;
    }


    public SmsMessageTriggerWSDTO updateSmsMessageTriggerService(long userId,String triggerId,String trigger,String triggerDesc,String accountId,String smsTitle,String smsBody,String senderId) {

        Optional<SmsMessageTriggerDBModel> smsMessageTriggerDBModel = smsMessageTriggerRepository.findById(triggerId);
        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        if (smsMessageTriggerDBModel.isPresent() && smsAccountDBModel.isPresent()){

            smsMessageTriggerDBModel.get().setTrigger(trigger);
            smsMessageTriggerDBModel.get().setTriggerDesc(triggerDesc);
            smsMessageTriggerDBModel.get().setAccountId(accountId);
            smsMessageTriggerDBModel.get().setAccount(smsAccountDBModel.get().getAccount());
            smsMessageTriggerDBModel.get().setSmsTitle(smsTitle);
            smsMessageTriggerDBModel.get().setSmsBody(smsBody);
            smsMessageTriggerDBModel.get().setSenderId(senderId);
            smsMessageTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            smsMessageTriggerDBModel.get().setStatus(1);

            return new SmsMessageTriggerWSDTO(smsMessageTriggerRepository.save(smsMessageTriggerDBModel.get()));
        }
        return null;
    }

    public SmsMessageTriggerWSDTO removeSmsMessageTriggerService(long userId,String triggerId) {

        Optional<SmsMessageTriggerDBModel> smsMessageTriggerDBModel = smsMessageTriggerRepository.findById(triggerId);
        if (smsMessageTriggerDBModel.isPresent()){
            smsMessageTriggerRepository.delete(smsMessageTriggerDBModel.get());
            return new SmsMessageTriggerWSDTO(smsMessageTriggerDBModel.get());
        }
        return null;
    }



    public List<WappCallTriggerWSDTO> getWappCallTriggersService(long userId,String processId) {

        List<WappCallTriggerWSDTO>wappCallTriggerWSDTOS = new ArrayList<>();
        List<WappCallTriggerDBModel> wappCallTriggerDBModels = wappCallTriggerRepository.findByProcessId(processId);
        for (WappCallTriggerDBModel wappCallTriggerDBModel : wappCallTriggerDBModels) {
            wappCallTriggerWSDTOS.add(new WappCallTriggerWSDTO(wappCallTriggerDBModel));
        }
        return wappCallTriggerWSDTOS;
    }

    public WappCallTriggerWSDTO getWappCallTriggerService(long userId, String triggerId) {

        Optional<WappCallTriggerDBModel> wappCallTriggerDBModel = wappCallTriggerRepository.findById(triggerId);
        if (wappCallTriggerDBModel.isPresent()){
            return new WappCallTriggerWSDTO(wappCallTriggerDBModel.get());
        }
        return null;
    }

    public WappCallTriggerWSDTO createWappCallTriggerService(long userId,String processId,String trigger,String triggerDesc,String accountId,long typeId) {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (wappAccountDBModel.isPresent() && triggerTypeDBModel.isPresent()){

            WappCallTriggerDBModel wappCallTriggerDBModel = new WappCallTriggerDBModel();
            wappCallTriggerDBModel.setProcessId(processId);
            wappCallTriggerDBModel.setTrigger(trigger);
            wappCallTriggerDBModel.setTriggerDesc(triggerDesc);
            wappCallTriggerDBModel.setAccountId(accountId);
            wappCallTriggerDBModel.setAccount(wappAccountDBModel.get().getAccount());
            wappCallTriggerDBModel.setDatas(new ArrayList<>());
            wappCallTriggerDBModel.setTypeId(typeId);
            wappCallTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            wappCallTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            wappCallTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            wappCallTriggerDBModel.setStatus(1);

            return new WappCallTriggerWSDTO(wappCallTriggerRepository.save(wappCallTriggerDBModel));
        }
        return null;
    }

    public WappCallTriggerWSDTO updateWappCallTriggerService(long userId,String triggerId,String trigger,String triggerDesc,String accountId) {

        Optional<WappCallTriggerDBModel> wappCallTriggerDBModel = wappCallTriggerRepository.findById(triggerId);
        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (wappCallTriggerDBModel.isPresent() && wappAccountDBModel.isPresent()){

            wappCallTriggerDBModel.get().setTrigger(trigger);
            wappCallTriggerDBModel.get().setTriggerDesc(triggerDesc);
            wappCallTriggerDBModel.get().setAccountId(accountId);
            wappCallTriggerDBModel.get().setAccount(wappAccountDBModel.get().getAccount());
            wappCallTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            wappCallTriggerDBModel.get().setStatus(1);

            return new WappCallTriggerWSDTO(wappCallTriggerRepository.save(wappCallTriggerDBModel.get()));
        }
        return null;
    }

    public WappCallTriggerWSDTO removeWappCallTriggerService(long userId,String triggerId) {

        Optional<WappCallTriggerDBModel> wappCallTriggerDBModel = wappCallTriggerRepository.findById(triggerId);
        if (wappCallTriggerDBModel.isPresent()){
            wappCallTriggerRepository.delete(wappCallTriggerDBModel.get());
            return new WappCallTriggerWSDTO(wappCallTriggerDBModel.get());
        }
        return null;
    }


    public List<WappMessageTriggerWSDTO> getWappMessageTriggersService(long userId,String processId) {

        List<WappMessageTriggerWSDTO>wappMessageTriggerWSDTOS = new ArrayList<>();
        List<WappMessageTriggerDBModel> wappMessageTriggerDBModels = wappMessageTriggerRepository.findByProcessId(processId);
        for (WappMessageTriggerDBModel wappMessageTriggerDBModel : wappMessageTriggerDBModels) {
            wappMessageTriggerWSDTOS.add(new WappMessageTriggerWSDTO(wappMessageTriggerDBModel));
        }
        return wappMessageTriggerWSDTOS;
    }

    public WappMessageTriggerWSDTO getWappMessageTriggerService(long userId,String triggerId) {

        Optional<WappMessageTriggerDBModel> wappMessageTriggerDBModel = wappMessageTriggerRepository.findById(triggerId);
        if (wappMessageTriggerDBModel.isPresent()){
            return new WappMessageTriggerWSDTO(wappMessageTriggerDBModel.get());
        }
        return null;
    }

    public WappMessageTriggerWSDTO createWappMessageTriggerService(long userId,String processId,String trigger,String triggerDesc,String accountId,String wappTitle,String wappBody,long typeId) {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (wappAccountDBModel.isPresent() && triggerTypeDBModel.isPresent()){

            WappMessageTriggerDBModel wappMessageTriggerDBModel = new WappMessageTriggerDBModel();
            wappMessageTriggerDBModel.setProcessId(processId);
            wappMessageTriggerDBModel.setTrigger(trigger);
            wappMessageTriggerDBModel.setTriggerDesc(triggerDesc);
            wappMessageTriggerDBModel.setAccountId(accountId);
            wappMessageTriggerDBModel.setAccount(wappAccountDBModel.get().getAccount());
            wappMessageTriggerDBModel.setWappTitle(wappTitle);
            wappMessageTriggerDBModel.setWappBody(wappBody);
            wappMessageTriggerDBModel.setDatas(new ArrayList<>());
            wappMessageTriggerDBModel.setTypeId(typeId);
            wappMessageTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            wappMessageTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            wappMessageTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            wappMessageTriggerDBModel.setStatus(1);

            return new WappMessageTriggerWSDTO(wappMessageTriggerRepository.save(wappMessageTriggerDBModel));
        }
        return null;
    }

    public WappMessageTriggerWSDTO updateWappMessageTriggerService(long userId,String triggerId,String trigger,String triggerDesc,String accountId,String wappTitle,String wappBody) {

        Optional<WappMessageTriggerDBModel> wappMessageTriggerDBModel = wappMessageTriggerRepository.findById(triggerId);
        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (wappMessageTriggerDBModel.isPresent() && wappAccountDBModel.isPresent()){

            wappMessageTriggerDBModel.get().setTrigger(trigger);
            wappMessageTriggerDBModel.get().setTriggerDesc(triggerDesc);
            wappMessageTriggerDBModel.get().setAccountId(accountId);
            wappMessageTriggerDBModel.get().setAccount(wappAccountDBModel.get().getAccount());
            wappMessageTriggerDBModel.get().setWappTitle(wappTitle);
            wappMessageTriggerDBModel.get().setWappBody(wappBody);
            wappMessageTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            wappMessageTriggerDBModel.get().setStatus(1);

            return new WappMessageTriggerWSDTO(wappMessageTriggerRepository.save(wappMessageTriggerDBModel.get()));
        }
        return null;
    }

    public WappMessageTriggerWSDTO removeWappMessageTriggerService(long userId, String triggerId) {

        Optional<WappMessageTriggerDBModel> wappMessageTriggerDBModel = wappMessageTriggerRepository.findById(triggerId);
        if (wappMessageTriggerDBModel.isPresent()){
            wappMessageTriggerRepository.delete(wappMessageTriggerDBModel.get());
            return new WappMessageTriggerWSDTO(wappMessageTriggerDBModel.get());
        }
        return null;
    }



}
