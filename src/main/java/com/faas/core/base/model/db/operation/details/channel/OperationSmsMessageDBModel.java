package com.faas.core.base.model.db.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.dao.OperationSmsMessageDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "operation_sms_message_table")
public class OperationSmsMessageDBModel {

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
    private OperationSmsMessageDAO smsMessage;
    private String smsSentId;
    private String smsState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationSmsMessageDBModel() {
    }

    public OperationSmsMessageDBModel(String id, String operationId, long sessionId, long clientId, String numberId, String phoneNumber, long agentId, String campaignId, String processId, OperationSmsMessageDAO smsMessage, String smsSentId, String smsState, long uDate, long cDate, int status) {
        this.id = id;
        this.operationId = operationId;
        this.sessionId = sessionId;
        this.clientId = clientId;
        this.numberId = numberId;
        this.phoneNumber = phoneNumber;
        this.agentId = agentId;
        this.campaignId = campaignId;
        this.processId = processId;
        this.smsMessage = smsMessage;
        this.smsSentId = smsSentId;
        this.smsState = smsState;
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

    public OperationSmsMessageDAO getSmsMessage() {
        return smsMessage;
    }

    public void setSmsMessage(OperationSmsMessageDAO smsMessage) {
        this.smsMessage = smsMessage;
    }

    public String getSmsSentId() {
        return smsSentId;
    }

    public void setSmsSentId(String smsSentId) {
        this.smsSentId = smsSentId;
    }

    public String getSmsState() {
        return smsState;
    }

    public void setSmsState(String smsState) {
        this.smsState = smsState;
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
