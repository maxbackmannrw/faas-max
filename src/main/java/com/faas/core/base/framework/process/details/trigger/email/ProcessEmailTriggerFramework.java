package com.faas.core.base.framework.process.details.trigger.email;

import com.faas.core.base.model.db.channel.account.EmailAccountDBModel;
import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.process.details.trigger.email.dto.ProcessEmailTriggerWSDTO;
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

        Optional<EmailTriggerDBModel> processEmailTriggerDBModel = emailTriggerRepository.findById(triggerId);
        if (processEmailTriggerDBModel.isPresent()){
            return new ProcessEmailTriggerWSDTO(processEmailTriggerDBModel.get());
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

        Optional<EmailTriggerDBModel> processEmailTriggerDBModel = emailTriggerRepository.findById(triggerId);
        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        if (processEmailTriggerDBModel.isPresent() && emailAccountDBModel.isPresent()){

            processEmailTriggerDBModel.get().setTrigger(trigger);
            processEmailTriggerDBModel.get().setAccountId(accountId);
            processEmailTriggerDBModel.get().setAccount(emailAccountDBModel.get().getAccount());
            processEmailTriggerDBModel.get().setEmailSubject(emailSubject);
            processEmailTriggerDBModel.get().setEmailTitle(emailTitle);
            processEmailTriggerDBModel.get().setEmailBody(emailBody);
            processEmailTriggerDBModel.get().setEmailSender(emailSender);
            processEmailTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processEmailTriggerDBModel.get().setStatus(1);

            return new ProcessEmailTriggerWSDTO(emailTriggerRepository.save(processEmailTriggerDBModel.get()));
        }
        return null;
    }

    public ProcessEmailTriggerWSDTO removeProcessEmailTriggerService(long userId, String triggerId) {

        Optional<EmailTriggerDBModel> processEmailTriggerDBModel = emailTriggerRepository.findById(triggerId);
        if (processEmailTriggerDBModel.isPresent()){
            emailTriggerRepository.delete(processEmailTriggerDBModel.get());
            return new ProcessEmailTriggerWSDTO(processEmailTriggerDBModel.get());
        }
        return null;
    }


}
