package com.faas.core.base.framework.process.details.trigger;

import com.faas.core.base.model.db.channel.account.EmailAccountDBModel;
import com.faas.core.base.model.db.channel.account.SipAccountDBModel;
import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.db.process.details.trigger.ProcessTriggerDBModel;
import com.faas.core.base.model.db.process.details.trigger.dao.*;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessTriggerWSDTO;
import com.faas.core.base.repo.channel.account.EmailAccountRepository;
import com.faas.core.base.repo.channel.account.SipAccountRepository;
import com.faas.core.base.repo.channel.account.SmsAccountRepository;
import com.faas.core.base.repo.channel.account.WappAccountRepository;
import com.faas.core.base.repo.channel.settings.MessageTypeRepository;
import com.faas.core.base.repo.process.details.trigger.ProcessTriggerRepository;
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
    ProcessTriggerRepository processTriggerRepository;

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


    public List<ProcessTriggerWSDTO> getProcessTriggersService(long userId, String processId) {

        List<ProcessTriggerWSDTO> processTriggerWSDTOS = new ArrayList<>();
        List<ProcessTriggerDBModel> processTriggerDBModels = processTriggerRepository.findByProcessId(processId);
        for (ProcessTriggerDBModel processTriggerDBModel : processTriggerDBModels) {
            processTriggerWSDTOS.add(new ProcessTriggerWSDTO(processTriggerDBModel));
        }
        return processTriggerWSDTOS;
    }

    public List<ProcessTriggerWSDTO> getProcessTriggersByTypeService(long userId, String processId, String baseType) {

        List<ProcessTriggerWSDTO> processTriggerWSDTOS = new ArrayList<>();
        List<ProcessTriggerDBModel> processTriggerDBModels = processTriggerRepository.findByProcessIdAndBaseType(processId,baseType);
        for (ProcessTriggerDBModel processTriggerDBModel : processTriggerDBModels) {
            processTriggerWSDTOS.add(new ProcessTriggerWSDTO(processTriggerDBModel));
        }
        return processTriggerWSDTOS;
    }

    public ProcessTriggerWSDTO getProcessTriggerService(long userId, String triggerId) {

        Optional<ProcessTriggerDBModel> processTriggerDBModel = processTriggerRepository.findById(triggerId);
        if (processTriggerDBModel.isPresent()){
            return new ProcessTriggerWSDTO(processTriggerDBModel.get());
        }
        return null;
    }


    public ProcessTriggerWSDTO createAITriggerService(long userId, String processId, String accountId, String trigger, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            ProcessTriggerDBModel processTriggerDBModel = new ProcessTriggerDBModel();
            processTriggerDBModel.setProcessId(processId);
            processTriggerDBModel.setTrigger(trigger);
            processTriggerDBModel.setTriggerDetails(createAITrigger(accountId));
            processTriggerDBModel.setTriggerTypeId(typeId);
            processTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            processTriggerDBModel.setBaseType(triggerTypeDBModel.get().getBaseType());
            processTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processTriggerDBModel.setStatus(1);

            return new ProcessTriggerWSDTO(processTriggerRepository.save(processTriggerDBModel));
        }
        return null;
    }

    public ProcessTriggerDetails createAITrigger(String accountId) {

        ProcessTriggerDetails processTriggerDetails = new ProcessTriggerDetails();
        ProcessAiTriggerDAO processAiTriggerDAO = new ProcessAiTriggerDAO();
        processAiTriggerDAO.setAccountId(accountId);
        processAiTriggerDAO.setAccount("account");
        processAiTriggerDAO.setTriggerDatas(new ArrayList<>());
        processAiTriggerDAO.setcDate(appUtils.getCurrentTimeStamp());
        processAiTriggerDAO.setStatus(1);

        processTriggerDetails.setProcessAiTrigger(processAiTriggerDAO);
        return processTriggerDetails;
    }

    public ProcessTriggerWSDTO updateAITriggerService(long userId, String triggerId, String accountId, String trigger) {
        return null;
    }



    public ProcessTriggerWSDTO createEmailTriggerService(long userId, String processId, String accountId, String trigger, String emailSubject, String emailTitle, String emailBody, String emailSender, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            ProcessTriggerDBModel processTriggerDBModel = new ProcessTriggerDBModel();
            processTriggerDBModel.setProcessId(processId);
            processTriggerDBModel.setTrigger(trigger);
            processTriggerDBModel.setTriggerDetails(createEmailTrigger(accountId,emailSubject,emailTitle,emailBody,emailSender));
            processTriggerDBModel.setTriggerTypeId(typeId);
            processTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            processTriggerDBModel.setBaseType(triggerTypeDBModel.get().getBaseType());
            processTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processTriggerDBModel.setStatus(1);

            return new ProcessTriggerWSDTO(processTriggerRepository.save(processTriggerDBModel));
        }
        return null;
    }

    public ProcessTriggerDetails createEmailTrigger(String accountId, String emailSubject, String emailTitle, String emailBody, String emailSender) {

        ProcessTriggerDetails processTriggerDetails = new ProcessTriggerDetails();
        ProcessEmailTriggerDAO processEmailTriggerDAO = new ProcessEmailTriggerDAO();
        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        if (emailAccountDBModel.isPresent()){
            processEmailTriggerDAO.setAccountId(accountId);
            processEmailTriggerDAO.setAccount(emailAccountDBModel.get().getAccount());
        }
        processEmailTriggerDAO.setEmailSubject(emailSubject);
        processEmailTriggerDAO.setEmailTitle(emailTitle);
        processEmailTriggerDAO.setEmailBody(emailBody);
        processEmailTriggerDAO.setEmailSender(emailSender);
        processEmailTriggerDAO.setTriggerDatas(new ArrayList<>());
        processEmailTriggerDAO.setcDate(appUtils.getCurrentTimeStamp());
        processEmailTriggerDAO.setStatus(1);

        processTriggerDetails.setProcessEmailTrigger(processEmailTriggerDAO);
        return processTriggerDetails;
    }

    public ProcessTriggerWSDTO updateEmailTriggerService(long userId, String triggerId, String accountId, String trigger, String emailSubject, String emailTitle, String emailBody, String emailSender) {
        return null;
    }



    public ProcessTriggerWSDTO createSipTriggerService(long userId, String processId, String accountId, String trigger, String callerId, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            ProcessTriggerDBModel processTriggerDBModel = new ProcessTriggerDBModel();
            processTriggerDBModel.setProcessId(processId);
            processTriggerDBModel.setTrigger(trigger);
            processTriggerDBModel.setTriggerDetails(createSipTrigger(accountId,callerId));
            processTriggerDBModel.setTriggerTypeId(typeId);
            processTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            processTriggerDBModel.setBaseType(triggerTypeDBModel.get().getBaseType());
            processTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processTriggerDBModel.setStatus(1);

            return new ProcessTriggerWSDTO(processTriggerRepository.save(processTriggerDBModel));
        }
        return null;
    }

    public ProcessTriggerDetails createSipTrigger(String accountId, String callerId) {

        ProcessTriggerDetails processTriggerDetails = new ProcessTriggerDetails();
        ProcessSipTriggerDAO processSipTriggerDAO = new ProcessSipTriggerDAO();
        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (sipAccountDBModel.isPresent()){
            processSipTriggerDAO.setAccountId(accountId);
            processSipTriggerDAO.setAccount(sipAccountDBModel.get().getAccount());
        }
        processSipTriggerDAO.setCallerId(callerId);
        processSipTriggerDAO.setTriggerDatas(new ArrayList<>());
        processSipTriggerDAO.setcDate(appUtils.getCurrentTimeStamp());
        processSipTriggerDAO.setStatus(1);

        processTriggerDetails.setProcessSipTrigger(processSipTriggerDAO);
        return processTriggerDetails;
    }

    public ProcessTriggerWSDTO updateSipTriggerService(long userId, String triggerId, String accountId, String trigger, String callerId) {
        return null;
    }



    public ProcessTriggerWSDTO createSmsTriggerService(long userId, String processId, String accountId, String trigger, String smsTitle, String smsBody, String senderId, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            ProcessTriggerDBModel processTriggerDBModel = new ProcessTriggerDBModel();
            processTriggerDBModel.setProcessId(processId);
            processTriggerDBModel.setTrigger(trigger);
            processTriggerDBModel.setTriggerDetails(createSmsTrigger(accountId,smsTitle,smsBody,senderId));
            processTriggerDBModel.setTriggerTypeId(typeId);
            processTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            processTriggerDBModel.setBaseType(triggerTypeDBModel.get().getBaseType());
            processTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processTriggerDBModel.setStatus(1);

            return new ProcessTriggerWSDTO(processTriggerRepository.save(processTriggerDBModel));
        }
        return null;
    }

    public ProcessTriggerDetails createSmsTrigger(String accountId, String smsTitle, String smsBody, String senderId) {

        ProcessTriggerDetails processTriggerDetails = new ProcessTriggerDetails();
        ProcessSmsTriggerDAO processSmsTriggerDAO = new ProcessSmsTriggerDAO();
        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        if (smsAccountDBModel.isPresent()){
            processSmsTriggerDAO.setAccountId(accountId);
            processSmsTriggerDAO.setAccount(smsAccountDBModel.get().getAccount());
        }
        processSmsTriggerDAO.setSmsTitle(smsTitle);
        processSmsTriggerDAO.setSmsBody(smsBody);
        processSmsTriggerDAO.setSenderId(senderId);
        processSmsTriggerDAO.setTriggerDatas(new ArrayList<>());
        processSmsTriggerDAO.setcDate(appUtils.getCurrentTimeStamp());
        processSmsTriggerDAO.setStatus(1);

        processTriggerDetails.setProcessSmsTrigger(processSmsTriggerDAO);
        return processTriggerDetails;
    }

    public ProcessTriggerWSDTO updateSmsTriggerService(long userId, String triggerId, String accountId, String trigger, String smsTitle, String smsBody, String senderId) {

        return null;
    }



    public ProcessTriggerWSDTO createWappCallTriggerService(long userId, String processId, String accountId, String trigger, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            ProcessTriggerDBModel processTriggerDBModel = new ProcessTriggerDBModel();
            processTriggerDBModel.setProcessId(processId);
            processTriggerDBModel.setTrigger(trigger);
            processTriggerDBModel.setTriggerDetails(createWappCallTrigger(accountId));
            processTriggerDBModel.setTriggerTypeId(typeId);
            processTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            processTriggerDBModel.setBaseType(triggerTypeDBModel.get().getBaseType());
            processTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processTriggerDBModel.setStatus(1);

            return new ProcessTriggerWSDTO(processTriggerRepository.save(processTriggerDBModel));
        }
        return null;
    }

    public ProcessTriggerDetails createWappCallTrigger(String accountId) {

        ProcessTriggerDetails processTriggerDetails = new ProcessTriggerDetails();
        ProcessWappCallTriggerDAO processWappCallTriggerDAO = new ProcessWappCallTriggerDAO();
        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (wappAccountDBModel.isPresent()){
            processWappCallTriggerDAO.setAccountId(accountId);
            processWappCallTriggerDAO.setAccount(wappAccountDBModel.get().getAccount());
        }
        processWappCallTriggerDAO.setTriggerDatas(new ArrayList<>());
        processWappCallTriggerDAO.setcDate(appUtils.getCurrentTimeStamp());
        processWappCallTriggerDAO.setStatus(1);

        processTriggerDetails.setProcessWappCallTrigger(processWappCallTriggerDAO);
        return processTriggerDetails;
    }

    public ProcessTriggerWSDTO updateWappCallTriggerService(long userId, String triggerId, String accountId, String trigger) {
        return null;
    }



    public ProcessTriggerWSDTO createWappMessageTriggerService(long userId, String processId, String accountId, String trigger, String wappTitle, String wappBody, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            ProcessTriggerDBModel processTriggerDBModel = new ProcessTriggerDBModel();
            processTriggerDBModel.setProcessId(processId);
            processTriggerDBModel.setTrigger(trigger);
            processTriggerDBModel.setTriggerDetails(createWappMessageTrigger(accountId,wappTitle,wappBody));
            processTriggerDBModel.setTriggerTypeId(typeId);
            processTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            processTriggerDBModel.setBaseType(triggerTypeDBModel.get().getBaseType());
            processTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processTriggerDBModel.setStatus(1);

            return new ProcessTriggerWSDTO(processTriggerRepository.save(processTriggerDBModel));
        }
        return null;
    }

    public ProcessTriggerDetails createWappMessageTrigger(String accountId, String wappTitle, String wappBody) {

        ProcessTriggerDetails processTriggerDetails = new ProcessTriggerDetails();
        ProcessWappMessageTriggerDAO processWappMessageTriggerDAO = new ProcessWappMessageTriggerDAO();
        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (wappAccountDBModel.isPresent()){
            processWappMessageTriggerDAO.setAccountId(accountId);
            processWappMessageTriggerDAO.setAccount(wappAccountDBModel.get().getAccount());
        }
        processWappMessageTriggerDAO.setWappTitle(wappTitle);
        processWappMessageTriggerDAO.setWappBody(wappBody);
        processWappMessageTriggerDAO.setTriggerDatas(new ArrayList<>());
        processWappMessageTriggerDAO.setcDate(appUtils.getCurrentTimeStamp());
        processWappMessageTriggerDAO.setStatus(1);

        processTriggerDetails.setProcessWappMessageTrigger(processWappMessageTriggerDAO);
        return processTriggerDetails;
    }

    public ProcessTriggerWSDTO updateWappMessageTriggerService(long userId, String triggerId, String accountId, String trigger, String wappTitle, String wappBody) {
        return null;
    }


    public ProcessTriggerWSDTO removeProcessTriggerService(long userId, String triggerId) {

        Optional<ProcessTriggerDBModel> triggerDBModel = processTriggerRepository.findById(triggerId);
        if (triggerDBModel.isPresent()){
            processTriggerRepository.delete(triggerDBModel.get());
            return new ProcessTriggerWSDTO(triggerDBModel.get());
        }
        return null;
    }



}
