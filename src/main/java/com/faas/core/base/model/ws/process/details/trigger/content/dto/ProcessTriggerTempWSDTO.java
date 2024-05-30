package com.faas.core.base.model.ws.process.details.trigger.content.dto;

import com.faas.core.base.model.ws.process.details.trigger.temp.dto.AITriggerTempWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.temp.dto.EmailTriggerTempWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.temp.dto.SipTriggerTempWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.temp.dto.SmsTriggerTempWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.temp.dto.WappCallTriggerTempWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.temp.dto.WappMessageTriggerTempWSDTO;

import java.util.List;

public class ProcessTriggerTempWSDTO {

    private List<AITriggerTempWSDTO> aiTriggerTemps;
    private List<EmailTriggerTempWSDTO>emailTriggerTemps;
    private List<SipTriggerTempWSDTO>sipTriggerTemps;
    private List<SmsTriggerTempWSDTO>smsTriggerTemps;
    private List<WappCallTriggerTempWSDTO>wappCallTriggerTemps;
    private List<WappMessageTriggerTempWSDTO>wappMessageTriggerTemps;

    public ProcessTriggerTempWSDTO() {
    }

    public ProcessTriggerTempWSDTO(List<AITriggerTempWSDTO> aiTriggerTemps, List<EmailTriggerTempWSDTO> emailTriggerTemps, List<SipTriggerTempWSDTO> sipTriggerTemps, List<SmsTriggerTempWSDTO> smsTriggerTemps, List<WappCallTriggerTempWSDTO> wappCallTriggerTemps, List<WappMessageTriggerTempWSDTO> wappMessageTriggerTemps) {
        this.aiTriggerTemps = aiTriggerTemps;
        this.emailTriggerTemps = emailTriggerTemps;
        this.sipTriggerTemps = sipTriggerTemps;
        this.smsTriggerTemps = smsTriggerTemps;
        this.wappCallTriggerTemps = wappCallTriggerTemps;
        this.wappMessageTriggerTemps = wappMessageTriggerTemps;
    }

    public List<AITriggerTempWSDTO> getAiTriggerTemps() {
        return aiTriggerTemps;
    }

    public void setAiTriggerTemps(List<AITriggerTempWSDTO> aiTriggerTemps) {
        this.aiTriggerTemps = aiTriggerTemps;
    }

    public List<EmailTriggerTempWSDTO> getEmailTriggerTemps() {
        return emailTriggerTemps;
    }

    public void setEmailTriggerTemps(List<EmailTriggerTempWSDTO> emailTriggerTemps) {
        this.emailTriggerTemps = emailTriggerTemps;
    }

    public List<SipTriggerTempWSDTO> getSipTriggerTemps() {
        return sipTriggerTemps;
    }

    public void setSipTriggerTemps(List<SipTriggerTempWSDTO> sipTriggerTemps) {
        this.sipTriggerTemps = sipTriggerTemps;
    }

    public List<SmsTriggerTempWSDTO> getSmsTriggerTemps() {
        return smsTriggerTemps;
    }

    public void setSmsTriggerTemps(List<SmsTriggerTempWSDTO> smsTriggerTemps) {
        this.smsTriggerTemps = smsTriggerTemps;
    }

    public List<WappCallTriggerTempWSDTO> getWappCallTriggerTemps() {
        return wappCallTriggerTemps;
    }

    public void setWappCallTriggerTemps(List<WappCallTriggerTempWSDTO> wappCallTriggerTemps) {
        this.wappCallTriggerTemps = wappCallTriggerTemps;
    }

    public List<WappMessageTriggerTempWSDTO> getWappMessageTriggerTemps() {
        return wappMessageTriggerTemps;
    }

    public void setWappMessageTriggerTemps(List<WappMessageTriggerTempWSDTO> wappMessageTriggerTemps) {
        this.wappMessageTriggerTemps = wappMessageTriggerTemps;
    }
}
