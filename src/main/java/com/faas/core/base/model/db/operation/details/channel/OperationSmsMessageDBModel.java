package com.faas.core.base.model.db.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.dao.OperationSmsMessageDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "operation_sms_message_table")
public class OperationSmsMessageDBModel {

    @Id
    private String id;
    private long clientId;
    private long sessionId;
    private String operationId;
    private long agentId;
    private String campaignId;
    private String processId;
    private String numberId;
    private String phoneNumber;
    private String phoneCarrier;
    private String phoneType;
    private OperationSmsMessageDAO operationSms;
    private String smsSentId;
    private String smsState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationSmsMessageDBModel() {
    }

    public OperationSmsMessageDBModel(String id, long clientId, long sessionId, String operationId, long agentId, String campaignId, String processId, String numberId, String phoneNumber, String phoneCarrier, String phoneType, OperationSmsMessageDAO operationSms, String smsSentId, String smsState, long uDate, long cDate, int status) {
        this.id = id;
        this.clientId = clientId;
        this.sessionId = sessionId;
        this.operationId = operationId;
        this.agentId = agentId;
        this.campaignId = campaignId;
        this.processId = processId;
        this.numberId = numberId;
        this.phoneNumber = phoneNumber;
        this.phoneCarrier = phoneCarrier;
        this.phoneType = phoneType;
        this.operationSms = operationSms;
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

    public String getPhoneCarrier() {
        return phoneCarrier;
    }

    public void setPhoneCarrier(String phoneCarrier) {
        this.phoneCarrier = phoneCarrier;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public OperationSmsMessageDAO getOperationSms() {
        return operationSms;
    }

    public void setOperationSms(OperationSmsMessageDAO operationSms) {
        this.operationSms = operationSms;
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
