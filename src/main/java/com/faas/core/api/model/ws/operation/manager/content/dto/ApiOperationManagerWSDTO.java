package com.faas.core.api.model.ws.operation.manager.content.dto;

import com.faas.core.api.model.ws.operation.manager.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.manager.details.dto.ApiOperationCampaignWSDTO;
import com.faas.core.data.db.client.intel.ClientIntelDBModel;
import com.faas.core.data.db.operation.content.OperationDBModel;

import java.util.List;

public class ApiOperationManagerWSDTO {

    private OperationDBModel operation;
    private ApiOperationAgentWSDTO operationAgent;
    private ApiOperationClientWSDTO operationClient;
    private List<ClientIntelDBModel> operationClientIntels;
    private ApiOperationCampaignWSDTO operationCampaign;

    public ApiOperationManagerWSDTO() {
    }

    public ApiOperationManagerWSDTO(OperationDBModel operation, ApiOperationAgentWSDTO operationAgent, ApiOperationClientWSDTO operationClient, List<ClientIntelDBModel> operationClientIntels, ApiOperationCampaignWSDTO operationCampaign) {
        this.operation = operation;
        this.operationAgent = operationAgent;
        this.operationClient = operationClient;
        this.operationClientIntels = operationClientIntels;
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

    public ApiOperationClientWSDTO getOperationClient() {
        return operationClient;
    }

    public void setOperationClient(ApiOperationClientWSDTO operationClient) {
        this.operationClient = operationClient;
    }

    public List<ClientIntelDBModel> getOperationClientIntels() {
        return operationClientIntels;
    }

    public void setOperationClientIntels(List<ClientIntelDBModel> operationClientIntels) {
        this.operationClientIntels = operationClientIntels;
    }

    public ApiOperationCampaignWSDTO getOperationCampaign() {
        return operationCampaign;
    }

    public void setOperationCampaign(ApiOperationCampaignWSDTO operationCampaign) {
        this.operationCampaign = operationCampaign;
    }
}
