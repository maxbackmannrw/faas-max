package com.faas.core.base.framework.process.details.trigger.content;

import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.ws.process.details.trigger.ai.dto.ProcessAITriggerWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.content.dto.*;
import com.faas.core.base.model.ws.process.details.trigger.email.dto.ProcessEmailTriggerWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.sip.dto.ProcessSipTriggerWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.sms.dto.ProcessSmsTriggerWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.wapp.dto.ProcessWappCallTriggerWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.wapp.dto.ProcessWappMessageTriggerWSDTO;
import com.faas.core.base.repo.channel.account.EmailAccountRepository;
import com.faas.core.base.repo.channel.account.SipAccountRepository;
import com.faas.core.base.repo.channel.account.SmsAccountRepository;
import com.faas.core.base.repo.channel.account.WappAccountRepository;
import com.faas.core.base.repo.channel.settings.MessageTypeRepository;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.process.settings.TriggerTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessTriggerFramework {

    @Autowired
    AITriggerRepository aiTriggerRepository;

    @Autowired
    EmailTriggerRepository emailTriggerRepository;

    @Autowired
    SipTriggerRepository sipTriggerRepository;

    @Autowired
    SmsTriggerRepository smsTriggerRepository;

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
        processTriggerWSDTO.setProcessAITriggers(getProcessAITriggers(userId,processId));
        processTriggerWSDTO.setProcessEmailTriggers(getProcessEmailTriggers(userId,processId));
        processTriggerWSDTO.setProcessSipTriggers(getProcessSipTriggers(userId,processId));
        processTriggerWSDTO.setProcessSmsTriggers(getProcessSmsTriggers(userId,processId));
        processTriggerWSDTO.setProcessWappCallTriggers(getProcessWappCallTriggers(userId,processId));
        processTriggerWSDTO.setProcessWappMessageTriggers(getProcessWappMessageTriggers(userId,processId));

        return processTriggerWSDTO;
    }

    public List<ProcessAITriggerWSDTO> getProcessAITriggers(long userId, String processId) {

        List<ProcessAITriggerWSDTO> processAITriggerWSDTOS = new ArrayList<>();
        List<AITriggerDBModel> AITriggerDBModels = aiTriggerRepository.findByProcessId(processId);
        for (AITriggerDBModel aiTriggerDBModel : AITriggerDBModels) {
            processAITriggerWSDTOS.add(new ProcessAITriggerWSDTO(aiTriggerDBModel));
        }
        return processAITriggerWSDTOS;
    }

    public List<ProcessEmailTriggerWSDTO> getProcessEmailTriggers(long userId, String processId) {

        List<ProcessEmailTriggerWSDTO> processEmailTriggerWSDTOS = new ArrayList<>();
        List<EmailTriggerDBModel> emailTriggerDBModels = emailTriggerRepository.findByProcessId(processId);
        for (EmailTriggerDBModel emailTriggerDBModel : emailTriggerDBModels) {
            processEmailTriggerWSDTOS.add(new ProcessEmailTriggerWSDTO(emailTriggerDBModel));
        }
        return processEmailTriggerWSDTOS;
    }

    public List<ProcessSipTriggerWSDTO> getProcessSipTriggers(long userId, String processId) {

        List<ProcessSipTriggerWSDTO> processSipTriggerWSDTOS = new ArrayList<>();
        List<SipTriggerDBModel> sipTriggerDBModels = sipTriggerRepository.findByProcessId(processId);
        for (SipTriggerDBModel sipTriggerDBModel : sipTriggerDBModels) {
            processSipTriggerWSDTOS.add(new ProcessSipTriggerWSDTO(sipTriggerDBModel));
        }
        return processSipTriggerWSDTOS;
    }

    public List<ProcessSmsTriggerWSDTO> getProcessSmsTriggers(long userId, String processId) {

        List<ProcessSmsTriggerWSDTO> processSmsTriggerWSDTOS = new ArrayList<>();
        List<SmsTriggerDBModel> smsTriggerDBModels = smsTriggerRepository.findByProcessId(processId);
        for (SmsTriggerDBModel smsTriggerDBModel : smsTriggerDBModels) {
            processSmsTriggerWSDTOS.add(new ProcessSmsTriggerWSDTO(smsTriggerDBModel));
        }
        return processSmsTriggerWSDTOS;
    }

    public List<ProcessWappCallTriggerWSDTO> getProcessWappCallTriggers(long userId, String processId) {

        List<ProcessWappCallTriggerWSDTO> processWappCallTriggerWSDTOS = new ArrayList<>();
        List<WappCallTriggerDBModel> wappCallTriggerDBModels = wappCallTriggerRepository.findByProcessId(processId);
        for (WappCallTriggerDBModel wappCallTriggerDBModel : wappCallTriggerDBModels) {
            processWappCallTriggerWSDTOS.add(new ProcessWappCallTriggerWSDTO(wappCallTriggerDBModel));
        }
        return processWappCallTriggerWSDTOS;
    }

    public List<ProcessWappMessageTriggerWSDTO> getProcessWappMessageTriggers(long userId, String processId) {

        List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggerWSDTOS = new ArrayList<>();
        List<WappMessageTriggerDBModel> wappMessageTriggerDBModels = wappMessageTriggerRepository.findByProcessId(processId);
        for (WappMessageTriggerDBModel wappMessageTriggerDBModel : wappMessageTriggerDBModels) {
            processWappMessageTriggerWSDTOS.add(new ProcessWappMessageTriggerWSDTO(wappMessageTriggerDBModel));
        }
        return processWappMessageTriggerWSDTOS;
    }


}
