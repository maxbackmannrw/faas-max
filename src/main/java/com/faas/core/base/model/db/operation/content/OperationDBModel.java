package com.faas.core.base.model.db.operation.content;

import com.faas.core.base.model.db.operation.content.dao.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "operation_table")
public class OperationDBModel {

    @Id
    private String id;
    private long clientId;
    private String clientName;
    private String nationalId;
    private String phoneNumber;
    private String emailAddress;
    private String clientCity;
    private String clientCountry;
    private String clientType;
    private long agentId;
    private String agentName;
    private String campaignId;
    private String campaign;
    private String campaignType;
    private String campaignCategory;
    private OperationInquiryDAO inquiry;
    private String inquiryState;
    private OperationFlowDAO flow;
    private String flowState;
    private List<OperationActivityDAO>activities;
    private List<OperationScenarioDAO>scenarios;
    private List<OperationDataDAO>datas;
    private String operationType;
    private String operationResult;
    private String operationState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationDBModel() {
    }

    public OperationDBModel(String id, long clientId, String clientName, String nationalId, String phoneNumber, String emailAddress, String clientCity, String clientCountry, String clientType, long agentId, String agentName, String campaignId, String campaign, String campaignType, String campaignCategory, OperationInquiryDAO inquiry, String inquiryState, OperationFlowDAO flow, String flowState, List<OperationActivityDAO> activities, List<OperationScenarioDAO> scenarios, List<OperationDataDAO> datas, String operationType, String operationResult, String operationState, long uDate, long cDate, int status) {
        this.id = id;
        this.clientId = clientId;
        this.clientName = clientName;
        this.nationalId = nationalId;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.clientCity = clientCity;
        this.clientCountry = clientCountry;
        this.clientType = clientType;
        this.agentId = agentId;
        this.agentName = agentName;
        this.campaignId = campaignId;
        this.campaign = campaign;
        this.campaignType = campaignType;
        this.campaignCategory = campaignCategory;
        this.inquiry = inquiry;
        this.inquiryState = inquiryState;
        this.flow = flow;
        this.flowState = flowState;
        this.activities = activities;
        this.scenarios = scenarios;
        this.datas = datas;
        this.operationType = operationType;
        this.operationResult = operationResult;
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

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getClientCity() {
        return clientCity;
    }

    public void setClientCity(String clientCity) {
        this.clientCity = clientCity;
    }

    public String getClientCountry() {
        return clientCountry;
    }

    public void setClientCountry(String clientCountry) {
        this.clientCountry = clientCountry;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
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

    public OperationInquiryDAO getInquiry() {
        return inquiry;
    }

    public void setInquiry(OperationInquiryDAO inquiry) {
        this.inquiry = inquiry;
    }

    public String getInquiryState() {
        return inquiryState;
    }

    public void setInquiryState(String inquiryState) {
        this.inquiryState = inquiryState;
    }

    public OperationFlowDAO getFlow() {
        return flow;
    }

    public void setFlow(OperationFlowDAO flow) {
        this.flow = flow;
    }

    public String getFlowState() {
        return flowState;
    }

    public void setFlowState(String flowState) {
        this.flowState = flowState;
    }

    public List<OperationActivityDAO> getActivities() {
        return activities;
    }

    public void setActivities(List<OperationActivityDAO> activities) {
        this.activities = activities;
    }

    public List<OperationScenarioDAO> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<OperationScenarioDAO> scenarios) {
        this.scenarios = scenarios;
    }

    public List<OperationDataDAO> getDatas() {
        return datas;
    }

    public void setDatas(List<OperationDataDAO> datas) {
        this.datas = datas;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(String operationResult) {
        this.operationResult = operationResult;
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
