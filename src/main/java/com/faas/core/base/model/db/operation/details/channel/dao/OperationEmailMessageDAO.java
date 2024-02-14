package com.faas.core.base.model.db.operation.details.channel.dao;

import java.util.List;

public class OperationEmailMessageDAO {

    private String accountId;
    private String tempId;
    private String subject;
    private String body;
    private String footer;
    private String sender;
    private List<OperationChannelDataDAO> emailDatas;
    private String emailType;
    private int status;

    public OperationEmailMessageDAO() {
    }

    public OperationEmailMessageDAO(String accountId, String tempId, String subject, String body, String footer, String sender, List<OperationChannelDataDAO> emailDatas, String emailType, int status) {
        this.accountId = accountId;
        this.tempId = tempId;
        this.subject = subject;
        this.body = body;
        this.footer = footer;
        this.sender = sender;
        this.emailDatas = emailDatas;
        this.emailType = emailType;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public List<OperationChannelDataDAO> getEmailDatas() {
        return emailDatas;
    }

    public void setEmailDatas(List<OperationChannelDataDAO> emailDatas) {
        this.emailDatas = emailDatas;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
