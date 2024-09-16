package com.faas.core.data.db.operation.details.channel.dao;

import java.util.List;

public class OperationEmailDAO {

    private String accountId;
    private String tempId;
    private String emailSubject;
    private String emailBody;
    private String emailSender;
    private List<ChannelDataDAO> emailDatas;
    private String emailType;
    private int status;

    public OperationEmailDAO() {
    }

    public OperationEmailDAO(String accountId, String tempId, String emailSubject, String emailBody, String emailSender, List<ChannelDataDAO> emailDatas, String emailType, int status) {
        this.accountId = accountId;
        this.tempId = tempId;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;
        this.emailSender = emailSender;
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

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public String getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(String emailSender) {
        this.emailSender = emailSender;
    }

    public List<ChannelDataDAO> getEmailDatas() {
        return emailDatas;
    }

    public void setEmailDatas(List<ChannelDataDAO> emailDatas) {
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
