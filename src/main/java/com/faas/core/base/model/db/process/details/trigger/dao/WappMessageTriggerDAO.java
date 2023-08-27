package com.faas.core.base.model.db.process.details.trigger.dao;

import java.util.List;

public class WappMessageTriggerDAO {

    private String accountId;
    private String account;
    private String wappTitle;
    private String wappBody;
    private List<TriggerDataDAO> triggerDatas;
    private long cDate;
    private int status;

    public WappMessageTriggerDAO() {
    }

    public WappMessageTriggerDAO(String accountId, String account, String wappTitle, String wappBody, List<TriggerDataDAO> triggerDatas, long cDate, int status) {
        this.accountId = accountId;
        this.account = account;
        this.wappTitle = wappTitle;
        this.wappBody = wappBody;
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

    public String getWappTitle() {
        return wappTitle;
    }

    public void setWappTitle(String wappTitle) {
        this.wappTitle = wappTitle;
    }

    public String getWappBody() {
        return wappBody;
    }

    public void setWappBody(String wappBody) {
        this.wappBody = wappBody;
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
