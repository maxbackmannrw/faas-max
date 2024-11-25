package com.faas.core.api.model.ws.operation.manager.content.dto;

import com.faas.core.api.model.ws.operation.manager.activity.dto.ApiOperationActivityWSDTO;
import com.faas.core.api.model.ws.operation.manager.details.dto.ApiOperationCampaignWSDTO;
import com.faas.core.api.model.ws.operation.manager.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.manager.intel.dto.ApiOperationIntelWSDTO;
import com.faas.core.data.db.operation.content.OperationDBModel;

import java.util.List;

public class ApiOperationManagerWSDTO {

    private OperationDBModel operation;
    private ApiOperationAgentWSDTO operationAgent;
    private ApiOperationClientWSDTO operationClient;
    private List<ApiOperationIntelWSDTO> operationIntels;
    private ApiOperationCampaignWSDTO operationCampaign;
    private List<ApiOperationActivityWSDTO>operationActivities;

    public ApiOperationManagerWSDTO() {
    }

    public ApiOperationManagerWSDTO(OperationDBModel operation, ApiOperationAgentWSDTO operationAgent, ApiOperationClientWSDTO operationClient, List<ApiOperationIntelWSDTO> operationIntels, ApiOperationCampaignWSDTO operationCampaign, List<ApiOperationActivityWSDTO> operationActivities) {
        this.operation = operation;
        this.operationAgent = operationAgent;
        this.operationClient = operationClient;
        this.operationIntels = operationIntels;
        this.operationCampaign = operationCampaign;
        this.operationActivities = operationActivities;
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

    public ApiOperationClientWSDTO getOperationClient() {
        return operationClient;
    }

    public void setOperationClient(ApiOperationClientWSDTO operationClient) {
        this.operationClient = operationClient;
    }

    public List<ApiOperationIntelWSDTO> getOperationIntels() {
        return operationIntels;
    }

    public void setOperationIntels(List<ApiOperationIntelWSDTO> operationIntels) {
        this.operationIntels = operationIntels;
    }

    public ApiOperationCampaignWSDTO getOperationCampaign() {
        return operationCampaign;
    }

    public void setOperationCampaign(ApiOperationCampaignWSDTO operationCampaign) {
        this.operationCampaign = operationCampaign;
    }

    public List<ApiOperationActivityWSDTO> getOperationActivities() {
        return operationActivities;
    }

    public void setOperationActivities(List<ApiOperationActivityWSDTO> operationActivities) {
        this.operationActivities = operationActivities;
    }
}
