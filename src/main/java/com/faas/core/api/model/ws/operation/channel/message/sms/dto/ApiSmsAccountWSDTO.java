package com.faas.core.api.model.ws.operation.channel.message.sms.dto;

import com.faas.core.base.model.db.channel.account.dao.AccountDataDAO;

import java.util.List;

public class ApiSmsAccountWSDTO {

    private String accountId;
    private String account;
    private String userName;
    private String password;
    private String apiToken;
    private String apiUrl;
    private List<AccountDataDAO> accountDatas;
    private String provider;
    private String smsStatus;
    private long cDate;
    private int status;

    public ApiSmsAccountWSDTO() {
    }

    public ApiSmsAccountWSDTO(String accountId, String account, String userName, String password, String apiToken, String apiUrl, List<AccountDataDAO> accountDatas, String provider, String smsStatus, long cDate, int status) {
        this.accountId = accountId;
        this.account = account;
        this.userName = userName;
        this.password = password;
        this.apiToken = apiToken;
        this.apiUrl = apiUrl;
        this.accountDatas = accountDatas;
        this.provider = provider;
        this.smsStatus = smsStatus;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
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

    public String getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(String smsStatus) {
        this.smsStatus = smsStatus;
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
