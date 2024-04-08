package com.faas.core.base.model.db.operation.details.channel;

import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.operation.details.channel.dao.OperationSmsDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "operation_smss_table")
public class OperationSmsDBModel {

    @Id
    private String id;
    private long clientId;
    private String clientName;
    private long sessionId;
    private String operationId;
    private long agentId;
    private String campaignId;
    private String campaign;
    private String campaignType;
    private String campaignCategory;
    private String processId;
    private String process;
    private String processType;
    private String processCategory;
    private ClientPhoneDAO clientPhone;
    private OperationSmsDAO operationSms;
    private String smsSentId;
    private String smsState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationSmsDBModel() {
    }

    public OperationSmsDBModel(String id, long clientId, String clientName, long sessionId, String operationId, long agentId, String campaignId, String campaign, String campaignType, String campaignCategory, String processId, String process, String processType, String processCategory, ClientPhoneDAO clientPhone, OperationSmsDAO operationSms, String smsSentId, String smsState, long uDate, long cDate, int status) {
        this.id = id;
        this.clientId = clientId;
        this.clientName = clientName;
        this.sessionId = sessionId;
        this.operationId = operationId;
        this.agentId = agentId;
        this.campaignId = campaignId;
        this.campaign = campaign;
        this.campaignType = campaignType;
        this.campaignCategory = campaignCategory;
        this.processId = processId;
        this.process = process;
        this.processType = processType;
        this.processCategory = processCategory;
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public String getCampaignType() {
        return campaignType;
    }

    public void setCampaignType(String campaignType) {
        this.campaignType = campaignType;
    }

    public String getCampaignCategory() {
        return campaignCategory;
    }

    public void setCampaignCategory(String campaignCategory) {
        this.campaignCategory = campaignCategory;
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

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getProcessCategory() {
        return processCategory;
    }

    public void setProcessCategory(String processCategory) {
        this.processCategory = processCategory;
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
