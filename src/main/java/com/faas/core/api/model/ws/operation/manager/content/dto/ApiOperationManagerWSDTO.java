package com.faas.core.api.model.ws.operation.manager.content.dto;

import com.faas.core.api.model.ws.operation.manager.activity.dto.ApiOperationActivityWSDTO;
import com.faas.core.api.model.ws.operation.manager.client.dto.ApiOperationClientWSDTO;
import com.faas.core.data.db.client.intel.ClientIntelDBModel;
import com.faas.core.data.db.operation.content.OperationDBModel;

import java.util.List;

public class ApiOperationManagerWSDTO {

    private OperationDBModel operation;
    private ApiOperationAgentWSDTO operationAgent;
    private List<ApiOperationActivityWSDTO>operationActivities;
    private ApiOperationClientWSDTO operationClient;
    private List<ClientIntelDBModel> operationIntels;
    private ApiOperationCampaignWSDTO operationCampaign;

    public ApiOperationManagerWSDTO() {
    }

    public ApiOperationManagerWSDTO(OperationDBModel operation, ApiOperationAgentWSDTO operationAgent, List<ApiOperationActivityWSDTO> operationActivities, ApiOperationClientWSDTO operationClient, List<ClientIntelDBModel> operationIntels, ApiOperationCampaignWSDTO operationCampaign) {
        this.operation = operation;
        this.operationAgent = operationAgent;
        this.operationActivities = operationActivities;
        this.operationClient = operationClient;
        this.operationIntels = operationIntels;
        this.operationCampaign = operationCampaign;
    }

    public OperationDBModel getOperation() {
        return operation;
    }

    public void setOperation(OperationDBModel operation) {
        this.operation = operation;
    }

    public ApiOperationAgentWSDTO getOperationAgent() {
        return operationAgent;
    }

    public void setOperationAgent(ApiOperationAgentWSDTO operationAgent) {
        this.operationAgent = operationAgent;
    }

    public List<ApiOperationActivityWSDTO> getOperationActivities() {
        return operationActivities;
    }

    public void setOperationActivities(List<ApiOperationActivityWSDTO> operationActivities) {
        this.operationActivities = operationActivities;
    }

    public ApiOperationClientWSDTO getOperationClient() {
        return operationClient;
    }

    public void setOperationClient(ApiOperationClientWSDTO operationClient) {
        this.operationClient = operationClient;
    }

    public List<ClientIntelDBModel> getOperationIntels() {
        return operationIntels;
    }

    public void setOperationIntels(List<ClientIntelDBModel> operationIntels) {
        this.operationIntels = operationIntels;
    }

    public ApiOperationCampaignWSDTO getOperationCampaign() {
        return operationCampaign;
    }

    public void setOperationCampaign(ApiOperationCampaignWSDTO operationCampaign) {
        this.operationCampaign = operationCampaign;
    }
}
