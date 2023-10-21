package com.faas.core.api.model.ws.operation.details.content.dto;

import com.faas.core.api.model.ws.flow.content.dto.ApiFlowWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.api.model.ws.operation.channel.content.dto.ApiOperationChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.activity.dto.ApiOperationActivityWSDTO;
import com.faas.core.api.model.ws.operation.details.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.client.details.dto.ApiClientNoteWSDTO;
import com.faas.core.api.model.ws.client.details.dto.ApiClientOsIntWSDTO;
import com.faas.core.api.model.ws.operation.details.scenario.dto.ApiOperationScenarioWSDTO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;

import java.util.List;

public class ApiOperationDetailsWSDTO {

    private OperationDBModel operation;
    private SessionDBModel operationSession;
    private ApiFlowWSDTO operationFlow;
    private ApiInquiryWSDTO operationInquiry;
    private ApiOperationClientWSDTO operationClient;
    private List<ApiClientOsIntWSDTO> clientOsInts;
    private List<ApiClientNoteWSDTO> clientNotes;
    private List<ApiOperationActivityWSDTO> operationActivities;
    private ApiOperationCampaignWSDTO operationCampaign;
    private ApiOperationChannelWSDTO operationChannel;
    private List<ApiOperationScenarioWSDTO> operationScenarios;

    public ApiOperationDetailsWSDTO() {
    }

    public ApiOperationDetailsWSDTO(OperationDBModel operation, SessionDBModel operationSession, ApiFlowWSDTO operationFlow, ApiInquiryWSDTO operationInquiry, ApiOperationClientWSDTO operationClient, List<ApiClientOsIntWSDTO> clientOsInts, List<ApiClientNoteWSDTO> clientNotes, List<ApiOperationActivityWSDTO> operationActivities, ApiOperationCampaignWSDTO operationCampaign, ApiOperationChannelWSDTO operationChannel, List<ApiOperationScenarioWSDTO> operationScenarios) {
        this.operation = operation;
        this.operationSession = operationSession;
        this.operationFlow = operationFlow;
        this.operationInquiry = operationInquiry;
        this.operationClient = operationClient;
        this.clientOsInts = clientOsInts;
        this.clientNotes = clientNotes;
        this.operationActivities = operationActivities;
        this.operationCampaign = operationCampaign;
        this.operationChannel = operationChannel;
        this.operationScenarios = operationScenarios;
    }

    public OperationDBModel getOperation() {
        return operation;
    }

    public void setOperation(OperationDBModel operation) {
        this.operation = operation;
    }

    public SessionDBModel getOperationSession() {
        return operationSession;
    }

    public void setOperationSession(SessionDBModel operationSession) {
        this.operationSession = operationSession;
    }

    public ApiFlowWSDTO getOperationFlow() {
        return operationFlow;
    }

    public void setOperationFlow(ApiFlowWSDTO operationFlow) {
        this.operationFlow = operationFlow;
    }

    public ApiInquiryWSDTO getOperationInquiry() {
        return operationInquiry;
    }

    public void setOperationInquiry(ApiInquiryWSDTO operationInquiry) {
        this.operationInquiry = operationInquiry;
    }

    public ApiOperationClientWSDTO getOperationClient() {
        return operationClient;
    }

    public void setOperationClient(ApiOperationClientWSDTO operationClient) {
        this.operationClient = operationClient;
    }

    public List<ApiClientOsIntWSDTO> getClientOsInts() {
        return clientOsInts;
    }

    public void setClientOsInts(List<ApiClientOsIntWSDTO> clientOsInts) {
        this.clientOsInts = clientOsInts;
    }

    public List<ApiClientNoteWSDTO> getClientNotes() {
        return clientNotes;
    }

    public void setClientNotes(List<ApiClientNoteWSDTO> clientNotes) {
        this.clientNotes = clientNotes;
    }

    public List<ApiOperationActivityWSDTO> getOperationActivities() {
        return operationActivities;
    }

    public void setOperationActivities(List<ApiOperationActivityWSDTO> operationActivities) {
        this.operationActivities = operationActivities;
    }

    public ApiOperationCampaignWSDTO getOperationCampaign() {
        return operationCampaign;
    }

    public void setOperationCampaign(ApiOperationCampaignWSDTO operationCampaign) {
        this.operationCampaign = operationCampaign;
    }

    public ApiOperationChannelWSDTO getOperationChannel() {
        return operationChannel;
    }

    public void setOperationChannel(ApiOperationChannelWSDTO operationChannel) {
        this.operationChannel = operationChannel;
    }

    public List<ApiOperationScenarioWSDTO> getOperationScenarios() {
        return operationScenarios;
    }

    public void setOperationScenarios(List<ApiOperationScenarioWSDTO> operationScenarios) {
        this.operationScenarios = operationScenarios;
    }
}
