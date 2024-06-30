package com.faas.core.base.model.db.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.dao.OperationPushDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "operation_push_table")
public class OperationPushDBModel {

    @Id
    private String id;
    private long clientId;
    private String operationId;
    private long agentId;
    private String campaignId;
    private OperationPushDAO pushMessage;
    private String pushSentId;
    private String pushState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationPushDBModel() {
    }

    public OperationPushDBModel(String id, long clientId, String operationId, long agentId, String campaignId, OperationPushDAO pushMessage, String pushSentId, String pushState, long uDate, long cDate, int status) {
        this.id = id;
        this.clientId = clientId;
        this.operationId = operationId;
        this.agentId = agentId;
        this.campaignId = campaignId;
        this.pushMessage = pushMessage;
        this.pushSentId = pushSentId;
        this.pushState = pushState;
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

    public OperationPushDAO getPushMessage() {
        return pushMessage;
    }

    public void setPushMessage(OperationPushDAO pushMessage) {
        this.pushMessage = pushMessage;
    }

    public String getPushSentId() {
        return pushSentId;
    }

    public void setPushSentId(String pushSentId) {
        this.pushSentId = pushSentId;
    }

    public String getPushState() {
        return pushState;
    }

    public void setPushState(String pushState) {
        this.pushState = pushState;
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
