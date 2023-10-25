package com.faas.core.base.model.db.operation.channel.dao;

import java.util.Map;

public class OperationWappMessageDAO {

    private String tempId;
    private String accountId;
    private String wappTitle;
    private String wappBody;
    private Map<String,String> messageMaps;
    private String messageType;
    private long cDate;

    public OperationWappMessageDAO() {
    }

    public OperationWappMessageDAO(String tempId, String accountId, String wappTitle, String wappBody, Map<String, String> messageMaps, String messageType, long cDate) {
        this.tempId = tempId;
        this.accountId = accountId;
        this.wappTitle = wappTitle;
        this.wappBody = wappBody;
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
