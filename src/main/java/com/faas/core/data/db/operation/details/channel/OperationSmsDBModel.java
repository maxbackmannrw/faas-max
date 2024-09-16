package com.faas.core.data.db.operation.details.channel;

import com.faas.core.data.db.client.details.dao.ClientPhoneDAO;
import com.faas.core.data.db.operation.details.channel.dao.OperationSmsDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "operation_smss_table")
public class OperationSmsDBModel {

    @Id
    private String id;
    private long clientId;
    private String operationId;
    private long agentId;
    private String campaignId;
    private ClientPhoneDAO clientPhone;
    private OperationSmsDAO operationSms;
    private String smsSentId;
    private String smsState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationSmsDBModel() {
    }

    public OperationSmsDBModel(String id, long clientId, String operationId, long agentId, String campaignId, ClientPhoneDAO clientPhone, OperationSmsDAO operationSms, String smsSentId, String smsState, long uDate, long cDate, int status) {
        this.id = id;
        this.clientId = clientId;
        this.operationId = operationId;
        this.agentId = agentId;
        this.campaignId = campaignId;
        this.clientPhone = clientPhone;
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

    public OperationSmsDAO getOperationSms() {
        return operationSms;
    }

    public void setOperationSms(OperationSmsDAO operationSms) {
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
