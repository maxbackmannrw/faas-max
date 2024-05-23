package com.faas.core.base.framework.process.details.trigger.temp.email;

import com.faas.core.base.model.db.channel.account.EmailAccountDBModel;
import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.email.dto.EmailTriggerTempWSDTO;
import com.faas.core.base.repo.channel.account.EmailAccountRepository;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.process.settings.TriggerTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmailTriggerTempFramework {

    @Autowired
    EmailTriggerTempRepository emailTriggerTempRepository;

    @Autowired
    EmailAccountRepository emailAccountRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<EmailTriggerTempWSDTO> getEmailTriggerTempsService(long userId, String processId) {

        List<EmailTriggerTempWSDTO> emailTriggerTempWSDTOS = new ArrayList<>();
        List<EmailTriggerTempDBModel> emailTriggerTempDBModels = emailTriggerTempRepository.findByProcessId(processId);
        for (EmailTriggerTempDBModel emailTriggerTempDBModel : emailTriggerTempDBModels) {
            emailTriggerTempWSDTOS.add(new EmailTriggerTempWSDTO(emailTriggerTempDBModel));
        }
        return emailTriggerTempWSDTOS;
    }

    public EmailTriggerTempWSDTO getEmailTriggerTempService(long userId, String tempId) {

        Optional<EmailTriggerTempDBModel> emailTriggerTempDBModel = emailTriggerTempRepository.findById(tempId);
        if (emailTriggerTempDBModel.isPresent()){
            return new EmailTriggerTempWSDTO(emailTriggerTempDBModel.get());
        }
        return null;
    }

    public EmailTriggerTempWSDTO createEmailTriggerTempService(long userId, String processId, String trigger, String accountId, String emailSubject, String emailTitle, String emailBody, String emailSender, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        if (triggerTypeDBModel.isPresent() && emailAccountDBModel.isPresent()){

            EmailTriggerTempDBModel emailTriggerTempDBModel = new EmailTriggerTempDBModel();
            emailTriggerTempDBModel.setProcessId(processId);
            emailTriggerTempDBModel.setTrigger(trigger);
            emailTriggerTempDBModel.setAccountId(accountId);
            emailTriggerTempDBModel.setAccount(emailAccountDBModel.get().getAccount());
            emailTriggerTempDBModel.setEmailSubject(emailSubject);
            emailTriggerTempDBModel.setEmailTitle(emailTitle);
            emailTriggerTempDBModel.setEmailBody(emailBody);
            emailTriggerTempDBModel.setEmailSender(emailSender);
            emailTriggerTempDBModel.setDatas(new ArrayList<>());
            emailTriggerTempDBModel.setTypeId(typeId);
            emailTriggerTempDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            emailTriggerTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            emailTriggerTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            emailTriggerTempDBModel.setStatus(1);

            return new EmailTriggerTempWSDTO(emailTriggerTempRepository.save(emailTriggerTempDBModel));
        }
        return null;
    }

    public EmailTriggerTempWSDTO updateEmailTriggerTempService(long userId, String tempId, String trigger, String accountId, String emailSubject, String emailTitle, String emailBody, String emailSender) {

        Optional<EmailTriggerTempDBModel> emailTriggerTempDBModel = emailTriggerTempRepository.findById(tempId);
        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        if (emailTriggerTempDBModel.isPresent() && emailAccountDBModel.isPresent()){

            emailTriggerTempDBModel.get().setTrigger(trigger);
            emailTriggerTempDBModel.get().setAccountId(accountId);
            emailTriggerTempDBModel.get().setAccount(emailAccountDBModel.get().getAccount());
            emailTriggerTempDBModel.get().setEmailSubject(emailSubject);
            emailTriggerTempDBModel.get().setEmailTitle(emailTitle);
            emailTriggerTempDBModel.get().setEmailBody(emailBody);
            emailTriggerTempDBModel.get().setEmailSender(emailSender);
            emailTriggerTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            emailTriggerTempDBModel.get().setStatus(1);

            return new EmailTriggerTempWSDTO(emailTriggerTempRepository.save(emailTriggerTempDBModel.get()));
        }
        return null;
    }

    public EmailTriggerTempWSDTO removeEmailTriggerTempService(long userId, String tempId) {

        Optional<EmailTriggerTempDBModel> emailTriggerTempDBModel = emailTriggerTempRepository.findById(tempId);
        if (emailTriggerTempDBModel.isPresent()){
            emailTriggerTempRepository.delete(emailTriggerTempDBModel.get());
            return new EmailTriggerTempWSDTO(emailTriggerTempDBModel.get());
        }
        return null;
    }



}
