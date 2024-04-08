package com.faas.core.base.model.db.operation.content;

import com.faas.core.base.model.db.operation.content.dao.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "operation_table")
public class OperationDBModel {

    @Id
    private String id;
    private long sessionId;
    private long clientId;
    private String clientName;
    private long agentId;
    private String agentName;
    private String campaignId;
    private String campaign;
    private String campaignType;
    private String campaignCategory;
    private String processId;
    private String process;
    private String processType;
    private String processCategory;
    private OperationInquiryDAO operationInquiry;
    private String operationInquiryState;
    private OperationFlowDAO operationFlow;
    private String operationFlowState;
    private List<OperationScenarioDAO>operationScenarios;
    private List<OperationActivityDAO>operationActivities;
    private List<OperationDataDAO>operationDatas;
    private String operationType;
    private String operationState;
    private String operationResult;
    private long uDate;
    private long cDate;
    private int status;

    public OperationDBModel() {
    }

    public OperationDBModel(String id, long sessionId, long clientId, String clientName, long agentId, String agentName, String campaignId, String campaign, String campaignType, String campaignCategory, String processId, String process, String processType, String processCategory, OperationInquiryDAO operationInquiry, String operationInquiryState, OperationFlowDAO operationFlow, String operationFlowState, List<OperationScenarioDAO> operationScenarios, List<OperationActivityDAO> operationActivities, List<OperationDataDAO> operationDatas, String operationType, String operationState, String operationResult, long uDate, long cDate, int status) {
        this.id = id;
        this.sessionId = sessionId;
        this.clientId = clientId;
        this.clientName = clientName;
        this.agentId = agentId;
        this.agentName = agentName;
        this.campaignId = campaignId;
        this.campaign = campaign;
        this.campaignType = campaignType;
        this.campaignCategory = campaignCategory;
        this.processId = processId;
        this.process = process;
        this.processType = processType;
        this.processCategory = processCategory;
        this.operationInquiry = operationInquiry;
        this.operationInquiryState = operationInquiryState;
        this.operationFlow = operationFlow;
        this.operationFlowState = operationFlowState;
        this.operationScenarios = operationScenarios;
        this.operationActivities = operationActivities;
        this.operationDatas = operationDatas;
        this.operationType = operationType;
        this.operationState = operationState;
        this.operationResult = operationResult;
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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

    public OperationInquiryDAO getOperationInquiry() {
        return operationInquiry;
    }

    public void setOperationInquiry(OperationInquiryDAO operationInquiry) {
        this.operationInquiry = operationInquiry;
    }

    public String getOperationInquiryState() {
        return operationInquiryState;
    }

    public void setOperationInquiryState(String operationInquiryState) {
        this.operationInquiryState = operationInquiryState;
    }

    public OperationFlowDAO getOperationFlow() {
        return operationFlow;
    }

    public void setOperationFlow(OperationFlowDAO operationFlow) {
        this.operationFlow = operationFlow;
    }

    public String getOperationFlowState() {
        return operationFlowState;
    }

    public void setOperationFlowState(String operationFlowState) {
        this.operationFlowState = operationFlowState;
    }

    public List<OperationScenarioDAO> getOperationScenarios() {
        return operationScenarios;
    }

    public void setOperationScenarios(List<OperationScenarioDAO> operationScenarios) {
        this.operationScenarios = operationScenarios;
    }

    public List<OperationActivityDAO> getOperationActivities() {
        return operationActivities;
    }

    public void setOperationActivities(List<OperationActivityDAO> operationActivities) {
        this.operationActivities = operationActivities;
    }

    public List<OperationDataDAO> getOperationDatas() {
        return operationDatas;
    }

    public void setOperationDatas(List<OperationDataDAO> operationDatas) {
        this.operationDatas = operationDatas;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationState() {
        return operationState;
    }

    public void setOperationState(String operationState) {
        this.operationState = operationState;
    }

    public String getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(String operationResult) {
        this.operationResult = operationResult;
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
