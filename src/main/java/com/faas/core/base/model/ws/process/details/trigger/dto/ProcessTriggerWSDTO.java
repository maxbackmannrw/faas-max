package com.faas.core.base.model.ws.process.details.trigger.dto;

import java.util.List;

public class ProcessTriggerWSDTO {

    private List<AiTriggerWSDTO> aiTriggers;
    private List<EmailTriggerWSDTO>emailTriggers;
    private List<SipCallTriggerWSDTO>sipCallTriggers;
    private List<SmsMessageTriggerWSDTO>smsMessageTriggers;
    private List<WappCallTriggerWSDTO>wappCallTriggers;
    private List<WappMessageTriggerWSDTO>wappMessageTriggers;

    public ProcessTriggerWSDTO() {
    }

    public ProcessTriggerWSDTO(List<AiTriggerWSDTO> aiTriggers, List<EmailTriggerWSDTO> emailTriggers, List<SipCallTriggerWSDTO> sipCallTriggers, List<SmsMessageTriggerWSDTO> smsMessageTriggers, List<WappCallTriggerWSDTO> wappCallTriggers, List<WappMessageTriggerWSDTO> wappMessageTriggers) {
        this.aiTriggers = aiTriggers;
        this.emailTriggers = emailTriggers;
        this.sipCallTriggers = sipCallTriggers;
        this.smsMessageTriggers = smsMessageTriggers;
        this.wappCallTriggers = wappCallTriggers;
        this.wappMessageTriggers = wappMessageTriggers;
    }

    public List<AiTriggerWSDTO> getAiTriggers() {
        return aiTriggers;
    }

    public void setAiTriggers(List<AiTriggerWSDTO> aiTriggers) {
        this.aiTriggers = aiTriggers;
    }

    public List<EmailTriggerWSDTO> getEmailTriggers() {
        return emailTriggers;
    }

    public void setEmailTriggers(List<EmailTriggerWSDTO> emailTriggers) {
        this.emailTriggers = emailTriggers;
    }

    public List<SipCallTriggerWSDTO> getSipCallTriggers() {
        return sipCallTriggers;
    }

    public void setSipCallTriggers(List<SipCallTriggerWSDTO> sipCallTriggers) {
        this.sipCallTriggers = sipCallTriggers;
    }

    public List<SmsMessageTriggerWSDTO> getSmsMessageTriggers() {
        return smsMessageTriggers;
    }

    public void setSmsMessageTriggers(List<SmsMessageTriggerWSDTO> smsMessageTriggers) {
        this.smsMessageTriggers = smsMessageTriggers;
    }

    public List<WappCallTriggerWSDTO> getWappCallTriggers() {
        return wappCallTriggers;
    }

    public void setWappCallTriggers(List<WappCallTriggerWSDTO> wappCallTriggers) {
        this.wappCallTriggers = wappCallTriggers;
    }

    public List<WappMessageTriggerWSDTO> getWappMessageTriggers() {
        return wappMessageTriggers;
    }

    public void setWappMessageTriggers(List<WappMessageTriggerWSDTO> wappMessageTriggers) {
        this.wappMessageTriggers = wappMessageTriggers;
    }
}
