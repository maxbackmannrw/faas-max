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
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProcessTriggerFramework {

    @Autowired
    ProcessAITriggerRepository processAITriggerRepository;

    @Autowired
    ProcessEmailTriggerRepository processEmailTriggerRepository;

    @Autowired
    ProcessSipCallTriggerRepository processSipCallTriggerRepository;

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
        processTriggerWSDTO.setProcessSipCallTriggers(getProcessSipCallTriggersService(userId,processId));
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


    public List<ProcessSipCallTriggerWSDTO> getProcessSipCallTriggersService(long userId, String processId) {

        List<ProcessSipCallTriggerWSDTO> processSipCallTriggerWSDTOS = new ArrayList<>();
        List<ProcessSipCallTriggerDBModel> sipCallTriggerDBModels = processSipCallTriggerRepository.findByProcessId(processId);
        for (ProcessSipCallTriggerDBModel sipCallTriggerDBModel : sipCallTriggerDBModels) {
            processSipCallTriggerWSDTOS.add(new ProcessSipCallTriggerWSDTO(sipCallTriggerDBModel));
        }
        return processSipCallTriggerWSDTOS;
    }


    public ProcessSipCallTriggerWSDTO getProcessSipCallTriggerService(long userId, String triggerId) {

        Optional<ProcessSipCallTriggerDBModel> sipCallTriggerDBModel = processSipCallTriggerRepository.findById(triggerId);
        if (sipCallTriggerDBModel.isPresent()){
            return new ProcessSipCallTriggerWSDTO(sipCallTriggerDBModel.get());
        }
        return null;
    }

    public ProcessSipCallTriggerWSDTO createProcessSipCallTriggerService(long userId, String processId, String trigger, String triggerDesc, String accountId, String callerId, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (triggerTypeDBModel.isPresent() && sipAccountDBModel.isPresent()){

            ProcessSipCallTriggerDBModel sipCallTriggerDBModel = new ProcessSipCallTriggerDBModel();
            sipCallTriggerDBModel.setProcessId(processId);
            sipCallTriggerDBModel.setTrigger(trigger);
            sipCallTriggerDBModel.setTriggerDesc(triggerDesc);
            sipCallTriggerDBModel.setAccountId(accountId);
            sipCallTriggerDBModel.setAccount(sipAccountDBModel.get().getAccount());
            sipCallTriggerDBModel.setCallerId(callerId);
            sipCallTriggerDBModel.setDatas(new ArrayList<>());
            sipCallTriggerDBModel.setTypeId(typeId);
            sipCallTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            sipCallTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            sipCallTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            sipCallTriggerDBModel.setStatus(1);

            return new ProcessSipCallTriggerWSDTO(processSipCallTriggerRepository.save(sipCallTriggerDBModel));
        }
        return null;
    }

    public ProcessSipCallTriggerWSDTO updateProcessSipCallTriggerService(long userId, String triggerId, String trigger, String triggerDesc, String accountId, String callerId) {

        Optional<ProcessSipCallTriggerDBModel> sipCallTriggerDBModel = processSipCallTriggerRepository.findById(triggerId);
        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (sipCallTriggerDBModel.isPresent() && sipAccountDBModel.isPresent()){

            sipCallTriggerDBModel.get().setTrigger(trigger);
            sipCallTriggerDBModel.get().setTriggerDesc(triggerDesc);
            sipCallTriggerDBModel.get().setAccountId(accountId);
            sipCallTriggerDBModel.get().setAccount(sipAccountDBModel.get().getAccount());
            sipCallTriggerDBModel.get().setCallerId(callerId);
            sipCallTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            sipCallTriggerDBModel.get().setStatus(1);

            return new ProcessSipCallTriggerWSDTO(processSipCallTriggerRepository.save(sipCallTriggerDBModel.get()));
        }
        return null;
    }

    public ProcessSipCallTriggerWSDTO removeProcessSipCallTriggerService(long userId, String triggerId) {

        Optional<ProcessSipCallTriggerDBModel> sipCallTriggerDBModel = processSipCallTriggerRepository.findById(triggerId);
        if (sipCallTriggerDBModel.isPresent()){
            processSipCallTriggerRepository.delete(sipCallTriggerDBModel.get());
            return new ProcessSipCallTriggerWSDTO(sipCallTriggerDBModel.get());
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
        List<ProcessWappCallTriggerDBModel> wappCallTriggerDBModels = processWappCallTriggerRepository.findByProcessId(processId);
        for (ProcessWappCallTriggerDBModel wappCallTriggerDBModel : wappCallTriggerDBModels) {
            processWappCallTriggerWSDTOS.add(new ProcessWappCallTriggerWSDTO(wappCallTriggerDBModel));
        }
        return processWappCallTriggerWSDTOS;
    }

    public ProcessWappCallTriggerWSDTO getProcessWappCallTriggerService(long userId, String triggerId) {

        Optional<ProcessWappCallTriggerDBModel> wappCallTriggerDBModel = processWappCallTriggerRepository.findById(triggerId);
        if (wappCallTriggerDBModel.isPresent()){
            return new ProcessWappCallTriggerWSDTO(wappCallTriggerDBModel.get());
        }
        return null;
    }

    public ProcessWappCallTriggerWSDTO createProcessWappCallTriggerService(long userId, String processId, String trigger, String triggerDesc, String accountId, long typeId) {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (wappAccountDBModel.isPresent() && triggerTypeDBModel.isPresent()){

            ProcessWappCallTriggerDBModel wappCallTriggerDBModel = new ProcessWappCallTriggerDBModel();
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

            return new ProcessWappCallTriggerWSDTO(processWappCallTriggerRepository.save(wappCallTriggerDBModel));
        }
        return null;
    }

    public ProcessWappCallTriggerWSDTO updateProcessWappCallTriggerService(long userId, String triggerId, String trigger, String triggerDesc, String accountId) {

        Optional<ProcessWappCallTriggerDBModel> wappCallTriggerDBModel = processWappCallTriggerRepository.findById(triggerId);
        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (wappCallTriggerDBModel.isPresent() && wappAccountDBModel.isPresent()){

            wappCallTriggerDBModel.get().setTrigger(trigger);
            wappCallTriggerDBModel.get().setTriggerDesc(triggerDesc);
            wappCallTriggerDBModel.get().setAccountId(accountId);
            wappCallTriggerDBModel.get().setAccount(wappAccountDBModel.get().getAccount());
            wappCallTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            wappCallTriggerDBModel.get().setStatus(1);

            return new ProcessWappCallTriggerWSDTO(processWappCallTriggerRepository.save(wappCallTriggerDBModel.get()));
        }
        return null;
    }

    public ProcessWappCallTriggerWSDTO removeProcessWappCallTriggerService(long userId, String triggerId) {

        Optional<ProcessWappCallTriggerDBModel> wappCallTriggerDBModel = processWappCallTriggerRepository.findById(triggerId);
        if (wappCallTriggerDBModel.isPresent()){
            processWappCallTriggerRepository.delete(wappCallTriggerDBModel.get());
            return new ProcessWappCallTriggerWSDTO(wappCallTriggerDBModel.get());
        }
        return null;
    }


    public List<ProcessWappMessageTriggerWSDTO> getProcessWappMessageTriggersService(long userId, String processId) {

        List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggerWSDTOS = new ArrayList<>();
        List<ProcessWappMessageTriggerDBModel> wappMessageTriggerDBModels = processWappMessageTriggerRepository.findByProcessId(processId);
        for (ProcessWappMessageTriggerDBModel wappMessageTriggerDBModel : wappMessageTriggerDBModels) {
            processWappMessageTriggerWSDTOS.add(new ProcessWappMessageTriggerWSDTO(wappMessageTriggerDBModel));
        }
        return processWappMessageTriggerWSDTOS;
    }

    public ProcessWappMessageTriggerWSDTO getProcessWappMessageTriggerService(long userId, String triggerId) {

        Optional<ProcessWappMessageTriggerDBModel> wappMessageTriggerDBModel = processWappMessageTriggerRepository.findById(triggerId);
        if (wappMessageTriggerDBModel.isPresent()){
            return new ProcessWappMessageTriggerWSDTO(wappMessageTriggerDBModel.get());
        }
        return null;
    }

    public ProcessWappMessageTriggerWSDTO createProcessWappMessageTriggerService(long userId, String processId, String trigger, String triggerDesc, String accountId, String wappTitle, String wappBody, long typeId) {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (wappAccountDBModel.isPresent() && triggerTypeDBModel.isPresent()){

            ProcessWappMessageTriggerDBModel wappMessageTriggerDBModel = new ProcessWappMessageTriggerDBModel();
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

            return new ProcessWappMessageTriggerWSDTO(processWappMessageTriggerRepository.save(wappMessageTriggerDBModel));
        }
        return null;
    }

    public ProcessWappMessageTriggerWSDTO updateProcessWappMessageTriggerService(long userId, String triggerId, String trigger, String triggerDesc, String accountId, String wappTitle, String wappBody) {

        Optional<ProcessWappMessageTriggerDBModel> wappMessageTriggerDBModel = processWappMessageTriggerRepository.findById(triggerId);
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

            return new ProcessWappMessageTriggerWSDTO(processWappMessageTriggerRepository.save(wappMessageTriggerDBModel.get()));
        }
        return null;
    }

    public ProcessWappMessageTriggerWSDTO removeProcessWappMessageTriggerService(long userId, String triggerId) {

        Optional<ProcessWappMessageTriggerDBModel> wappMessageTriggerDBModel = processWappMessageTriggerRepository.findById(triggerId);
        if (wappMessageTriggerDBModel.isPresent()){

            processWappMessageTriggerRepository.delete(wappMessageTriggerDBModel.get());
            return new ProcessWappMessageTriggerWSDTO(wappMessageTriggerDBModel.get());
        }
        return null;
    }



}
