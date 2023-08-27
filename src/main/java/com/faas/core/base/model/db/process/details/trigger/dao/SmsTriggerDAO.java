package com.faas.core.base.model.db.process.details.trigger.dao;

import java.util.List;

public class SmsTriggerDAO {

    private String accountId;
    private String account;
    private String smsTitle;
    private String smsBody;
    private String senderId;
    private List<TriggerDataDAO> triggerDatas;
    private long cDate;
    private int status;

    public SmsTriggerDAO() {
    }

    public SmsTriggerDAO(String accountId, String account, String smsTitle, String smsBody, String senderId, List<TriggerDataDAO> triggerDatas, long cDate, int status) {
        this.accountId = accountId;
        this.account = account;
        this.smsTitle = smsTitle;
        this.smsBody = smsBody;
        this.senderId = senderId;
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

    public String getSmsTitle() {
        return smsTitle;
    }

    public void setSmsTitle(String smsTitle) {
        this.smsTitle = smsTitle;
    }

    public String getSmsBody() {
        return smsBody;
    }

    public void setSmsBody(String smsBody) {
        this.smsBody = smsBody;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
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
