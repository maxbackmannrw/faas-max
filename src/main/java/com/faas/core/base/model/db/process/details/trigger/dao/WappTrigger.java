package com.faas.core.base.model.db.process.details.trigger.dao;

import java.util.List;

public class WappTrigger {

    private String id;
    private String accountId;
    private String wappAccount;
    private String wappTitle;
    private String wappBody;
    private List<TriggerData> datas;
    private long uDate;
    private long cDate;
    private int status;

    public WappTrigger() {
    }

    public WappTrigger(String id, String accountId, String wappAccount, String wappTitle, String wappBody, List<TriggerData> datas, long uDate, long cDate, int status) {
        this.id = id;
        this.accountId = accountId;
        this.wappAccount = wappAccount;
        this.wappTitle = wappTitle;
        this.wappBody = wappBody;
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

    public String getWappAccount() {
        return wappAccount;
    }

    public void setWappAccount(String wappAccount) {
        this.wappAccount = wappAccount;
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
