package com.faas.core.api.model.ws.operation.details.channel.message.push.dto;

import com.faas.core.base.model.db.channel.account.dao.AccountDataDAO;

import java.util.List;

public class ApiPushAccountWSDTO {

    private String accountId;
    private String account;
    private List<AccountDataDAO> accountDatas;
    private String provider;
    private String pushStatus;
    private long cDate;
    private int status;

    public ApiPushAccountWSDTO() {
    }

    public ApiPushAccountWSDTO(String accountId, String account, List<AccountDataDAO> accountDatas, String provider, String pushStatus, long cDate, int status) {
        this.accountId = accountId;
        this.account = account;
        this.accountDatas = accountDatas;
        this.provider = provider;
        this.pushStatus = pushStatus;
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

    public List<AccountDataDAO> getAccountDatas() {
        return accountDatas;
    }

    public void setAccountDatas(List<AccountDataDAO> accountDatas) {
        this.accountDatas = accountDatas;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(String pushStatus) {
        this.pushStatus = pushStatus;
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
