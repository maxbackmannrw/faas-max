package com.faas.core.api.model.ws.operation.manager.channel.call.dto;

import com.faas.core.data.db.channel.account.dao.AccountDataDAO;

import java.util.List;

public class ApiOperationWappCallAccountWSDTO {

    private String accountId;
    private String account;
    private String instanceKey;
    private String phoneNumber;
    private String serverUrl;
    private List<AccountDataDAO> accountDatas;
    private String callState;
    private String messageState;
    private long cDate;
    private int status;

    public ApiOperationWappCallAccountWSDTO() {
    }

    public ApiOperationWappCallAccountWSDTO(String accountId, String account, String instanceKey, String phoneNumber, String serverUrl, List<AccountDataDAO> accountDatas, String callState, String messageState, long cDate, int status) {
        this.accountId = accountId;
        this.account = account;
        this.instanceKey = instanceKey;
        this.phoneNumber = phoneNumber;
        this.serverUrl = serverUrl;
        this.accountDatas = accountDatas;
        this.callState = callState;
        this.messageState = messageState;
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

    public String getCallState() {
        return callState;
    }

    public void setCallState(String callState) {
        this.callState = callState;
    }

    public String getMessageState() {
        return messageState;
    }

    public void setMessageState(String messageState) {
        this.messageState = messageState;
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
