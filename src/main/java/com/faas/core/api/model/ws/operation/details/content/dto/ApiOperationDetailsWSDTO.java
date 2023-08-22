package com.faas.core.api.model.ws.operation.details.content.dto;

import com.faas.core.api.model.ws.operation.channel.content.dto.ApiOperationChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.activity.dto.ApiOperationActivityWSDTO;
import com.faas.core.api.model.ws.operation.details.client.content.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.details.client.note.dto.ApiClientNoteWSDTO;
import com.faas.core.api.model.ws.operation.details.client.osint.dto.ApiClientOsIntWSDTO;
import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiOperationScenarioWSDTO;
import com.faas.core.base.model.db.flow.FlowDBModel;
import com.faas.core.base.model.db.inquiry.InquiryDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;

import java.util.List;

public class ApiOperationDetailsWSDTO {

    private OperationDBModel operation;
    private FlowDBModel operationFlow;
    private InquiryDBModel operationInquiry;
    private SessionDBModel operationSession;
    private ApiOperationClientWSDTO operationClient;
    private List<ApiClientOsIntWSDTO> clientOsInts;
    private List<ApiClientNoteWSDTO> clientNotes;
    private List<ApiOperationActivityWSDTO> operationActivities;
    private ApiOperationCampaignWSDTO operationCampaign;
    private ApiOperationScenarioWSDTO operationScenario;
    private ApiOperationChannelWSDTO operationChannel;

    public ApiOperationDetailsWSDTO() {
    }

    public ApiOperationDetailsWSDTO(OperationDBModel operation, SessionDBModel operationSession, FlowDBModel operationFlow, InquiryDBModel operationInquiry, ApiOperationClientWSDTO operationClient, List<ApiClientOsIntWSDTO> clientOsInts, List<ApiClientNoteWSDTO> clientNotes, List<ApiOperationActivityWSDTO> operationActivities, ApiOperationCampaignWSDTO operationCampaign, ApiOperationScenarioWSDTO operationScenario, ApiOperationChannelWSDTO operationChannel) {
        this.operation = operation;
        this.operationSession = operationSession;
        this.operationFlow = operationFlow;
        this.operationInquiry = operationInquiry;
        this.operationClient = operationClient;
        this.clientOsInts = clientOsInts;
        this.clientNotes = clientNotes;
        this.operationActivities = operationActivities;
        this.operationCampaign = operationCampaign;
        this.operationScenario = operationScenario;
        this.operationChannel = operationChannel;
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

    public FlowDBModel getOperationFlow() {
        return operationFlow;
    }

    public void setOperationFlow(FlowDBModel operationFlow) {
        this.operationFlow = operationFlow;
    }

    public InquiryDBModel getOperationInquiry() {
        return operationInquiry;
    }

    public void setOperationInquiry(InquiryDBModel operationInquiry) {
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

    public ApiOperationScenarioWSDTO getOperationScenario() {
        return operationScenario;
    }

    public void setOperationScenario(ApiOperationScenarioWSDTO operationScenario) {
        this.operationScenario = operationScenario;
    }

    public ApiOperationChannelWSDTO getOperationChannel() {
        return operationChannel;
    }

    public void setOperationChannel(ApiOperationChannelWSDTO operationChannel) {
        this.operationChannel = operationChannel;
    }

}
