package com.faas.core.api.model.ws.operation.details.content.dto;

import com.faas.core.api.model.ws.operation.channel.content.dto.ApiOperationChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.outcome.dto.ApiOperationActivityWSDTO;
import com.faas.core.api.model.ws.operation.details.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.client.details.dto.ApiClientNoteWSDTO;
import com.faas.core.api.model.ws.client.details.dto.ApiClientOsIntWSDTO;
import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiOperationScenarioWSDTO;
import com.faas.core.base.model.db.client.flow.ClientFlowDBModel;
import com.faas.core.base.model.db.client.inquiry.ClientInquiryDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;

import java.util.List;

public class ApiOperationDetailsWSDTO {

    private OperationDBModel operation;
    private SessionDBModel operationSession;
    private ClientFlowDBModel operationFlow;
    private ClientInquiryDBModel operationInquiry;
    private ApiOperationClientWSDTO operationClient;
    private List<ApiClientOsIntWSDTO> clientOsInts;
    private List<ApiClientNoteWSDTO> clientNotes;
    private List<ApiOperationActivityWSDTO> operationActivities;
    private ApiOperationCampaignWSDTO operationCampaign;
    private ApiOperationChannelWSDTO operationChannel;
    private List<ApiOperationScenarioWSDTO> operationScenarios;

    public ApiOperationDetailsWSDTO() {
    }

    public ApiOperationDetailsWSDTO(OperationDBModel operation, SessionDBModel operationSession, ClientFlowDBModel operationFlow, ClientInquiryDBModel operationInquiry, ApiOperationClientWSDTO operationClient, List<ApiClientOsIntWSDTO> clientOsInts, List<ApiClientNoteWSDTO> clientNotes, List<ApiOperationActivityWSDTO> operationActivities, ApiOperationCampaignWSDTO operationCampaign, ApiOperationChannelWSDTO operationChannel, List<ApiOperationScenarioWSDTO> operationScenarios) {
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

    public ClientFlowDBModel getOperationFlow() {
        return operationFlow;
    }

    public void setOperationFlow(ClientFlowDBModel operationFlow) {
        this.operationFlow = operationFlow;
    }

    public ClientInquiryDBModel getOperationInquiry() {
        return operationInquiry;
    }

    public void setOperationInquiry(ClientInquiryDBModel operationInquiry) {
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
