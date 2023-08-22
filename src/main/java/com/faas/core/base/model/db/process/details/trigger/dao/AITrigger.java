package com.faas.core.base.model.db.process.details.trigger.dao;

import java.util.List;

public class AITrigger {

    private String id;
    private String accountId;
    private String aiAccount;
    private List<TriggerData>datas;
    private long uDate;
    private long cDate;
    private int status;

    public AITrigger() {
    }

    public AITrigger(String id, String accountId, String aiAccount, List<TriggerData> datas, long uDate, long cDate, int status) {
        this.id = id;
        this.accountId = accountId;
        this.aiAccount = aiAccount;
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

    public String getAiAccount() {
        return aiAccount;
    }

    public void setAiAccount(String aiAccount) {
        this.aiAccount = aiAccount;
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
