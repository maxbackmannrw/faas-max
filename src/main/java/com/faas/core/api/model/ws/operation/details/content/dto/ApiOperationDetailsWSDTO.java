package com.faas.core.api.model.ws.operation.details.content.dto;

import com.faas.core.api.model.ws.operation.details.channel.content.dto.ApiOperationChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.activity.dto.ApiOperationActivityWSDTO;
import com.faas.core.api.model.ws.operation.details.client.content.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.details.client.note.dto.ApiOperationNoteWSDTO;
import com.faas.core.api.model.ws.operation.details.client.osint.dto.ApiOperationOSINTWSDTO;
import com.faas.core.api.model.ws.operation.details.scenario.dto.ApiOperationScenarioWSDTO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;

import java.util.List;

public class ApiOperationDetailsWSDTO {

    private OperationDBModel operation;
    private SessionDBModel operationSession;
    private ApiOperationClientWSDTO operationClient;
    private List<ApiOperationOSINTWSDTO> clientOsInts;
    private List<ApiOperationNoteWSDTO> clientNotes;
    private List<ApiOperationActivityWSDTO> operationActivities;
    private ApiOperationCampaignWSDTO operationCampaign;
    private ApiOperationChannelWSDTO operationChannel;
    private List<ApiOperationScenarioWSDTO> operationScenarios;

    public ApiOperationDetailsWSDTO() {
    }

    public ApiOperationDetailsWSDTO(OperationDBModel operation, SessionDBModel operationSession, ApiOperationClientWSDTO operationClient, List<ApiOperationOSINTWSDTO> clientOsInts, List<ApiOperationNoteWSDTO> clientNotes, List<ApiOperationActivityWSDTO> operationActivities, ApiOperationCampaignWSDTO operationCampaign, ApiOperationChannelWSDTO operationChannel, List<ApiOperationScenarioWSDTO> operationScenarios) {
        this.operation = operation;
        this.operationSession = operationSession;
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

    public ApiOperationClientWSDTO getOperationClient() {
        return operationClient;
    }

    public void setOperationClient(ApiOperationClientWSDTO operationClient) {
        this.operationClient = operationClient;
    }

    public List<ApiOperationOSINTWSDTO> getClientOsInts() {
        return clientOsInts;
    }

    public void setClientOsInts(List<ApiOperationOSINTWSDTO> clientOsInts) {
        this.clientOsInts = clientOsInts;
    }

    public List<ApiOperationNoteWSDTO> getClientNotes() {
        return clientNotes;
    }

    public void setClientNotes(List<ApiOperationNoteWSDTO> clientNotes) {
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
