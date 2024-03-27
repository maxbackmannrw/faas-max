package com.faas.core.base.framework.process.details.channel.trigger;

import com.faas.core.base.model.db.channel.account.EmailAccountDBModel;
import com.faas.core.base.model.db.channel.account.SipAccountDBModel;
import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.db.process.details.channel.trigger.*;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.process.details.channel.trigger.dto.*;
import com.faas.core.base.repo.channel.account.EmailAccountRepository;
import com.faas.core.base.repo.channel.account.SipAccountRepository;
import com.faas.core.base.repo.channel.account.SmsAccountRepository;
import com.faas.core.base.repo.channel.account.WappAccountRepository;
import com.faas.core.base.repo.channel.settings.MessageTypeRepository;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.process.settings.TriggerTypeRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProcessChannelTriggerFramework {

    @Autowired
    ProcessAITriggerRepository processAITriggerRepository;

    @Autowired
    ProcessEmailTriggerRepository processEmailTriggerRepository;

    @Autowired
    ProcessSipTriggerRepository processSipTriggerRepository;

    @Autowired
    ProcessSmsTriggerRepository processSmsTriggerRepository;

    @Autowired
    ProcessWappCallTriggerRepository processWappCallTriggerRepository;

    @Autowired
    ProcessWappMessageTriggerRepository processWappMessageTriggerRepository;

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


    public ProcessTriggerWSDTO getProcessTriggerService(long userId, String processId) {

        ProcessTriggerWSDTO processTriggerWSDTO = new ProcessTriggerWSDTO();
        processTriggerWSDTO.setProcessAITriggers(getProcessAITriggersService(userId,processId));
        processTriggerWSDTO.setProcessEmailTriggers(getProcessEmailTriggersService(userId,processId));
        processTriggerWSDTO.setProcessSipTriggers(getProcessSipTriggersService(userId,processId));
        processTriggerWSDTO.setProcessSmsTriggers(getProcessSmsTriggersService(userId,processId));
        processTriggerWSDTO.setProcessWappCallTriggers(getProcessWappCallTriggersService(userId,processId));
        processTriggerWSDTO.setProcessWappMessageTriggers(getProcessWappMessageTriggersService(userId,processId));

        return processTriggerWSDTO;
    }


    public List<ProcessAITriggerWSDTO> getProcessAITriggersService(long userId, String processId) {

        List<ProcessAITriggerWSDTO> processAITriggerWSDTOS = new ArrayList<>();
        List<ProcessAITriggerDBModel> processAITriggerDBModels = processAITriggerRepository.findByProcessId(processId);
        for (ProcessAITriggerDBModel processAiTriggerDBModel : processAITriggerDBModels) {
            processAITriggerWSDTOS.add(new ProcessAITriggerWSDTO(processAiTriggerDBModel));
        }
        return processAITriggerWSDTOS;
    }

    public ProcessAITriggerWSDTO getProcessAITriggerService(long userId, String triggerId) {

        Optional<ProcessAITriggerDBModel> processAITriggerDBModel = processAITriggerRepository.findById(triggerId);
        if (processAITriggerDBModel.isPresent()){
            return new ProcessAITriggerWSDTO(processAITriggerDBModel.get());
        }
        return null;
    }

    public ProcessAITriggerWSDTO createProcessAITriggerService(long userId, String processId, String trigger, String triggerDesc, String accountId, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            ProcessAITriggerDBModel processAiTriggerDBModel = new ProcessAITriggerDBModel();
            processAiTriggerDBModel.setProcessId(processId);
            processAiTriggerDBModel.setTrigger(trigger);
            processAiTriggerDBModel.setTriggerDesc(triggerDesc);
            processAiTriggerDBModel.setAccountId(accountId);
            processAiTriggerDBModel.setAccount(AppConstant.NONE);
            processAiTriggerDBModel.setDatas(new ArrayList<>());
            processAiTriggerDBModel.setTypeId(typeId);
            processAiTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            processAiTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processAiTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processAiTriggerDBModel.setStatus(1);

            return new ProcessAITriggerWSDTO(processAITriggerRepository.save(processAiTriggerDBModel));
        }
        return null;
    }

    public ProcessAITriggerWSDTO updateProcessAITriggerService(long userId, String triggerId, String trigger, String triggerDesc, String accountId) {

        Optional<ProcessAITriggerDBModel> processAITriggerDBModel = processAITriggerRepository.findById(triggerId);
        if (processAITriggerDBModel.isPresent()){

            processAITriggerDBModel.get().setTrigger(trigger);
            processAITriggerDBModel.get().setTriggerDesc(triggerDesc);
            processAITriggerDBModel.get().setAccountId(accountId);
            processAITriggerDBModel.get().setAccount("");
            processAITriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());

            return new ProcessAITriggerWSDTO(processAITriggerRepository.save(processAITriggerDBModel.get()));
        }
        return null;
    }

    public ProcessAITriggerWSDTO removeProcessAITriggerService(long userId, String triggerId) {

        Optional<ProcessAITriggerDBModel> processAITriggerDBModel = processAITriggerRepository.findById(triggerId);
        if (processAITriggerDBModel.isPresent()){
            processAITriggerRepository.delete(processAITriggerDBModel.get());
            return new ProcessAITriggerWSDTO(processAITriggerDBModel.get());
        }
        return null;
    }


    public List<ProcessEmailTriggerWSDTO> getProcessEmailTriggersService(long userId, String processId) {

        List<ProcessEmailTriggerWSDTO> processEmailTriggerWSDTOS = new ArrayList<>();
        List<ProcessEmailTriggerDBModel> processEmailTriggerDBModels = processEmailTriggerRepository.findByProcessId(processId);
        for (ProcessEmailTriggerDBModel processEmailTriggerDBModel : processEmailTriggerDBModels) {
            processEmailTriggerWSDTOS.add(new ProcessEmailTriggerWSDTO(processEmailTriggerDBModel));
        }
        return processEmailTriggerWSDTOS;
    }

    public ProcessEmailTriggerWSDTO getProcessEmailTriggerService(long userId, String triggerId) {

        Optional<ProcessEmailTriggerDBModel> processEmailTriggerDBModel = processEmailTriggerRepository.findById(triggerId);
        if (processEmailTriggerDBModel.isPresent()){
            return new ProcessEmailTriggerWSDTO(processEmailTriggerDBModel.get());
        }
        return null;
    }

    public ProcessEmailTriggerWSDTO createProcessEmailTriggerService(long userId, String processId, String trigger, String triggerDesc, String accountId, String emailSubject, String emailTitle, String emailBody, String emailSender, long typeId) {

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

            return new ProcessEmailTriggerWSDTO(processEmailTriggerRepository.save(processEmailTriggerDBModel));
        }
        return null;
    }

    public ProcessEmailTriggerWSDTO updateProcessEmailTriggerService(long userId, String triggerId, String trigger, String triggerDesc, String accountId, String emailSubject, String emailTitle, String emailBody, String emailSender) {

        Optional<ProcessEmailTriggerDBModel> processEmailTriggerDBModel = processEmailTriggerRepository.findById(triggerId);
        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        if (processEmailTriggerDBModel.isPresent() && emailAccountDBModel.isPresent()){

            processEmailTriggerDBModel.get().setTrigger(trigger);
            processEmailTriggerDBModel.get().setTriggerDesc(triggerDesc);
            processEmailTriggerDBModel.get().setAccountId(accountId);
            processEmailTriggerDBModel.get().setAccount(emailAccountDBModel.get().getAccount());
            processEmailTriggerDBModel.get().setEmailSubject(emailSubject);
            processEmailTriggerDBModel.get().setEmailTitle(emailTitle);
            processEmailTriggerDBModel.get().setEmailBody(emailBody);
            processEmailTriggerDBModel.get().setEmailSender(emailSender);
            processEmailTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processEmailTriggerDBModel.get().setStatus(1);

            return new ProcessEmailTriggerWSDTO(processEmailTriggerRepository.save(processEmailTriggerDBModel.get()));
        }
        return null;
    }

    public ProcessEmailTriggerWSDTO removeProcessEmailTriggerService(long userId, String triggerId) {

        Optional<ProcessEmailTriggerDBModel> processEmailTriggerDBModel = processEmailTriggerRepository.findById(triggerId);
        if (processEmailTriggerDBModel.isPresent()){
            processEmailTriggerRepository.delete(processEmailTriggerDBModel.get());
            return new ProcessEmailTriggerWSDTO(processEmailTriggerDBModel.get());
        }
        return null;
    }


    public List<ProcessSipTriggerWSDTO> getProcessSipTriggersService(long userId, String processId) {

        List<ProcessSipTriggerWSDTO> processSipTriggerWSDTOS = new ArrayList<>();
        List<ProcessSipTriggerDBModel> processSipTriggerDBModels = processSipTriggerRepository.findByProcessId(processId);
        for (ProcessSipTriggerDBModel processSipTriggerDBModel : processSipTriggerDBModels) {
            processSipTriggerWSDTOS.add(new ProcessSipTriggerWSDTO(processSipTriggerDBModel));
        }
        return processSipTriggerWSDTOS;
    }


    public ProcessSipTriggerWSDTO getProcessSipTriggerService(long userId, String triggerId) {

        Optional<ProcessSipTriggerDBModel> processSipTriggerDBModel = processSipTriggerRepository.findById(triggerId);
        if (processSipTriggerDBModel.isPresent()){
            return new ProcessSipTriggerWSDTO(processSipTriggerDBModel.get());
        }
        return null;
    }

    public ProcessSipTriggerWSDTO createProcessSipTriggerService(long userId, String processId, String trigger, String triggerDesc, String accountId, String callerId, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (triggerTypeDBModel.isPresent() && sipAccountDBModel.isPresent()){

            ProcessSipTriggerDBModel processSipTriggerDBModel = new ProcessSipTriggerDBModel();
            processSipTriggerDBModel.setProcessId(processId);
            processSipTriggerDBModel.setTrigger(trigger);
            processSipTriggerDBModel.setTriggerDesc(triggerDesc);
            processSipTriggerDBModel.setAccountId(accountId);
            processSipTriggerDBModel.setAccount(sipAccountDBModel.get().getAccount());
            processSipTriggerDBModel.setCallerId(callerId);
            processSipTriggerDBModel.setTypeId(typeId);
            processSipTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            processSipTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processSipTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processSipTriggerDBModel.setStatus(1);

            return new ProcessSipTriggerWSDTO(processSipTriggerRepository.save(processSipTriggerDBModel));
        }
        return null;
    }

    public ProcessSipTriggerWSDTO updateProcessSipTriggerService(long userId, String triggerId, String trigger, String triggerDesc, String accountId, String callerId) {

        Optional<ProcessSipTriggerDBModel> processSipTriggerDBModel = processSipTriggerRepository.findById(triggerId);
        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (processSipTriggerDBModel.isPresent() && sipAccountDBModel.isPresent()){

            processSipTriggerDBModel.get().setTrigger(trigger);
            processSipTriggerDBModel.get().setTriggerDesc(triggerDesc);
            processSipTriggerDBModel.get().setAccountId(accountId);
            processSipTriggerDBModel.get().setAccount(sipAccountDBModel.get().getAccount());
            processSipTriggerDBModel.get().setCallerId(callerId);
            processSipTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processSipTriggerDBModel.get().setStatus(1);

            return new ProcessSipTriggerWSDTO(processSipTriggerRepository.save(processSipTriggerDBModel.get()));
        }
        return null;
    }

    public ProcessSipTriggerWSDTO removeProcessSipTriggerService(long userId, String triggerId) {

        Optional<ProcessSipTriggerDBModel> processSipTriggerDBModel = processSipTriggerRepository.findById(triggerId);
        if (processSipTriggerDBModel.isPresent()){
            processSipTriggerRepository.delete(processSipTriggerDBModel.get());
            return new ProcessSipTriggerWSDTO(processSipTriggerDBModel.get());
        }
        return null;
    }



    public List<ProcessSmsTriggerWSDTO> getProcessSmsTriggersService(long userId, String processId) {

        List<ProcessSmsTriggerWSDTO> processSmsTriggerWSDTOS = new ArrayList<>();
        List<ProcessSmsTriggerDBModel> processSmsTriggerDBModels = processSmsTriggerRepository.findByProcessId(processId);
        for (ProcessSmsTriggerDBModel processSmsTriggerDBModel : processSmsTriggerDBModels) {
            processSmsTriggerWSDTOS.add(new ProcessSmsTriggerWSDTO(processSmsTriggerDBModel));
        }
        return processSmsTriggerWSDTOS;
    }

    public ProcessSmsTriggerWSDTO getProcessSmsTriggerService(long userId, String triggerId) {

        Optional<ProcessSmsTriggerDBModel> processSmsTriggerDBModel = processSmsTriggerRepository.findById(triggerId);
        if (processSmsTriggerDBModel.isPresent()){
            return new ProcessSmsTriggerWSDTO(processSmsTriggerDBModel.get());
        }
        return null;
    }


    public ProcessSmsTriggerWSDTO createProcessSmsTriggerService(long userId, String processId, String trigger, String triggerDesc, String accountId, String smsTitle, String smsBody, String senderId, long typeId) {

        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (smsAccountDBModel.isPresent() && triggerTypeDBModel.isPresent()){

            ProcessSmsTriggerDBModel processSmsTriggerDBModel = new ProcessSmsTriggerDBModel();
            processSmsTriggerDBModel.setProcessId(processId);
            processSmsTriggerDBModel.setTrigger(trigger);
            processSmsTriggerDBModel.setTriggerDesc(triggerDesc);
            processSmsTriggerDBModel.setAccountId(accountId);
            processSmsTriggerDBModel.setAccount(smsAccountDBModel.get().getAccount());
            processSmsTriggerDBModel.setSmsTitle(smsTitle);
            processSmsTriggerDBModel.setSmsBody(smsBody);
            processSmsTriggerDBModel.setSenderId(senderId);
            processSmsTriggerDBModel.setDatas(new ArrayList<>());
            processSmsTriggerDBModel.setTypeId(typeId);
            processSmsTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            processSmsTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processSmsTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processSmsTriggerDBModel.setStatus(1);

            return new ProcessSmsTriggerWSDTO(processSmsTriggerRepository.save(processSmsTriggerDBModel));
        }
        return null;
    }


    public ProcessSmsTriggerWSDTO updateProcessSmsTriggerService(long userId, String triggerId, String trigger, String triggerDesc, String accountId, String smsTitle, String smsBody, String senderId) {

        Optional<ProcessSmsTriggerDBModel> processSmsTriggerDBModel = processSmsTriggerRepository.findById(triggerId);
        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        if (processSmsTriggerDBModel.isPresent() && smsAccountDBModel.isPresent()){

            processSmsTriggerDBModel.get().setTrigger(trigger);
            processSmsTriggerDBModel.get().setTriggerDesc(triggerDesc);
            processSmsTriggerDBModel.get().setAccountId(accountId);
            processSmsTriggerDBModel.get().setAccount(smsAccountDBModel.get().getAccount());
            processSmsTriggerDBModel.get().setSmsTitle(smsTitle);
            processSmsTriggerDBModel.get().setSmsBody(smsBody);
            processSmsTriggerDBModel.get().setSenderId(senderId);
            processSmsTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processSmsTriggerDBModel.get().setStatus(1);

            return new ProcessSmsTriggerWSDTO(processSmsTriggerRepository.save(processSmsTriggerDBModel.get()));
        }
        return null;
    }

    public ProcessSmsTriggerWSDTO removeProcessSmsTriggerService(long userId, String triggerId) {

        Optional<ProcessSmsTriggerDBModel> processSmsTriggerDBModel = processSmsTriggerRepository.findById(triggerId);
        if (processSmsTriggerDBModel.isPresent()){
            processSmsTriggerRepository.delete(processSmsTriggerDBModel.get());
            return new ProcessSmsTriggerWSDTO(processSmsTriggerDBModel.get());
        }
        return null;
    }



    public List<ProcessWappCallTriggerWSDTO> getProcessWappCallTriggersService(long userId, String processId) {

        List<ProcessWappCallTriggerWSDTO> processWappCallTriggerWSDTOS = new ArrayList<>();
        List<ProcessWappCallTriggerDBModel> processWappCallTriggerDBModels = processWappCallTriggerRepository.findByProcessId(processId);
        for (ProcessWappCallTriggerDBModel processWappCallTriggerDBModel : processWappCallTriggerDBModels) {
            processWappCallTriggerWSDTOS.add(new ProcessWappCallTriggerWSDTO(processWappCallTriggerDBModel));
        }
        return processWappCallTriggerWSDTOS;
    }

    public ProcessWappCallTriggerWSDTO getProcessWappCallTriggerService(long userId, String triggerId) {

        Optional<ProcessWappCallTriggerDBModel> processWappCallTriggerDBModel = processWappCallTriggerRepository.findById(triggerId);
        if (processWappCallTriggerDBModel.isPresent()){
            return new ProcessWappCallTriggerWSDTO(processWappCallTriggerDBModel.get());
        }
        return null;
    }

    public ProcessWappCallTriggerWSDTO createProcessWappCallTriggerService(long userId, String processId, String trigger, String triggerDesc, String accountId, long typeId) {

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

            return new ProcessWappCallTriggerWSDTO(processWappCallTriggerRepository.save(processWappCallTriggerDBModel));
        }
        return null;
    }

    public ProcessWappCallTriggerWSDTO updateProcessWappCallTriggerService(long userId, String triggerId, String trigger, String triggerDesc, String accountId) {

        Optional<ProcessWappCallTriggerDBModel> processWappCallTriggerDBModel = processWappCallTriggerRepository.findById(triggerId);
        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (processWappCallTriggerDBModel.isPresent() && wappAccountDBModel.isPresent()){

            processWappCallTriggerDBModel.get().setTrigger(trigger);
            processWappCallTriggerDBModel.get().setTriggerDesc(triggerDesc);
            processWappCallTriggerDBModel.get().setAccountId(accountId);
            processWappCallTriggerDBModel.get().setAccount(wappAccountDBModel.get().getAccount());
            processWappCallTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processWappCallTriggerDBModel.get().setStatus(1);

            return new ProcessWappCallTriggerWSDTO(processWappCallTriggerRepository.save(processWappCallTriggerDBModel.get()));
        }
        return null;
    }

    public ProcessWappCallTriggerWSDTO removeProcessWappCallTriggerService(long userId, String triggerId) {

        Optional<ProcessWappCallTriggerDBModel> processWappCallTriggerDBModel = processWappCallTriggerRepository.findById(triggerId);
        if (processWappCallTriggerDBModel.isPresent()){
            processWappCallTriggerRepository.delete(processWappCallTriggerDBModel.get());
            return new ProcessWappCallTriggerWSDTO(processWappCallTriggerDBModel.get());
        }
        return null;
    }


    public List<ProcessWappMessageTriggerWSDTO> getProcessWappMessageTriggersService(long userId, String processId) {

        List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggerWSDTOS = new ArrayList<>();
        List<ProcessWappMessageTriggerDBModel> processWappMessageTriggerDBModels = processWappMessageTriggerRepository.findByProcessId(processId);
        for (ProcessWappMessageTriggerDBModel processWappMessageTriggerDBModel : processWappMessageTriggerDBModels) {
            processWappMessageTriggerWSDTOS.add(new ProcessWappMessageTriggerWSDTO(processWappMessageTriggerDBModel));
        }
        return processWappMessageTriggerWSDTOS;
    }

    public ProcessWappMessageTriggerWSDTO getProcessWappMessageTriggerService(long userId, String triggerId) {

        Optional<ProcessWappMessageTriggerDBModel> processWappMessageTriggerDBModel = processWappMessageTriggerRepository.findById(triggerId);
        if (processWappMessageTriggerDBModel.isPresent()){
            return new ProcessWappMessageTriggerWSDTO(processWappMessageTriggerDBModel.get());
        }
        return null;
    }

    public ProcessWappMessageTriggerWSDTO createProcessWappMessageTriggerService(long userId, String processId, String trigger, String triggerDesc, String accountId, String wappTitle, String wappBody, long typeId) {

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

            return new ProcessWappMessageTriggerWSDTO(processWappMessageTriggerRepository.save(processWappMessageTriggerDBModel));
        }
        return null;
    }

    public ProcessWappMessageTriggerWSDTO updateProcessWappMessageTriggerService(long userId, String triggerId, String trigger, String triggerDesc, String accountId, String wappTitle, String wappBody) {

        Optional<ProcessWappMessageTriggerDBModel> processWappMessageTriggerDBModel = processWappMessageTriggerRepository.findById(triggerId);
        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (processWappMessageTriggerDBModel.isPresent() && wappAccountDBModel.isPresent()){

            processWappMessageTriggerDBModel.get().setTrigger(trigger);
            processWappMessageTriggerDBModel.get().setTriggerDesc(triggerDesc);
            processWappMessageTriggerDBModel.get().setAccountId(accountId);
            processWappMessageTriggerDBModel.get().setAccount(wappAccountDBModel.get().getAccount());
            processWappMessageTriggerDBModel.get().setWappTitle(wappTitle);
            processWappMessageTriggerDBModel.get().setWappBody(wappBody);
            processWappMessageTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processWappMessageTriggerDBModel.get().setStatus(1);

            return new ProcessWappMessageTriggerWSDTO(processWappMessageTriggerRepository.save(processWappMessageTriggerDBModel.get()));
        }
        return null;
    }

    public ProcessWappMessageTriggerWSDTO removeProcessWappMessageTriggerService(long userId, String triggerId) {

        Optional<ProcessWappMessageTriggerDBModel> processWappMessageTriggerDBModel = processWappMessageTriggerRepository.findById(triggerId);
        if (processWappMessageTriggerDBModel.isPresent()){
            processWappMessageTriggerRepository.delete(processWappMessageTriggerDBModel.get());
            return new ProcessWappMessageTriggerWSDTO(processWappMessageTriggerDBModel.get());
        }
        return null;
    }



}
