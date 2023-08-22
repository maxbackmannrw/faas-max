package com.faas.core.base.model.db.process.details.trigger.dao;

public class TriggerDAO {

    private AITrigger aiTrigger;
    private EmailTrigger emailTrigger;
    private SipTrigger sipTrigger;
    private SmsTrigger smsTrigger;
    private WappTrigger wappTrigger;

    public TriggerDAO() {
    }

    public TriggerDAO(AITrigger aiTrigger, EmailTrigger emailTrigger, SipTrigger sipTrigger, SmsTrigger smsTrigger, WappTrigger wappTrigger) {
        this.aiTrigger = aiTrigger;
        this.emailTrigger = emailTrigger;
        this.sipTrigger = sipTrigger;
        this.smsTrigger = smsTrigger;
        this.wappTrigger = wappTrigger;
    }

    public AITrigger getAiTrigger() {
        return aiTrigger;
    }

    public void setAiTrigger(AITrigger aiTrigger) {
        this.aiTrigger = aiTrigger;
    }

    public EmailTrigger getEmailTrigger() {
        return emailTrigger;
    }

    public void setEmailTrigger(EmailTrigger emailTrigger) {
        this.emailTrigger = emailTrigger;
    }

    public SipTrigger getSipTrigger() {
        return sipTrigger;
    }

    public void setSipTrigger(SipTrigger sipTrigger) {
        this.sipTrigger = sipTrigger;
    }

    public SmsTrigger getSmsTrigger() {
        return smsTrigger;
    }

    public void setSmsTrigger(SmsTrigger smsTrigger) {
        this.smsTrigger = smsTrigger;
    }

    public WappTrigger getWappTrigger() {
        return wappTrigger;
    }

    public void setWappTrigger(WappTrigger wappTrigger) {
        this.wappTrigger = wappTrigger;
    }
}
