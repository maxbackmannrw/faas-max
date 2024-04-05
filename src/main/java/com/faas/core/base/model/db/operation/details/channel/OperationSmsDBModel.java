package com.faas.core.base.model.db.operation.details.channel;

import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.operation.details.channel.dao.OperationSmsDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "operation_sms_table")
public class OperationSmsDBModel {

    @Id
    private String id;
    private long clientId;
    private long sessionId;
    private String operationId;
    private long agentId;
    private String agentName;
    private String campaignId;
    private String campaign;
    private String processId;
    private String process;
    private ClientPhoneDAO clientPhone;
    private OperationSmsDAO operationSms;
    private String smsSentId;
    private String smsState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationSmsDBModel() {
    }

    public OperationSmsDBModel(String id, long clientId, long sessionId, String operationId, long agentId, String agentName, String campaignId, String campaign, String processId, String process, ClientPhoneDAO clientPhone, OperationSmsDAO operationSms, String smsSentId, String smsState, long uDate, long cDate, int status) {
        this.id = id;
        this.clientId = clientId;
        this.sessionId = sessionId;
        this.operationId = operationId;
        this.agentId = agentId;
        this.agentName = agentName;
        this.campaignId = campaignId;
        this.campaign = campaign;
        this.processId = processId;
        this.process = process;
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

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
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
