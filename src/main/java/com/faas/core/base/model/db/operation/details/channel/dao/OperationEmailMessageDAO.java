package com.faas.core.base.model.db.operation.details.channel.dao;

import java.util.List;

public class OperationEmailMessageDAO {

    private String accountId;
    private String tempId;
    private String emailSubject;
    private String emailBody;
    private String emailFooter;
    private String emailSender;
    private List<OperationChannelDataDAO> emailDatas;
    private String emailType;
    private int status;

    public OperationEmailMessageDAO() {
    }

    public OperationEmailMessageDAO(String accountId, String tempId, String emailSubject, String emailBody, String emailFooter, String emailSender, List<OperationChannelDataDAO> emailDatas, String emailType, int status) {
        this.accountId = accountId;
        this.tempId = tempId;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;
        this.emailFooter = emailFooter;
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

    public String getEmailFooter() {
        return emailFooter;
    }

    public void setEmailFooter(String emailFooter) {
        this.emailFooter = emailFooter;
    }

    public String getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(String emailSender) {
        this.emailSender = emailSender;
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
