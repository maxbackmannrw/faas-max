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
        List<ProcessAiTriggerDBModel> processAiTriggerDBModels = aiTriggerRepository.findByProcessId(processId);
        for (ProcessAiTriggerDBModel processAiTriggerDBModel : processAiTriggerDBModels) {
            aiTriggerWSDTOS.add(new AiTriggerWSDTO(processAiTriggerDBModel));
        }
        return aiTriggerWSDTOS;
    }

    public AiTriggerWSDTO getAITriggerService(long userId, String triggerId) {

        Optional<ProcessAiTriggerDBModel> aiTriggerDBModel = aiTriggerRepository.findById(triggerId);
        if (aiTriggerDBModel.isPresent()){
            return new AiTriggerWSDTO(aiTriggerDBModel.get());
        }
        return null;
    }

    public AiTriggerWSDTO createAITriggerService(long userId,String processId,String trigger,String triggerDesc,String accountId,long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            ProcessAiTriggerDBModel processAiTriggerDBModel = new ProcessAiTriggerDBModel();
            processAiTriggerDBModel.setProcessId(processId);
            processAiTriggerDBModel.setTrigger(trigger);
            processAiTriggerDBModel.setTriggerDesc(triggerDesc);
            processAiTriggerDBModel.setAccountId(accountId);
            processAiTriggerDBModel.setAccount("");
            processAiTriggerDBModel.setDatas(new ArrayList<>());
            processAiTriggerDBModel.setTypeId(typeId);
            processAiTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            processAiTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processAiTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processAiTriggerDBModel.setStatus(1);

            return new AiTriggerWSDTO(aiTriggerRepository.save(processAiTriggerDBModel));
        }
        return null;
    }

    public AiTriggerWSDTO updateAITriggerService(long userId,String triggerId,String trigger,String triggerDesc,String accountId) {

        Optional<ProcessAiTriggerDBModel> aiTriggerDBModel = aiTriggerRepository.findById(triggerId);
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

        Optional<ProcessAiTriggerDBModel> aiTriggerDBModel = aiTriggerRepository.findById(triggerId);
        if (aiTriggerDBModel.isPresent()){
            aiTriggerRepository.delete(aiTriggerDBModel.get());
            return new AiTriggerWSDTO(aiTriggerDBModel.get());
        }
        return null;
    }


    public List<EmailTriggerWSDTO> getEmailTriggersService(long userId, String processId) {

        List<EmailTriggerWSDTO> emailTriggerWSDTOS = new ArrayList<>();
        List<ProcessEmailTriggerDBModel> processEmailTriggerDBModels = emailTriggerRepository.findByProcessId(processId);
        for (ProcessEmailTriggerDBModel processEmailTriggerDBModel : processEmailTriggerDBModels) {
            emailTriggerWSDTOS.add(new EmailTriggerWSDTO(processEmailTriggerDBModel));
        }
        return emailTriggerWSDTOS;
    }

    public EmailTriggerWSDTO getEmailTriggerService(long userId,String triggerId) {

        Optional<ProcessEmailTriggerDBModel> emailTriggerDBModel = emailTriggerRepository.findById(triggerId);
        if (emailTriggerDBModel.isPresent()){
            return new EmailTriggerWSDTO(emailTriggerDBModel.get());
        }
        return null;
    }

    public EmailTriggerWSDTO createEmailTriggerService(long userId,String processId,String trigger,String triggerDesc,String accountId,String emailSubject,String emailTitle,String emailBody,String emailSender,long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        if (triggerTypeDBModel.isPresent() && emailAccountDBModel.isPresent()){

            ProcessEmailTriggerDBModel processEmailTriggerDBModel = new ProcessEmailTriggerDBModel();
            processEmailTriggerDBModel.setProcessId(processId);
            processEmailTriggerDBModel.setTrigger(trigger);
            processEmailTriggerDBModel.setTriggerDesc(triggerDesc);
            processEmailTriggerDBModel.setAccountId(accountId);
            processEmailTriggerDBModel.setAccount(emailAccountDBModel.get().getAccount());
            processEmailTriggerDBModel.setEmailSubject(emailSubject);
            processEmailTriggerDBModel.setEmailTitle(emailTitle);
            processEmailTriggerDBModel.setEmailBody(emailBody);
            processEmailTriggerDBModel.setEmailSender(emailSender);
            processEmailTriggerDBModel.setDatas(new ArrayList<>());
            processEmailTriggerDBModel.setTypeId(typeId);
            processEmailTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            processEmailTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processEmailTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processEmailTriggerDBModel.setStatus(1);

            return new EmailTriggerWSDTO(emailTriggerRepository.save(processEmailTriggerDBModel));
        }
        return null;
    }

    public EmailTriggerWSDTO updateEmailTriggerService(long userId,String triggerId,String trigger,String triggerDesc,String accountId,String emailSubject,String emailTitle,String emailBody,String emailSender) {

        Optional<ProcessEmailTriggerDBModel> emailTriggerDBModel = emailTriggerRepository.findById(triggerId);
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

        Optional<ProcessEmailTriggerDBModel> emailTriggerDBModel = emailTriggerRepository.findById(triggerId);
        if (emailTriggerDBModel.isPresent()){
            emailTriggerRepository.delete(emailTriggerDBModel.get());
            return new EmailTriggerWSDTO(emailTriggerDBModel.get());
        }
        return null;
    }


    public List<SipCallTriggerWSDTO> getSipCallTriggersService(long userId,String processId) {

        List<SipCallTriggerWSDTO> sipCallTriggerWSDTOS = new ArrayList<>();
        List<ProcessSipCallTriggerDBModel> processSipCallTriggerDBModels = sipCallTriggerRepository.findByProcessId(processId);
        for (ProcessSipCallTriggerDBModel processSipCallTriggerDBModel : processSipCallTriggerDBModels) {
            sipCallTriggerWSDTOS.add(new SipCallTriggerWSDTO(processSipCallTriggerDBModel));
        }
        return sipCallTriggerWSDTOS;
    }


    public SipCallTriggerWSDTO getSipCallTriggerService(long userId,String triggerId) {

        Optional<ProcessSipCallTriggerDBModel> sipCallTriggerDBModel = sipCallTriggerRepository.findById(triggerId);
        if (sipCallTriggerDBModel.isPresent()){
            return new SipCallTriggerWSDTO(sipCallTriggerDBModel.get());
        }
        return null;
    }

    public SipCallTriggerWSDTO createSipCallTriggerService(long userId,String processId,String trigger,String triggerDesc,String accountId,String callerId,long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (triggerTypeDBModel.isPresent() && sipAccountDBModel.isPresent()){

            ProcessSipCallTriggerDBModel processSipCallTriggerDBModel = new ProcessSipCallTriggerDBModel();
            processSipCallTriggerDBModel.setProcessId(processId);
            processSipCallTriggerDBModel.setTrigger(trigger);
            processSipCallTriggerDBModel.setTriggerDesc(triggerDesc);
            processSipCallTriggerDBModel.setAccountId(accountId);
            processSipCallTriggerDBModel.setAccount(sipAccountDBModel.get().getAccount());
            processSipCallTriggerDBModel.setCallerId(callerId);
            processSipCallTriggerDBModel.setTypeId(typeId);
            processSipCallTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            processSipCallTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processSipCallTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processSipCallTriggerDBModel.setStatus(1);

            return new SipCallTriggerWSDTO(sipCallTriggerRepository.save(processSipCallTriggerDBModel));
        }
        return null;
    }

    public SipCallTriggerWSDTO updateSipCallTriggerService(long userId,String triggerId,String trigger,String triggerDesc,String accountId,String callerId) {

        Optional<ProcessSipCallTriggerDBModel> sipCallTriggerDBModel = sipCallTriggerRepository.findById(triggerId);
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

        Optional<ProcessSipCallTriggerDBModel> sipCallTriggerDBModel = sipCallTriggerRepository.findById(triggerId);
        if (sipCallTriggerDBModel.isPresent()){
            sipCallTriggerRepository.delete(sipCallTriggerDBModel.get());
            return new SipCallTriggerWSDTO(sipCallTriggerDBModel.get());
        }
        return null;
    }



    public List<SmsMessageTriggerWSDTO> getSmsMessageTriggersService(long userId,String processId) {

        List<SmsMessageTriggerWSDTO>smsMessageTriggerWSDTOS = new ArrayList<>();
        List<ProcessSmsMessageTriggerDBModel> processSmsMessageTriggerDBModels = smsMessageTriggerRepository.findByProcessId(processId);
        for (ProcessSmsMessageTriggerDBModel processSmsMessageTriggerDBModel : processSmsMessageTriggerDBModels) {
            smsMessageTriggerWSDTOS.add(new SmsMessageTriggerWSDTO(processSmsMessageTriggerDBModel));
        }
        return smsMessageTriggerWSDTOS;
    }

    public SmsMessageTriggerWSDTO getSmsMessageTriggerService(long userId, String triggerId) {

        Optional<ProcessSmsMessageTriggerDBModel> smsMessageTriggerDBModel = smsMessageTriggerRepository.findById(triggerId);
        if (smsMessageTriggerDBModel.isPresent()){
            return new SmsMessageTriggerWSDTO(smsMessageTriggerDBModel.get());
        }
        return null;
    }


    public SmsMessageTriggerWSDTO createSmsMessageTriggerService(long userId,String processId,String trigger,String triggerDesc,String accountId,String smsTitle,String smsBody,String senderId,long typeId) {

        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (smsAccountDBModel.isPresent() && triggerTypeDBModel.isPresent()){

            ProcessSmsMessageTriggerDBModel processSmsMessageTriggerDBModel = new ProcessSmsMessageTriggerDBModel();
            processSmsMessageTriggerDBModel.setProcessId(processId);
            processSmsMessageTriggerDBModel.setTrigger(trigger);
            processSmsMessageTriggerDBModel.setTriggerDesc(triggerDesc);
            processSmsMessageTriggerDBModel.setAccountId(accountId);
            processSmsMessageTriggerDBModel.setAccount(smsAccountDBModel.get().getAccount());
            processSmsMessageTriggerDBModel.setSmsTitle(smsTitle);
            processSmsMessageTriggerDBModel.setSmsBody(smsBody);
            processSmsMessageTriggerDBModel.setSenderId(senderId);
            processSmsMessageTriggerDBModel.setDatas(new ArrayList<>());
            processSmsMessageTriggerDBModel.setTypeId(typeId);
            processSmsMessageTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            processSmsMessageTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processSmsMessageTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processSmsMessageTriggerDBModel.setStatus(1);

            return new SmsMessageTriggerWSDTO(smsMessageTriggerRepository.save(processSmsMessageTriggerDBModel));
        }
        return null;
    }


    public SmsMessageTriggerWSDTO updateSmsMessageTriggerService(long userId,String triggerId,String trigger,String triggerDesc,String accountId,String smsTitle,String smsBody,String senderId) {

        Optional<ProcessSmsMessageTriggerDBModel> smsMessageTriggerDBModel = smsMessageTriggerRepository.findById(triggerId);
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

        Optional<ProcessSmsMessageTriggerDBModel> smsMessageTriggerDBModel = smsMessageTriggerRepository.findById(triggerId);
        if (smsMessageTriggerDBModel.isPresent()){
            smsMessageTriggerRepository.delete(smsMessageTriggerDBModel.get());
            return new SmsMessageTriggerWSDTO(smsMessageTriggerDBModel.get());
        }
        return null;
    }



    public List<WappCallTriggerWSDTO> getWappCallTriggersService(long userId,String processId) {

        List<WappCallTriggerWSDTO>wappCallTriggerWSDTOS = new ArrayList<>();
        List<ProcessWappCallTriggerDBModel> processWappCallTriggerDBModels = wappCallTriggerRepository.findByProcessId(processId);
        for (ProcessWappCallTriggerDBModel processWappCallTriggerDBModel : processWappCallTriggerDBModels) {
            wappCallTriggerWSDTOS.add(new WappCallTriggerWSDTO(processWappCallTriggerDBModel));
        }
        return wappCallTriggerWSDTOS;
    }

    public WappCallTriggerWSDTO getWappCallTriggerService(long userId, String triggerId) {

        Optional<ProcessWappCallTriggerDBModel> wappCallTriggerDBModel = wappCallTriggerRepository.findById(triggerId);
        if (wappCallTriggerDBModel.isPresent()){
            return new WappCallTriggerWSDTO(wappCallTriggerDBModel.get());
        }
        return null;
    }

    public WappCallTriggerWSDTO createWappCallTriggerService(long userId,String processId,String trigger,String triggerDesc,String accountId,long typeId) {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (wappAccountDBModel.isPresent() && triggerTypeDBModel.isPresent()){

            ProcessWappCallTriggerDBModel processWappCallTriggerDBModel = new ProcessWappCallTriggerDBModel();
            processWappCallTriggerDBModel.setProcessId(processId);
            processWappCallTriggerDBModel.setTrigger(trigger);
            processWappCallTriggerDBModel.setTriggerDesc(triggerDesc);
            processWappCallTriggerDBModel.setAccountId(accountId);
            processWappCallTriggerDBModel.setAccount(wappAccountDBModel.get().getAccount());
            processWappCallTriggerDBModel.setDatas(new ArrayList<>());
            processWappCallTriggerDBModel.setTypeId(typeId);
            processWappCallTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            processWappCallTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processWappCallTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processWappCallTriggerDBModel.setStatus(1);

            return new WappCallTriggerWSDTO(wappCallTriggerRepository.save(processWappCallTriggerDBModel));
        }
        return null;
    }

    public WappCallTriggerWSDTO updateWappCallTriggerService(long userId,String triggerId,String trigger,String triggerDesc,String accountId) {

        Optional<ProcessWappCallTriggerDBModel> wappCallTriggerDBModel = wappCallTriggerRepository.findById(triggerId);
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

        Optional<ProcessWappCallTriggerDBModel> wappCallTriggerDBModel = wappCallTriggerRepository.findById(triggerId);
        if (wappCallTriggerDBModel.isPresent()){
            wappCallTriggerRepository.delete(wappCallTriggerDBModel.get());
            return new WappCallTriggerWSDTO(wappCallTriggerDBModel.get());
        }
        return null;
    }


    public List<WappMessageTriggerWSDTO> getWappMessageTriggersService(long userId,String processId) {

        List<WappMessageTriggerWSDTO>wappMessageTriggerWSDTOS = new ArrayList<>();
        List<ProcessWappMessageTriggerDBModel> processWappMessageTriggerDBModels = wappMessageTriggerRepository.findByProcessId(processId);
        for (ProcessWappMessageTriggerDBModel processWappMessageTriggerDBModel : processWappMessageTriggerDBModels) {
            wappMessageTriggerWSDTOS.add(new WappMessageTriggerWSDTO(processWappMessageTriggerDBModel));
        }
        return wappMessageTriggerWSDTOS;
    }

    public WappMessageTriggerWSDTO getWappMessageTriggerService(long userId,String triggerId) {

        Optional<ProcessWappMessageTriggerDBModel> wappMessageTriggerDBModel = wappMessageTriggerRepository.findById(triggerId);
        if (wappMessageTriggerDBModel.isPresent()){
            return new WappMessageTriggerWSDTO(wappMessageTriggerDBModel.get());
        }
        return null;
    }

    public WappMessageTriggerWSDTO createWappMessageTriggerService(long userId,String processId,String trigger,String triggerDesc,String accountId,String wappTitle,String wappBody,long typeId) {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (wappAccountDBModel.isPresent() && triggerTypeDBModel.isPresent()){

            ProcessWappMessageTriggerDBModel processWappMessageTriggerDBModel = new ProcessWappMessageTriggerDBModel();
            processWappMessageTriggerDBModel.setProcessId(processId);
            processWappMessageTriggerDBModel.setTrigger(trigger);
            processWappMessageTriggerDBModel.setTriggerDesc(triggerDesc);
            processWappMessageTriggerDBModel.setAccountId(accountId);
            processWappMessageTriggerDBModel.setAccount(wappAccountDBModel.get().getAccount());
            processWappMessageTriggerDBModel.setWappTitle(wappTitle);
            processWappMessageTriggerDBModel.setWappBody(wappBody);
            processWappMessageTriggerDBModel.setDatas(new ArrayList<>());
            processWappMessageTriggerDBModel.setTypeId(typeId);
            processWappMessageTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            processWappMessageTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processWappMessageTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processWappMessageTriggerDBModel.setStatus(1);

            return new WappMessageTriggerWSDTO(wappMessageTriggerRepository.save(processWappMessageTriggerDBModel));
        }
        return null;
    }

    public WappMessageTriggerWSDTO updateWappMessageTriggerService(long userId,String triggerId,String trigger,String triggerDesc,String accountId,String wappTitle,String wappBody) {

        Optional<ProcessWappMessageTriggerDBModel> wappMessageTriggerDBModel = wappMessageTriggerRepository.findById(triggerId);
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

        Optional<ProcessWappMessageTriggerDBModel> wappMessageTriggerDBModel = wappMessageTriggerRepository.findById(triggerId);
        if (wappMessageTriggerDBModel.isPresent()){
            wappMessageTriggerRepository.delete(wappMessageTriggerDBModel.get());
            return new WappMessageTriggerWSDTO(wappMessageTriggerDBModel.get());
        }
        return null;
    }



}
