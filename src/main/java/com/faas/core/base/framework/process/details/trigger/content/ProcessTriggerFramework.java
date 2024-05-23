package com.faas.core.base.framework.process.details.trigger.content;

import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.ws.process.details.trigger.temp.ai.dto.AITriggerTempWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.content.dto.*;
import com.faas.core.base.model.ws.process.details.trigger.temp.email.dto.EmailTriggerTempWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.temp.sip.dto.SipTriggerTempWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.temp.sms.dto.SmsTriggerTempWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.temp.wapp.call.dto.WappCallTriggerTempWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.temp.wapp.message.dto.WappMessageTriggerTempWSDTO;
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
    AITriggerTempRepository aiTriggerTempRepository;

    @Autowired
    EmailTriggerTempRepository emailTriggerTempRepository;

    @Autowired
    SipTriggerTempRepository sipTriggerTempRepository;

    @Autowired
    SmsTriggerTempRepository smsTriggerTempRepository;

    @Autowired
    WappCallTriggerTempRepository wappCallTriggerTempRepository;

    @Autowired
    WappMessageTriggerTempRepository wappMessageTriggerTempRepository;

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

    public ProcessTriggerTempWSDTO getProcessTriggerTempService(long userId, String processId) {

        ProcessTriggerTempWSDTO processTriggerTempWSDTO = new ProcessTriggerTempWSDTO();
        processTriggerTempWSDTO.setAiTriggerTemps(getAITriggerTemps(userId,processId));
        processTriggerTempWSDTO.setEmailTriggerTemps(getEmailTriggerTemps(userId,processId));
        processTriggerTempWSDTO.setSipTriggerTemps(getSipTriggerTemps(userId,processId));
        processTriggerTempWSDTO.setSmsTriggerTemps(getSmsTriggerTemps(userId,processId));
        processTriggerTempWSDTO.setWappCallTriggerTemps(getWappCallTriggerTemps(userId,processId));
        processTriggerTempWSDTO.setWappMessageTriggerTemps(getWappMessageTriggerTemps(userId,processId));

        return processTriggerTempWSDTO;
    }

    public List<AITriggerTempWSDTO> getAITriggerTemps(long userId, String processId) {

        List<AITriggerTempWSDTO> AITriggerTempWSDTOS = new ArrayList<>();
        List<AITriggerTempDBModel> AITriggerTempDBModels = aiTriggerTempRepository.findByProcessId(processId);
        for (AITriggerTempDBModel aiTriggerTempDBModel : AITriggerTempDBModels) {
            AITriggerTempWSDTOS.add(new AITriggerTempWSDTO(aiTriggerTempDBModel));
        }
        return AITriggerTempWSDTOS;
    }

    public List<EmailTriggerTempWSDTO> getEmailTriggerTemps(long userId, String processId) {

        List<EmailTriggerTempWSDTO> emailTriggerTempWSDTOS = new ArrayList<>();
        List<EmailTriggerTempDBModel> emailTriggerTempDBModels = emailTriggerTempRepository.findByProcessId(processId);
        for (EmailTriggerTempDBModel emailTriggerTempDBModel : emailTriggerTempDBModels) {
            emailTriggerTempWSDTOS.add(new EmailTriggerTempWSDTO(emailTriggerTempDBModel));
        }
        return emailTriggerTempWSDTOS;
    }

    public List<SipTriggerTempWSDTO> getSipTriggerTemps(long userId, String processId) {

        List<SipTriggerTempWSDTO> sipTriggerTempWSDTOS = new ArrayList<>();
        List<SipTriggerTempDBModel> sipTriggerTempDBModels = sipTriggerTempRepository.findByProcessId(processId);
        for (SipTriggerTempDBModel sipTriggerTempDBModel : sipTriggerTempDBModels) {
            sipTriggerTempWSDTOS.add(new SipTriggerTempWSDTO(sipTriggerTempDBModel));
        }
        return sipTriggerTempWSDTOS;
    }

    public List<SmsTriggerTempWSDTO> getSmsTriggerTemps(long userId, String processId) {

        List<SmsTriggerTempWSDTO> smsTriggerTempWSDTOS = new ArrayList<>();
        List<SmsTriggerTempDBModel> smsTriggerTempDBModels = smsTriggerTempRepository.findByProcessId(processId);
        for (SmsTriggerTempDBModel smsTriggerTempDBModel : smsTriggerTempDBModels) {
            smsTriggerTempWSDTOS.add(new SmsTriggerTempWSDTO(smsTriggerTempDBModel));
        }
        return smsTriggerTempWSDTOS;
    }

    public List<WappCallTriggerTempWSDTO> getWappCallTriggerTemps(long userId, String processId) {

        List<WappCallTriggerTempWSDTO> wappCallTriggerTempWSDTOS = new ArrayList<>();
        List<WappCallTriggerTempDBModel> wappCallTriggerTempDBModels = wappCallTriggerTempRepository.findByProcessId(processId);
        for (WappCallTriggerTempDBModel wappCallTriggerTempDBModel : wappCallTriggerTempDBModels) {
            wappCallTriggerTempWSDTOS.add(new WappCallTriggerTempWSDTO(wappCallTriggerTempDBModel));
        }
        return wappCallTriggerTempWSDTOS;
    }

    public List<WappMessageTriggerTempWSDTO> getWappMessageTriggerTemps(long userId, String processId) {

        List<WappMessageTriggerTempWSDTO> wappMessageTriggerTempWSDTOS = new ArrayList<>();
        List<WappMessageTriggerTempDBModel> wappMessageTriggerTempDBModels = wappMessageTriggerTempRepository.findByProcessId(processId);
        for (WappMessageTriggerTempDBModel wappMessageTriggerTempDBModel : wappMessageTriggerTempDBModels) {
            wappMessageTriggerTempWSDTOS.add(new WappMessageTriggerTempWSDTO(wappMessageTriggerTempDBModel));
        }
        return wappMessageTriggerTempWSDTOS;
    }


}
