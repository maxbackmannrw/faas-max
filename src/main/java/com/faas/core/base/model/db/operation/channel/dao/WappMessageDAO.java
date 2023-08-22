package com.faas.core.base.model.db.operation.channel.dao;


import java.util.List;

public class WappMessageDAO {

    private String tempId;
    private String wappTitle;
    private String wappBody;
    private List<MessageDataDAO> messageDatas;
    private String messageType;
    private String accountId;
    private long cDate;

    public WappMessageDAO() {
    }

    public WappMessageDAO(String tempId, String wappTitle, String wappBody, List<MessageDataDAO> messageDatas, String messageType, String accountId, long cDate) {
        this.tempId = tempId;
        this.wappTitle = wappTitle;
        this.wappBody = wappBody;
        this.messageDatas = messageDatas;
        this.messageType = messageType;
        this.accountId = accountId;
        this.cDate = cDate;
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

    public List<MessageDataDAO> getMessageDatas() {
        return messageDatas;
    }

    public void setMessageDatas(List<MessageDataDAO> messageDatas) {
        this.messageDatas = messageDatas;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public long getcDate() {
        return cDate;
    }

    public void setcDate(long cDate) {
        this.cDate = cDate;
    }
}
