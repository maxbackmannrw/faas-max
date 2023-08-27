package com.faas.core.base.model.db.process.details.trigger.dao;

import java.util.List;

public class EmailTriggerDAO {

    private String accountId;
    private String account;
    private String emailSubject;
    private String emailTitle;
    private String emailBody;
    private String emailSender;
    private List<TriggerDataDAO> triggerDatas;
    private long cDate;
    private int status;

    public EmailTriggerDAO() {
    }

    public EmailTriggerDAO(String accountId, String account, String emailSubject, String emailTitle, String emailBody, String emailSender, List<TriggerDataDAO> triggerDatas, long cDate, int status) {
        this.accountId = accountId;
        this.account = account;
        this.emailSubject = emailSubject;
        this.emailTitle = emailTitle;
        this.emailBody = emailBody;
        this.emailSender = emailSender;
        this.triggerDatas = triggerDatas;
        this.cDate = cDate;
        this.status = status;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailTitle() {
        return emailTitle;
    }

    public void setEmailTitle(String emailTitle) {
        this.emailTitle = emailTitle;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public String getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(String emailSender) {
        this.emailSender = emailSender;
    }

    public List<TriggerDataDAO> getTriggerDatas() {
        return triggerDatas;
    }

    public void setTriggerDatas(List<TriggerDataDAO> triggerDatas) {
        this.triggerDatas = triggerDatas;
    }

    public long getcDate() {
        return cDate;
    }

    public void setcDate(long cDate) {
        this.cDate = cDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
