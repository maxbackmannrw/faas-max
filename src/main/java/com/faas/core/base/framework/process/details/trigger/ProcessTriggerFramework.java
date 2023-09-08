package com.faas.core.base.framework.process.details.trigger;

import com.faas.core.base.model.db.channel.account.EmailAccountDBModel;
import com.faas.core.base.model.db.channel.account.SipAccountDBModel;
import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.db.process.details.trigger.TriggerDBModel;
import com.faas.core.base.model.db.process.details.trigger.dao.*;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.TriggerWSDTO;
import com.faas.core.base.repo.channel.account.EmailAccountRepository;
import com.faas.core.base.repo.channel.account.SipAccountRepository;
import com.faas.core.base.repo.channel.account.SmsAccountRepository;
import com.faas.core.base.repo.channel.account.WappAccountRepository;
import com.faas.core.base.repo.channel.settings.MessageTypeRepository;
import com.faas.core.base.repo.process.details.trigger.TriggerRepository;
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
    TriggerRepository triggerRepository;

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


    public List<TriggerWSDTO> getProcessTriggersService(long userId, String processId) {

        List<TriggerWSDTO> triggerWSDTOS = new ArrayList<>();
        List<TriggerDBModel> triggerDBModels = triggerRepository.findByProcessId(processId);
        for (TriggerDBModel triggerDBModel : triggerDBModels) {
            triggerWSDTOS.add(new TriggerWSDTO(triggerDBModel));
        }
        return triggerWSDTOS;
    }


    public List<TriggerWSDTO> getProcessTriggersByTypeService(long userId, String processId, String baseType) {

        List<TriggerWSDTO> triggerWSDTOS = new ArrayList<>();
        List<TriggerDBModel> triggerDBModels = triggerRepository.findByProcessIdAndBaseType(processId,baseType);
        for (TriggerDBModel triggerDBModel : triggerDBModels) {
            triggerWSDTOS.add(new TriggerWSDTO(triggerDBModel));
        }
        return triggerWSDTOS;
    }


    public TriggerWSDTO getTriggerService(long userId,String triggerId) {

        Optional<TriggerDBModel> triggerDBModel = triggerRepository.findById(triggerId);
        if (triggerDBModel.isPresent()){
            return new TriggerWSDTO(triggerDBModel.get());
        }
        return null;
    }



    public TriggerWSDTO createAITriggerService(long userId, String processId, String accountId,String trigger, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            TriggerDBModel triggerDBModel = new TriggerDBModel();
            triggerDBModel.setProcessId(processId);
            triggerDBModel.setTrigger(trigger);
            triggerDBModel.setTriggerDetails(createAITrigger(accountId));
            triggerDBModel.setTypeId(typeId);
            triggerDBModel.setType(triggerTypeDBModel.get().getTriggerType());
            triggerDBModel.setBaseType(triggerTypeDBModel.get().getBaseType());
            triggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            triggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            triggerDBModel.setStatus(1);

            return new TriggerWSDTO(triggerRepository.save(triggerDBModel));
        }
        return null;
    }

    public TriggerDetails createAITrigger(String accountId) {

        TriggerDetails triggerDetails = new TriggerDetails();
        AiTriggerDAO aiTriggerDAO = new AiTriggerDAO();
        aiTriggerDAO.setAccountId(accountId);
        aiTriggerDAO.setAccount("account");
        aiTriggerDAO.setTriggerDatas(new ArrayList<>());
        aiTriggerDAO.setcDate(appUtils.getCurrentTimeStamp());
        aiTriggerDAO.setStatus(1);

        triggerDetails.setAiTrigger(aiTriggerDAO);
        return triggerDetails;
    }


    public TriggerWSDTO updateAITriggerService(long userId,String triggerId,String accountId,String trigger) {
        return null;
    }



    public TriggerWSDTO createEmailTriggerService(long userId,String processId,String accountId,String trigger,String emailSubject,String emailTitle,String emailBody,String emailSender,long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            TriggerDBModel triggerDBModel = new TriggerDBModel();
            triggerDBModel.setProcessId(processId);
            triggerDBModel.setTrigger(trigger);
            triggerDBModel.setTriggerDetails(createEmailTrigger(accountId,emailSubject,emailTitle,emailBody,emailSender));
            triggerDBModel.setTypeId(typeId);
            triggerDBModel.setType(triggerTypeDBModel.get().getTriggerType());
            triggerDBModel.setBaseType(triggerTypeDBModel.get().getBaseType());
            triggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            triggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            triggerDBModel.setStatus(1);

            return new TriggerWSDTO(triggerRepository.save(triggerDBModel));
        }
        return null;
    }


    public TriggerDetails createEmailTrigger(String accountId,String emailSubject,String emailTitle,String emailBody,String emailSender) {

        TriggerDetails triggerDetails = new TriggerDetails();
        EmailTriggerDAO emailTriggerDAO = new EmailTriggerDAO();
        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        if (emailAccountDBModel.isPresent()){
            emailTriggerDAO.setAccountId(accountId);
            emailTriggerDAO.setAccount(emailAccountDBModel.get().getAccount());
        }
        emailTriggerDAO.setEmailSubject(emailSubject);
        emailTriggerDAO.setEmailTitle(emailTitle);
        emailTriggerDAO.setEmailBody(emailBody);
        emailTriggerDAO.setEmailSender(emailSender);
        emailTriggerDAO.setTriggerDatas(new ArrayList<>());
        emailTriggerDAO.setcDate(appUtils.getCurrentTimeStamp());
        emailTriggerDAO.setStatus(1);

        triggerDetails.setEmailTrigger(emailTriggerDAO);
        return triggerDetails;
    }


    public TriggerWSDTO updateEmailTriggerService(long userId,String triggerId,String accountId,String trigger,String emailSubject,String emailTitle,String emailBody,String emailSender) {
        return null;
    }



    public TriggerWSDTO createSipTriggerService(long userId,String processId,String accountId,String trigger,String callerId,long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            TriggerDBModel triggerDBModel = new TriggerDBModel();
            triggerDBModel.setProcessId(processId);
            triggerDBModel.setTrigger(trigger);
            triggerDBModel.setTriggerDetails(createSipTrigger(accountId,callerId));
            triggerDBModel.setTypeId(typeId);
            triggerDBModel.setType(triggerTypeDBModel.get().getTriggerType());
            triggerDBModel.setBaseType(triggerTypeDBModel.get().getBaseType());
            triggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            triggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            triggerDBModel.setStatus(1);

            return new TriggerWSDTO(triggerRepository.save(triggerDBModel));
        }
        return null;
    }


    public TriggerDetails createSipTrigger(String accountId,String callerId) {

        TriggerDetails triggerDetails = new TriggerDetails();
        SipTriggerDAO sipTriggerDAO = new SipTriggerDAO();
        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (sipAccountDBModel.isPresent()){
            sipTriggerDAO.setAccountId(accountId);
            sipTriggerDAO.setAccount(sipAccountDBModel.get().getAccount());
        }
        sipTriggerDAO.setCallerId(callerId);
        sipTriggerDAO.setTriggerDatas(new ArrayList<>());
        sipTriggerDAO.setcDate(appUtils.getCurrentTimeStamp());
        sipTriggerDAO.setStatus(1);

        triggerDetails.setSipTrigger(sipTriggerDAO);
        return triggerDetails;
    }

    public TriggerWSDTO updateSipTriggerService(long userId,String triggerId,String accountId,String trigger,String callerId) {
        return null;
    }



    public TriggerWSDTO createSmsTriggerService(long userId,String processId,String accountId,String trigger,String smsTitle,String smsBody,String senderId,long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            TriggerDBModel triggerDBModel = new TriggerDBModel();
            triggerDBModel.setProcessId(processId);
            triggerDBModel.setTrigger(trigger);
            triggerDBModel.setTriggerDetails(createSmsTrigger(accountId,smsTitle,smsBody,senderId));
            triggerDBModel.setTypeId(typeId);
            triggerDBModel.setType(triggerTypeDBModel.get().getTriggerType());
            triggerDBModel.setBaseType(triggerTypeDBModel.get().getBaseType());
            triggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            triggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            triggerDBModel.setStatus(1);

            return new TriggerWSDTO(triggerRepository.save(triggerDBModel));
        }
        return null;
    }

    public TriggerDetails createSmsTrigger(String accountId,String smsTitle,String smsBody,String senderId) {

        TriggerDetails triggerDetails = new TriggerDetails();
        SmsTriggerDAO smsTriggerDAO = new SmsTriggerDAO();
        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        if (smsAccountDBModel.isPresent()){
            smsTriggerDAO.setAccountId(accountId);
            smsTriggerDAO.setAccount(smsAccountDBModel.get().getAccount());
        }
        smsTriggerDAO.setSmsTitle(smsTitle);
        smsTriggerDAO.setSmsBody(smsBody);
        smsTriggerDAO.setSenderId(senderId);
        smsTriggerDAO.setTriggerDatas(new ArrayList<>());
        smsTriggerDAO.setcDate(appUtils.getCurrentTimeStamp());
        smsTriggerDAO.setStatus(1);

        triggerDetails.setSmsTrigger(smsTriggerDAO);
        return triggerDetails;
    }

    public TriggerWSDTO updateSmsTriggerService(long userId,String triggerId,String accountId,String trigger,String smsTitle,String smsBody,String senderId) {

        return null;
    }



    public TriggerWSDTO createWappCallTriggerService(long userId,String processId,String accountId,String trigger,long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            TriggerDBModel triggerDBModel = new TriggerDBModel();
            triggerDBModel.setProcessId(processId);
            triggerDBModel.setTrigger(trigger);
            triggerDBModel.setTriggerDetails(createWappCallTrigger(accountId));
            triggerDBModel.setTypeId(typeId);
            triggerDBModel.setType(triggerTypeDBModel.get().getTriggerType());
            triggerDBModel.setBaseType(triggerTypeDBModel.get().getBaseType());
            triggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            triggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            triggerDBModel.setStatus(1);

            return new TriggerWSDTO(triggerRepository.save(triggerDBModel));
        }
        return null;
    }


    public TriggerDetails createWappCallTrigger(String accountId) {

        TriggerDetails triggerDetails = new TriggerDetails();
        WappCallTriggerDAO wappCallTriggerDAO = new WappCallTriggerDAO();
        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (wappAccountDBModel.isPresent()){
            wappCallTriggerDAO.setAccountId(accountId);
            wappCallTriggerDAO.setAccount(wappAccountDBModel.get().getAccount());
        }
        wappCallTriggerDAO.setTriggerDatas(new ArrayList<>());
        wappCallTriggerDAO.setcDate(appUtils.getCurrentTimeStamp());
        wappCallTriggerDAO.setStatus(1);

        triggerDetails.setWappCallTrigger(wappCallTriggerDAO);
        return triggerDetails;
    }


    public TriggerWSDTO updateWappCallTriggerService(long userId,String triggerId,String accountId,String trigger) {
        return null;
    }




    public TriggerWSDTO createWappMessageTriggerService(long userId,String processId,String accountId,String trigger,String wappTitle,String wappBody,long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            TriggerDBModel triggerDBModel = new TriggerDBModel();
            triggerDBModel.setProcessId(processId);
            triggerDBModel.setTrigger(trigger);
            triggerDBModel.setTriggerDetails(createWappMessageTrigger(accountId,wappTitle,wappBody));
            triggerDBModel.setTypeId(typeId);
            triggerDBModel.setType(triggerTypeDBModel.get().getTriggerType());
            triggerDBModel.setBaseType(triggerTypeDBModel.get().getBaseType());
            triggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            triggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            triggerDBModel.setStatus(1);

            return new TriggerWSDTO(triggerRepository.save(triggerDBModel));
        }
        return null;
    }

    public TriggerDetails createWappMessageTrigger(String accountId, String wappTitle, String wappBody) {

        TriggerDetails triggerDetails = new TriggerDetails();
        WappMessageTriggerDAO wappMessageTriggerDAO = new WappMessageTriggerDAO();
        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (wappAccountDBModel.isPresent()){
            wappMessageTriggerDAO.setAccountId(accountId);
            wappMessageTriggerDAO.setAccount(wappAccountDBModel.get().getAccount());
        }
        wappMessageTriggerDAO.setWappTitle(wappTitle);
        wappMessageTriggerDAO.setWappBody(wappBody);
        wappMessageTriggerDAO.setTriggerDatas(new ArrayList<>());
        wappMessageTriggerDAO.setcDate(appUtils.getCurrentTimeStamp());
        wappMessageTriggerDAO.setStatus(1);

        triggerDetails.setWappMessageTrigger(wappMessageTriggerDAO);
        return triggerDetails;
    }

    public TriggerWSDTO updateWappMessageTriggerService(long userId,String triggerId,String accountId,String trigger,String wappTitle,String wappBody) {

        return null;
    }



    public TriggerWSDTO removeTriggerService(long userId, String triggerId) {

        Optional<TriggerDBModel> triggerDBModel = triggerRepository.findById(triggerId);
        if (triggerDBModel.isPresent()){
            triggerRepository.delete(triggerDBModel.get());
            return new TriggerWSDTO(triggerDBModel.get());
        }
        return null;
    }



}
