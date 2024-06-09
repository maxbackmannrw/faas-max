package com.faas.core.base.framework.process.details.trigger.details;

import com.faas.core.base.model.db.channel.account.EmailAccountDBModel;
import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.process.details.trigger.details.dto.ProcessEmailTriggerWSDTO;
import com.faas.core.base.repo.channel.account.EmailAccountRepository;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.process.settings.TriggerTypeRepository;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProcessEmailTriggerFramework {


    @Autowired
    EmailTriggerRepository emailTriggerRepository;

    @Autowired
    EmailAccountRepository emailAccountRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ProcessEmailTriggerWSDTO> getProcessEmailTriggersService(long userId, String processId) {

        List<ProcessEmailTriggerWSDTO> processEmailTriggerWSDTOS = new ArrayList<>();
        List<EmailTriggerDBModel> emailTriggerDBModels = emailTriggerRepository.findByProcessId(processId);
        for (EmailTriggerDBModel emailTriggerDBModel : emailTriggerDBModels) {
            processEmailTriggerWSDTOS.add(new ProcessEmailTriggerWSDTO(emailTriggerDBModel));
        }
        return processEmailTriggerWSDTOS;
    }

    public ProcessEmailTriggerWSDTO getProcessEmailTriggerService(long userId, String triggerId) {

        Optional<EmailTriggerDBModel> emailTriggerDBModel = emailTriggerRepository.findById(triggerId);
        if (emailTriggerDBModel.isPresent()){
            return new ProcessEmailTriggerWSDTO(emailTriggerDBModel.get());
        }
        return null;
    }

    public ProcessEmailTriggerWSDTO createProcessEmailTriggerService(long userId, String processId, String trigger, String accountId, String emailSubject, String emailTitle, String emailBody, String emailSender, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        if (triggerTypeDBModel.isPresent() && emailAccountDBModel.isPresent()){

            EmailTriggerDBModel emailTriggerDBModel = new EmailTriggerDBModel();
            emailTriggerDBModel.setProcessId(processId);
            emailTriggerDBModel.setTrigger(trigger);
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

            return new ProcessEmailTriggerWSDTO(emailTriggerRepository.save(emailTriggerDBModel));
        }
        return null;
    }

    public ProcessEmailTriggerWSDTO updateProcessEmailTriggerService(long userId, String triggerId, String trigger, String accountId, String emailSubject, String emailTitle, String emailBody, String emailSender) {

        Optional<EmailTriggerDBModel> emailTriggerDBModel = emailTriggerRepository.findById(triggerId);
        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        if (emailTriggerDBModel.isPresent() && emailAccountDBModel.isPresent()){

            emailTriggerDBModel.get().setTrigger(trigger);
            emailTriggerDBModel.get().setAccountId(accountId);
            emailTriggerDBModel.get().setAccount(emailAccountDBModel.get().getAccount());
            emailTriggerDBModel.get().setEmailSubject(emailSubject);
            emailTriggerDBModel.get().setEmailTitle(emailTitle);
            emailTriggerDBModel.get().setEmailBody(emailBody);
            emailTriggerDBModel.get().setEmailSender(emailSender);
            emailTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            emailTriggerDBModel.get().setStatus(1);

            return new ProcessEmailTriggerWSDTO(emailTriggerRepository.save(emailTriggerDBModel.get()));
        }
        return null;
    }

    public ProcessEmailTriggerWSDTO removeProcessEmailTriggerService(long userId, String triggerId) {

        Optional<EmailTriggerDBModel> emailTriggerDBModel = emailTriggerRepository.findById(triggerId);
        if (emailTriggerDBModel.isPresent()){
            emailTriggerRepository.delete(emailTriggerDBModel.get());
            return new ProcessEmailTriggerWSDTO(emailTriggerDBModel.get());
        }
        return null;
    }



}
