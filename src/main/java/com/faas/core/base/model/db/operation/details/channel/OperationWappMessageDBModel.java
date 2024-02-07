package com.faas.core.base.model.db.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.dao.OperationWappMessageDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "operation_wapp_message_table")
public class OperationWappMessageDBModel {

    @Id
    private String id;
    private String operationId;
    private long sessionId;
    private long clientId;
    private String numberId;
    private String phoneNumber;
    private long agentId;
    private String campaignId;
    private String processId;
    private OperationWappMessageDAO wappMessage;
    private String messageSentId;
    private String messageState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationWappMessageDBModel() {
    }

    public OperationWappMessageDBModel(String id, String operationId, long sessionId, long clientId, String numberId, String phoneNumber, long agentId, String campaignId, String processId, OperationWappMessageDAO wappMessage, String messageSentId, String messageState, long uDate, long cDate, int status) {
        this.id = id;
        this.operationId = operationId;
        this.sessionId = sessionId;
        this.clientId = clientId;
        this.numberId = numberId;
        this.phoneNumber = phoneNumber;
        this.agentId = agentId;
        this.campaignId = campaignId;
        this.processId = processId;
        this.wappMessage = wappMessage;
        this.messageSentId = messageSentId;
        this.messageState = messageState;
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

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getNumberId() {
        return numberId;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
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

    public OperationWappMessageDAO getWappMessage() {
        return wappMessage;
    }

    public void setWappMessage(OperationWappMessageDAO wappMessage) {
        this.wappMessage = wappMessage;
    }

    public String getMessageSentId() {
        return messageSentId;
    }

    public void setMessageSentId(String messageSentId) {
        this.messageSentId = messageSentId;
    }

    public String getMessageState() {
        return messageState;
    }

    public void setMessageState(String messageState) {
        this.messageState = messageState;
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
