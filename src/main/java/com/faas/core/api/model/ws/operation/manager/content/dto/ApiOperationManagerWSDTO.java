package com.faas.core.api.model.ws.operation.manager.content.dto;

import com.faas.core.api.model.ws.operation.manager.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.user.details.dto.ApiAgentDetailsWSDTO;
import com.faas.core.data.db.operation.content.OperationDBModel;

public class ApiOperationManagerWSDTO {

    private OperationDBModel operation;
    private ApiAgentDetailsWSDTO operationAgent;
    private ApiOperationClientWSDTO operationClient;
    private ApiOperationCampaignWSDTO operationCampaign;

    public ApiOperationManagerWSDTO() {
    }

    public ApiOperationManagerWSDTO(OperationDBModel operation, ApiAgentDetailsWSDTO operationAgent, ApiOperationClientWSDTO operationClient, ApiOperationCampaignWSDTO operationCampaign) {
        this.operation = operation;
        this.operationAgent = operationAgent;
        this.operationClient = operationClient;
        this.operationCampaign = operationCampaign;
    }

    public OperationDBModel getOperation() {
        return operation;
    }

    public void setOperation(OperationDBModel operation) {
        this.operation = operation;
    }

    public ApiAgentDetailsWSDTO getOperationAgent() {
        return operationAgent;
    }

    public void setOperationAgent(ApiAgentDetailsWSDTO operationAgent) {
        this.operationAgent = operationAgent;
    }

    public ApiOperationClientWSDTO getOperationClient() {
        return operationClient;
    }

    public void setOperationClient(ApiOperationClientWSDTO operationClient) {
        this.operationClient = operationClient;
    }

    public ApiOperationCampaignWSDTO getOperationCampaign() {
        return operationCampaign;
    }

    public void setOperationCampaign(ApiOperationCampaignWSDTO operationCampaign) {
        this.operationCampaign = operationCampaign;
    }
}
