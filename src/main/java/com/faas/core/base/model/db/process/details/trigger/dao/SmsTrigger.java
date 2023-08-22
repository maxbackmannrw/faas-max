package com.faas.core.base.model.db.process.details.trigger.dao;

import java.util.List;

public class SmsTrigger {

    private String id;
    private String accountId;
    private String smsAccount;
    private String smsTitle;
    private String smsBody;
    private String senderId;
    private List<TriggerData> datas;
    private long uDate;
    private long cDate;
    private int status;

    public SmsTrigger() {
    }

    public SmsTrigger(String id, String accountId, String smsAccount, String smsTitle, String smsBody, String senderId, List<TriggerData> datas, long uDate, long cDate, int status) {
        this.id = id;
        this.accountId = accountId;
        this.smsAccount = smsAccount;
        this.smsTitle = smsTitle;
        this.smsBody = smsBody;
        this.senderId = senderId;
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

    public String getSmsAccount() {
        return smsAccount;
    }

    public void setSmsAccount(String smsAccount) {
        this.smsAccount = smsAccount;
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
