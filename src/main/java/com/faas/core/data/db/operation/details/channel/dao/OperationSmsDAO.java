package com.faas.core.data.db.operation.details.channel.dao;

import java.util.List;

public class OperationSmsDAO {

    private String accountId;
    private String tempId;
    private String smsTitle;
    private String smsBody;
    private String senderId;
    private List<ChannelDataDAO> smsDatas;
    private String smsType;
    private int status;

    public OperationSmsDAO() {
    }

    public OperationSmsDAO(String accountId, String tempId, String smsTitle, String smsBody, String senderId, List<ChannelDataDAO> smsDatas, String smsType, int status) {
        this.accountId = accountId;
        this.tempId = tempId;
        this.smsTitle = smsTitle;
        this.smsBody = smsBody;
        this.senderId = senderId;
        this.smsDatas = smsDatas;
        this.smsType = smsType;
        this.status = status;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
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

    public List<ChannelDataDAO> getSmsDatas() {
        return smsDatas;
    }

    public void setSmsDatas(List<ChannelDataDAO> smsDatas) {
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
