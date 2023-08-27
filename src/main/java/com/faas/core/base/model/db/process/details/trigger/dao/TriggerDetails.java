package com.faas.core.base.model.db.process.details.trigger.dao;

public class TriggerDetails {

    private AiTriggerDAO aiTrigger;
    private EmailTriggerDAO emailTrigger;
    private SipTriggerDAO sipTrigger;
    private SmsTriggerDAO smsTrigger;
    private WappCallTriggerDAO wappCallTrigger;
    private WappMessageTriggerDAO wappMessageTrigger;

    public TriggerDetails() {
    }

    public TriggerDetails(AiTriggerDAO aiTrigger, EmailTriggerDAO emailTrigger, SipTriggerDAO sipTrigger, SmsTriggerDAO smsTrigger, WappCallTriggerDAO wappCallTrigger, WappMessageTriggerDAO wappMessageTrigger) {
        this.aiTrigger = aiTrigger;
        this.emailTrigger = emailTrigger;
        this.sipTrigger = sipTrigger;
        this.smsTrigger = smsTrigger;
        this.wappCallTrigger = wappCallTrigger;
        this.wappMessageTrigger = wappMessageTrigger;
    }

    public AiTriggerDAO getAiTrigger() {
        return aiTrigger;
    }

    public void setAiTrigger(AiTriggerDAO aiTrigger) {
        this.aiTrigger = aiTrigger;
    }

    public EmailTriggerDAO getEmailTrigger() {
        return emailTrigger;
    }

    public void setEmailTrigger(EmailTriggerDAO emailTrigger) {
        this.emailTrigger = emailTrigger;
    }

    public SipTriggerDAO getSipTrigger() {
        return sipTrigger;
    }

    public void setSipTrigger(SipTriggerDAO sipTrigger) {
        this.sipTrigger = sipTrigger;
    }

    public SmsTriggerDAO getSmsTrigger() {
        return smsTrigger;
    }

    public void setSmsTrigger(SmsTriggerDAO smsTrigger) {
        this.smsTrigger = smsTrigger;
    }

    public WappCallTriggerDAO getWappCallTrigger() {
        return wappCallTrigger;
    }

    public void setWappCallTrigger(WappCallTriggerDAO wappCallTrigger) {
        this.wappCallTrigger = wappCallTrigger;
    }

    public WappMessageTriggerDAO getWappMessageTrigger() {
        return wappMessageTrigger;
    }

    public void setWappMessageTrigger(WappMessageTriggerDAO wappMessageTrigger) {
        this.wappMessageTrigger = wappMessageTrigger;
    }
}
