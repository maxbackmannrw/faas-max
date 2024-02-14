package com.faas.core.base.model.db.operation.details.channel.dao;

import java.util.List;

public class OperationSmsMessageDAO {

    private String smsTempId;
    private String accountId;
    private String smsTitle;
    private String smsBody;
    private String senderId;
    private List<OperationChannelDataDAO>smsDatas;
    private String smsType;
    private int status;

    public OperationSmsMessageDAO() {
    }

    public OperationSmsMessageDAO(String smsTempId, String accountId, String smsTitle, String smsBody, String senderId, List<OperationChannelDataDAO> smsDatas, String smsType, int status) {
        this.smsTempId = smsTempId;
        this.accountId = accountId;
        this.smsTitle = smsTitle;
        this.smsBody = smsBody;
        this.senderId = senderId;
        this.smsDatas = smsDatas;
        this.smsType = smsType;
        this.status = status;
    }

    public String getSmsTempId() {
        return smsTempId;
    }

    public void setSmsTempId(String smsTempId) {
        this.smsTempId = smsTempId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getSmsTitle() {
        return smsTitle;
    }

    public void setSmsTitle(String smsTitle) {
        this.smsTitle = smsTitle;
    }

    public String getSmsBody() {
        return smsBody;
    }

    public void setSmsBody(String smsBody) {
        this.smsBody = smsBody;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public List<OperationChannelDataDAO> getSmsDatas() {
        return smsDatas;
    }

    public void setSmsDatas(List<OperationChannelDataDAO> smsDatas) {
        this.smsDatas = smsDatas;
    }

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
