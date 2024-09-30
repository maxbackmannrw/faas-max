package com.faas.core.api.model.ws.operation.manager.content.dto;

import com.faas.core.api.model.ws.operation.manager.channel.content.dto.ApiOperationCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.manager.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.manager.channel.content.dto.ApiOperationMessageChannelWSDTO;
import com.faas.core.data.db.operation.content.OperationDBModel;

public class ApiOperationManagerWSDTO {

    private OperationDBModel operation;
    private ApiOperationClientWSDTO operationClient;
    private ApiOperationCampaignWSDTO operationCampaign;
    private ApiOperationCallChannelWSDTO operationCallChannel;
    private ApiOperationMessageChannelWSDTO operationMessageChannel;

    public ApiOperationManagerWSDTO() {
    }

    public ApiOperationManagerWSDTO(OperationDBModel operation, ApiOperationClientWSDTO operationClient, ApiOperationCampaignWSDTO operationCampaign, ApiOperationCallChannelWSDTO operationCallChannel, ApiOperationMessageChannelWSDTO operationMessageChannel) {
        this.operation = operation;
        this.operationClient = operationClient;
        this.operationCampaign = operationCampaign;
        this.operationCallChannel = operationCallChannel;
        this.operationMessageChannel = operationMessageChannel;
    }

    public OperationDBModel getOperation() {
        return operation;
    }

    public void setOperation(OperationDBModel operation) {
        this.operation = operation;
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

    public ApiOperationCallChannelWSDTO getOperationCallChannel() {
        return operationCallChannel;
    }

    public void setOperationCallChannel(ApiOperationCallChannelWSDTO operationCallChannel) {
        this.operationCallChannel = operationCallChannel;
    }

    public ApiOperationMessageChannelWSDTO getOperationMessageChannel() {
        return operationMessageChannel;
    }

    public void setOperationMessageChannel(ApiOperationMessageChannelWSDTO operationMessageChannel) {
        this.operationMessageChannel = operationMessageChannel;
    }
}
