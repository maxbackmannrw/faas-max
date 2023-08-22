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

        List<TriggerWSDTO>triggerWSDTOS = new ArrayList<>();
        List<TriggerDBModel> triggerDBModels = triggerRepository.findByProcessId(processId);
        for (TriggerDBModel triggerDBModel : triggerDBModels) {
            triggerWSDTOS.add(new TriggerWSDTO(triggerDBModel));
        }
        return triggerWSDTOS;
    }


    public List<TriggerWSDTO> getProcessTriggersByTypeService(long userId, String processId,String baseType) {

        List<TriggerWSDTO>triggerWSDTOS = new ArrayList<>();
        List<TriggerDBModel> triggerDBModels = triggerRepository.findByProcessIdAndBaseType(processId,baseType);
        for (TriggerDBModel triggerDBModel : triggerDBModels) {
            triggerWSDTOS.add(new TriggerWSDTO(triggerDBModel));
        }
        return triggerWSDTOS;
    }


    public TriggerWSDTO getProcessTriggerService(long userId, String processId,String triggerId) {

        List<TriggerDBModel> triggerDBModels = triggerRepository.findByIdAndProcessId(triggerId,processId);
        if (triggerDBModels.size()>0){
            return new TriggerWSDTO(triggerDBModels.get(0));
        }
        return null;
    }



    public TriggerWSDTO createAITriggerService(long userId,String processId,String accountId,long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            TriggerDBModel triggerDBModel = new TriggerDBModel();
            triggerDBModel.setProcessId(processId);
            triggerDBModel.setTrigger(createAITrigger(accountId));
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

    public TriggerDAO createAITrigger(String accountId) {

        TriggerDAO triggerDAO = new TriggerDAO();

        AITrigger aiTrigger = new AITrigger();
        aiTrigger.setId(appUtils.generateUUID());
        aiTrigger.setAccountId(accountId);
        aiTrigger.setAiAccount("");
        aiTrigger.setDatas(new ArrayList<>());
        aiTrigger.setuDate(appUtils.getCurrentTimeStamp());
        aiTrigger.setcDate(appUtils.getCurrentTimeStamp());
        aiTrigger.setStatus(1);

        triggerDAO.setAiTrigger(aiTrigger);
        return triggerDAO;
    }


    public TriggerWSDTO updateAITriggerService(long userId,String processId,String triggerId,String accountId,long typeId) {

        return null;
    }




    public TriggerWSDTO createEmailTriggerService(long userId,String processId,String accountId,String emailSubject,String emailTitle,String emailBody,String emailSender,long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            TriggerDBModel triggerDBModel = new TriggerDBModel();
            triggerDBModel.setProcessId(processId);
            triggerDBModel.setTrigger(createEmailTrigger(accountId,emailSubject,emailTitle,emailBody,emailSender));
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

    public TriggerDAO createEmailTrigger(String accountId,String emailSubject,String emailTitle,String emailBody,String emailSender) {

        TriggerDAO triggerDAO = new TriggerDAO();

        EmailTrigger emailTrigger = new EmailTrigger();
        emailTrigger.setId(appUtils.generateUUID());
        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        if (emailAccountDBModel.isPresent()){
            emailTrigger.setAccountId(accountId);
            emailTrigger.setEmailAccount(emailAccountDBModel.get().getAccount());
        }

        emailTrigger.setEmailSubject(emailSubject);
        emailTrigger.setEmailTitle(emailTitle);
        emailTrigger.setEmailBody(emailBody);
        emailTrigger.setEmailSender(emailSender);
        emailTrigger.setDatas(new ArrayList<>());
        emailTrigger.setuDate(appUtils.getCurrentTimeStamp());
        emailTrigger.setcDate(appUtils.getCurrentTimeStamp());
        emailTrigger.setStatus(1);

        triggerDAO.setEmailTrigger(emailTrigger);
        return triggerDAO;
    }


    public TriggerWSDTO updateEmailTriggerService(long userId,String processId,String triggerId,String accountId,String emailSubject,String emailTitle,String emailBody,String emailSender,long typeId) {

        return null;
    }




    public TriggerWSDTO createSipTriggerService(long userId,String processId,String accountId,String callerId,long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            TriggerDBModel triggerDBModel = new TriggerDBModel();
            triggerDBModel.setProcessId(processId);
            triggerDBModel.setTrigger(createSipTrigger(accountId,callerId));
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

    public TriggerDAO createSipTrigger(String accountId,String callerId) {

        TriggerDAO triggerDAO = new TriggerDAO();

        SipTrigger sipTrigger = new SipTrigger();
        sipTrigger.setId(appUtils.generateUUID());
        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (sipAccountDBModel.isPresent()){
            sipTrigger.setAccountId(accountId);
            sipTrigger.setSipAccount(sipAccountDBModel.get().getAccount());
        }
        sipTrigger.setCallerId(accountId);
        sipTrigger.setDatas(new ArrayList<>());
        sipTrigger.setuDate(appUtils.getCurrentTimeStamp());
        sipTrigger.setcDate(appUtils.getCurrentTimeStamp());
        sipTrigger.setStatus(1);

        triggerDAO.setSipTrigger(sipTrigger);
        return triggerDAO;
    }

    public TriggerWSDTO updateSipTriggerService(long userId,String processId,String triggerId,String accountId,String callerId,long typeId) {

        return null;
    }



    public TriggerWSDTO createSmsTriggerService(long userId,String processId,String accountId,String smsTitle,String smsBody,String senderId,long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            TriggerDBModel triggerDBModel = new TriggerDBModel();
            triggerDBModel.setProcessId(processId);
            triggerDBModel.setTrigger(createSmsTrigger(accountId,smsTitle,smsBody,senderId));
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

    public TriggerDAO createSmsTrigger(String accountId,String smsTitle,String smsBody,String senderId) {

        TriggerDAO triggerDAO = new TriggerDAO();

        SmsTrigger smsTrigger = new SmsTrigger();
        smsTrigger.setId(appUtils.generateUUID());
        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        if (smsAccountDBModel.isPresent()){
            smsTrigger.setAccountId(accountId);
            smsTrigger.setSmsAccount(smsAccountDBModel.get().getAccount());
        }
        smsTrigger.setSmsTitle(smsTitle);
        smsTrigger.setSmsBody(smsBody);
        smsTrigger.setSenderId(senderId);
        smsTrigger.setDatas(new ArrayList<>());
        smsTrigger.setuDate(appUtils.getCurrentTimeStamp());
        smsTrigger.setcDate(appUtils.getCurrentTimeStamp());
        smsTrigger.setStatus(1);

        triggerDAO.setSmsTrigger(smsTrigger);
        return triggerDAO;
    }

    public TriggerWSDTO updateSmsTriggerService(long userId,String processId,String triggerId,String accountId,String smsTitle,String smsBody,String senderId,long typeId) {

        return null;
    }



    public TriggerWSDTO createWappTriggerService(long userId, String processId,String accountId,String wappTitle,String wappBody,long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            TriggerDBModel triggerDBModel = new TriggerDBModel();
            triggerDBModel.setProcessId(processId);
            triggerDBModel.setTrigger(createWappTrigger(accountId,wappTitle,wappBody));
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

    public TriggerDAO createWappTrigger(String accountId,String wappTitle,String wappBody) {

        TriggerDAO triggerDAO = new TriggerDAO();

        WappTrigger wappTrigger = new WappTrigger();
        wappTrigger.setId(appUtils.generateUUID());
        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (wappAccountDBModel.isPresent()){
            wappTrigger.setAccountId(accountId);
            wappTrigger.setWappAccount(wappAccountDBModel.get().getAccount());
        }
        wappTrigger.setWappTitle(wappTitle);
        wappTrigger.setWappBody(wappBody);
        wappTrigger.setDatas(new ArrayList<>());
        wappTrigger.setuDate(appUtils.getCurrentTimeStamp());
        wappTrigger.setcDate(appUtils.getCurrentTimeStamp());
        wappTrigger.setStatus(1);

        triggerDAO.setWappTrigger(wappTrigger);
        return triggerDAO;
    }

    public TriggerWSDTO updateWappTriggerService(long userId,String processId,String triggerId,String accountId,String wappTitle,String wappBody,long typeId) {

        return null;
    }



    public TriggerWSDTO removeTriggerService(long userId,String processId,String triggerId) {

        List<TriggerDBModel> triggerDBModels = triggerRepository.findByIdAndProcessId(triggerId,processId);
        if (triggerDBModels.size()>0){
            triggerRepository.deleteAll(triggerDBModels);
            return new TriggerWSDTO(triggerDBModels.get(0));
        }
        return null;
    }



}
