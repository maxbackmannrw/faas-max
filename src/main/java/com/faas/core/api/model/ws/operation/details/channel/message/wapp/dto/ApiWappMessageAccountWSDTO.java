package com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto;

import com.faas.core.base.model.db.channel.account.dao.AccountDataDAO;

import java.util.List;

public class ApiWappMessageAccountWSDTO {

    private String accountId;
    private String account;
    private String instanceKey;
    private String phoneNumber;
    private String serverUrl;
    private List<AccountDataDAO> accountDatas;
    private String callStatus;
    private String messageStatus;
    private long cDate;
    private int status;

    public ApiWappMessageAccountWSDTO() {
    }

    public ApiWappMessageAccountWSDTO(String accountId, String account, String instanceKey, String phoneNumber, String serverUrl, List<AccountDataDAO> accountDatas, String callStatus, String messageStatus, long cDate, int status) {
        this.accountId = accountId;
        this.account = account;
        this.instanceKey = instanceKey;
        this.phoneNumber = phoneNumber;
        this.serverUrl = serverUrl;
        this.accountDatas = accountDatas;
        this.callStatus = callStatus;
        this.messageStatus = messageStatus;
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

    public String getInstanceKey() {
        return instanceKey;
    }

    public void setInstanceKey(String instanceKey) {
        this.instanceKey = instanceKey;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public List<AccountDataDAO> getAccountDatas() {
        return accountDatas;
    }

    public void setAccountDatas(List<AccountDataDAO> accountDatas) {
        this.accountDatas = accountDatas;
    }

    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
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
