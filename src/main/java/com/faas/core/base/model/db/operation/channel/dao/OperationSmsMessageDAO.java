package com.faas.core.base.model.db.operation.channel.dao;

import java.util.Map;

public class OperationSmsMessageDAO {

    private String tempId;
    private String accountId;
    private String smsTitle;
    private String smsBody;
    private String senderId;
    private Map<String,String> messageMaps;
    private String messageType;
    private long cDate;

    public OperationSmsMessageDAO() {
    }

    public OperationSmsMessageDAO(String tempId, String accountId, String smsTitle, String smsBody, String senderId, Map<String, String> messageMaps, String messageType, long cDate) {
        this.tempId = tempId;
        this.accountId = accountId;
        this.smsTitle = smsTitle;
        this.smsBody = smsBody;
        this.senderId = senderId;
        this.messageMaps = messageMaps;
        this.messageType = messageType;
        this.cDate = cDate;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
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

    public Map<String, String> getMessageMaps() {
        return messageMaps;
    }

    public void setMessageMaps(Map<String, String> messageMaps) {
        this.messageMaps = messageMaps;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public long getcDate() {
        return cDate;
    }

    public void setcDate(long cDate) {
        this.cDate = cDate;
    }
}
