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
    private long agentId;
    private String campaignId;
    private String processId;
    private OperationInquiryDAO operationInquiry;
    private String operationInquiryState;
    private OperationFlowDAO operationFlow;
    private String operationFlowState;
    private List<OperationScenarioDAO>operationScenarios;
    private List<OperationActivityDAO>operationActivities;
    private List<OperationDataDAO>operationDatas;
    private String operationOutcome;
    private String operationType;
    private String operationState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationDBModel() {
    }

    public OperationDBModel(String id, long sessionId, long clientId, long agentId, String campaignId, String processId, OperationInquiryDAO operationInquiry, String operationInquiryState, OperationFlowDAO operationFlow, String operationFlowState, List<OperationScenarioDAO> operationScenarios, List<OperationActivityDAO> operationActivities, List<OperationDataDAO> operationDatas, String operationOutcome, String operationType, String operationState, long uDate, long cDate, int status) {
        this.id = id;
        this.sessionId = sessionId;
        this.clientId = clientId;
        this.agentId = agentId;
        this.campaignId = campaignId;
        this.processId = processId;
        this.operationInquiry = operationInquiry;
        this.operationInquiryState = operationInquiryState;
        this.operationFlow = operationFlow;
        this.operationFlowState = operationFlowState;
        this.operationScenarios = operationScenarios;
        this.operationActivities = operationActivities;
        this.operationDatas = operationDatas;
        this.operationOutcome = operationOutcome;
        this.operationType = operationType;
        this.operationState = operationState;
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

    public String getOperationOutcome() {
        return operationOutcome;
    }

    public void setOperationOutcome(String operationOutcome) {
        this.operationOutcome = operationOutcome;
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
