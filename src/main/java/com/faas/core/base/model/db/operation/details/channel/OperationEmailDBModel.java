package com.faas.core.base.model.db.operation.details.channel;

import com.faas.core.base.model.db.client.details.content.dao.ClientEmailDAO;
import com.faas.core.base.model.db.operation.details.channel.dao.OperationEmailDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "operation_email_table")
public class OperationEmailDBModel {

    @Id
    private String id;
    private long clientId;
    private long sessionId;
    private String operationId;
    private long agentId;
    private String campaignId;
    private String processId;
    private ClientEmailDAO clientEmail;
    private OperationEmailDAO emailMessage;
    private String emailSentId;
    private String emailState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationEmailDBModel() {
    }

    public OperationEmailDBModel(String id, long clientId, long sessionId, String operationId, long agentId, String campaignId, String processId, ClientEmailDAO clientEmail, OperationEmailDAO emailMessage, String emailSentId, String emailState, long uDate, long cDate, int status) {
        this.id = id;
        this.clientId = clientId;
        this.sessionId = sessionId;
        this.operationId = operationId;
        this.agentId = agentId;
        this.campaignId = campaignId;
        this.processId = processId;
        this.clientEmail = clientEmail;
        this.emailMessage = emailMessage;
        this.emailSentId = emailSentId;
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

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
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

    public ClientEmailDAO getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(ClientEmailDAO clientEmail) {
        this.clientEmail = clientEmail;
    }

    public OperationEmailDAO getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(OperationEmailDAO emailMessage) {
        this.emailMessage = emailMessage;
    }

    public String getEmailSentId() {
        return emailSentId;
    }

    public void setEmailSentId(String emailSentId) {
        this.emailSentId = emailSentId;
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
