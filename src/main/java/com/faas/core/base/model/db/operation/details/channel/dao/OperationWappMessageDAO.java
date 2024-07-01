package com.faas.core.base.model.db.operation.details.channel.dao;

import java.util.List;

public class OperationWappMessageDAO {

    private String accountId;
    private String tempId;
    private String wappTitle;
    private String wappBody;
    private List<ChannelDataDAO>messageDatas;
    private String messageType;
    private int status;

    public OperationWappMessageDAO() {
    }

    public OperationWappMessageDAO(String accountId, String tempId, String wappTitle, String wappBody, List<ChannelDataDAO> messageDatas, String messageType, int status) {
        this.accountId = accountId;
        this.tempId = tempId;
        this.wappTitle = wappTitle;
        this.wappBody = wappBody;
        this.messageDatas = messageDatas;
        this.messageType = messageType;
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

    public List<ChannelDataDAO> getMessageDatas() {
        return messageDatas;
    }

    public void setMessageDatas(List<ChannelDataDAO> messageDatas) {
        this.messageDatas = messageDatas;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}


