package com.faas.core.base.model.db.process.details.trigger.dao;

import java.util.List;

public class EmailTrigger {

    private String id;
    private String accountId;
    private String emailAccount;
    private String emailSubject;
    private String emailTitle;
    private String emailBody;
    private String emailSender;
    private List<TriggerData>datas;
    private long uDate;
    private long cDate;
    private int status;

    public EmailTrigger() {
    }

    public EmailTrigger(String id, String accountId, String emailAccount, String emailSubject, String emailTitle, String emailBody, String emailSender, List<TriggerData> datas, long uDate, long cDate, int status) {
        this.id = id;
        this.accountId = accountId;
        this.emailAccount = emailAccount;
        this.emailSubject = emailSubject;
        this.emailTitle = emailTitle;
        this.emailBody = emailBody;
        this.emailSender = emailSender;
        this.datas = datas;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(String emailAccount) {
        this.emailAccount = emailAccount;
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

    public List<TriggerData> getDatas() {
        return datas;
    }

    public void setDatas(List<TriggerData> datas) {
        this.datas = datas;
    }

    public long getuDate() {
        return uDate;
    }

    public void setuDate(long uDate) {
        this.uDate = uDate;
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
