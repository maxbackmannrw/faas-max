package com.faas.core.base.model.db.process.details.trigger.dao;

import java.util.List;

public class SipTriggerDAO {

    private String accountId;
    private String account;
    private String callerId;
    private List<TriggerDataDAO> triggerDatas;
    private long cDate;
    private int status;

    public SipTriggerDAO() {
    }

    public SipTriggerDAO(String accountId, String account, String callerId, List<TriggerDataDAO> triggerDatas, long cDate, int status) {
        this.accountId = accountId;
        this.account = account;
        this.callerId = callerId;
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

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
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
