package com.faas.core.base.model.db.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.dao.OperationEmailMessageDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "operation_email_message_table")
public class OperationEmailMessageDBModel {

    @Id
    private String id;
    private long sessionId;
    private String sessionUUID;
    private long clientId;
    private long agentId;
    private long addressId;
    private String emailAddress;
    private String tempId;
    private String campaignId;
    private String processId;
    private String subject;
    private String body;
    private String footer;
    private List<OperationEmailMessageDataDAO>messageDatas;
    private String sender;
    private String emailType;
    private String accountId;
    private String sentId;
    private String emailState;
    private long uDate;
    private long cDate;
    private int status;


    public OperationEmailMessageDBModel() {
    }

    public OperationEmailMessageDBModel(String id, long sessionId, String sessionUUID, long clientId, long agentId, long addressId, String emailAddress, String tempId, String campaignId, String processId, String subject, String body, String footer, List<OperationEmailMessageDataDAO> messageDatas, String sender, String emailType, String accountId, String sentId, String emailState, long uDate, long cDate, int status) {
        this.id = id;
        this.sessionId = sessionId;
        this.sessionUUID = sessionUUID;
        this.clientId = clientId;
        this.agentId = agentId;
        this.addressId = addressId;
        this.emailAddress = emailAddress;
        this.tempId = tempId;
        this.campaignId = campaignId;
        this.processId = processId;
        this.subject = subject;
        this.body = body;
        this.footer = footer;
        this.messageDatas = messageDatas;
        this.sender = sender;
        this.emailType = emailType;
        this.accountId = accountId;
        this.sentId = sentId;
        this.emailState = emailState;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionUUID() {
        return sessionUUID;
    }

    public void setSessionUUID(String sessionUUID) {
        this.sessionUUID = sessionUUID;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
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

    public List<OperationEmailMessageDataDAO> getMessageDatas() {
        return messageDatas;
    }

    public void setMessageDatas(List<OperationEmailMessageDataDAO> messageDatas) {
        this.messageDatas = messageDatas;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getSentId() {
        return sentId;
    }

    public void setSentId(String sentId) {
        this.sentId = sentId;
    }

    public String getEmailState() {
        return emailState;
    }

    public void setEmailState(String emailState) {
        this.emailState = emailState;
    }

    public long getuDate() {
        return uDate;
    }

    public void setuDate(long uDate) {
        this.uDate = uDate;
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
