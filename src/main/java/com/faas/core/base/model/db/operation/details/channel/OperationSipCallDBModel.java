package com.faas.core.base.model.db.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.dao.OperationSipCallDAO;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document(collection = "operation_sip_call_table")
public class OperationSipCallDBModel {

    @Id
    private String id;
    private long clientId;
    private String operationId;
    private long agentId;
    private String campaignId;
    private OperationSipCallDAO sipCall;
    private String callConnId;
    private String callState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationSipCallDBModel() {
    }

    public OperationSipCallDBModel(String id, long clientId, String operationId, long agentId, String campaignId, OperationSipCallDAO sipCall, String callConnId, String callState, long uDate, long cDate, int status) {
        this.id = id;
        this.clientId = clientId;
        this.operationId = operationId;
        this.agentId = agentId;
        this.campaignId = campaignId;
        this.sipCall = sipCall;
        this.callConnId = callConnId;
        this.callState = callState;
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

    public OperationSipCallDAO getSipCall() {
        return sipCall;
    }

    public void setSipCall(OperationSipCallDAO sipCall) {
        this.sipCall = sipCall;
    }

    public String getCallConnId() {
        return callConnId;
    }

    public void setCallConnId(String callConnId) {
        this.callConnId = callConnId;
    }

    public String getCallState() {
        return callState;
    }

    public void setCallState(String callState) {
        this.callState = callState;
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
