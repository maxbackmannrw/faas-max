package com.faas.core.base.model.db.operation.details.channel;

import com.faas.core.base.model.db.client.details.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.operation.details.channel.dao.OperationWappMessageDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "operation_wapp_message_table")
public class OperationWappMessageDBModel {

    @Id
    private String id;
    private long clientId;
    private String operationId;
    private long agentId;
    private String campaignId;
    private ClientPhoneDAO clientPhone;
    private OperationWappMessageDAO operationWappMessage;
    private String messageSentId;
    private String messageState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationWappMessageDBModel() {
    }

    public OperationWappMessageDBModel(String id, long clientId, String operationId, long agentId, String campaignId, ClientPhoneDAO clientPhone, OperationWappMessageDAO operationWappMessage, String messageSentId, String messageState, long uDate, long cDate, int status) {
        this.id = id;
        this.clientId = clientId;
        this.operationId = operationId;
        this.agentId = agentId;
        this.campaignId = campaignId;
        this.clientPhone = clientPhone;
        this.operationWappMessage = operationWappMessage;
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

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
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

    public ClientPhoneDAO getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(ClientPhoneDAO clientPhone) {
        this.clientPhone = clientPhone;
    }

    public OperationWappMessageDAO getOperationWappMessage() {
        return operationWappMessage;
    }

    public void setOperationWappMessage(OperationWappMessageDAO operationWappMessage) {
        this.operationWappMessage = operationWappMessage;
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
