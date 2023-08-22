package com.faas.core.base.model.db.process.details.trigger.dao;

import java.util.List;

public class SipTrigger {

    private String id;
    private String accountId;
    private String sipAccount;
    private String callerId;
    private List<TriggerData> datas;
    private long uDate;
    private long cDate;
    private int status;

    public SipTrigger() {
    }

    public SipTrigger(String id, String accountId, String sipAccount, String callerId, List<TriggerData> datas, long uDate, long cDate, int status) {
        this.id = id;
        this.accountId = accountId;
        this.sipAccount = sipAccount;
        this.callerId = callerId;
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

    public String getSipAccount() {
        return sipAccount;
    }

    public void setSipAccount(String sipAccount) {
        this.sipAccount = sipAccount;
    }

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
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
