package com.faas.core.api.model.ws.operation.details.channel.message.push.dto;

import com.faas.core.data.db.channel.account.dao.AccountDataDAO;

import java.util.List;

public class ApiOperationPushAccountWSDTO {

    private String accountId;
    private String account;
    private List<AccountDataDAO> accountDatas;
    private String provider;
    private String channelState;
    private long cDate;
    private int status;

    public ApiOperationPushAccountWSDTO() {
    }

    public ApiOperationPushAccountWSDTO(String accountId, String account, List<AccountDataDAO> accountDatas, String provider, String channelState, long cDate, int status) {
        this.accountId = accountId;
        this.account = account;
        this.accountDatas = accountDatas;
        this.provider = provider;
        this.channelState = channelState;
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

    public String getChannelState() {
        return channelState;
    }

    public void setChannelState(String channelState) {
        this.channelState = channelState;
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
