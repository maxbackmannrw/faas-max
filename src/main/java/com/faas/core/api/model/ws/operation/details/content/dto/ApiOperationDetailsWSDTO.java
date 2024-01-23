package com.faas.core.api.model.ws.operation.details.content.dto;

import com.faas.core.api.model.ws.operation.details.campaign.content.dto.ApiOperationCampaignWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.content.dto.ApiOperationChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.client.content.dto.ApiOperationClientWSDTO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;

public class ApiOperationDetailsWSDTO {

    private OperationDBModel operation;
    private SessionDBModel operationSession;
    private ApiOperationClientWSDTO operationClient;
    private ApiOperationCampaignWSDTO operationCampaign;
    private ApiOperationChannelWSDTO operationChannel;

    public ApiOperationDetailsWSDTO() {
    }

    public ApiOperationDetailsWSDTO(OperationDBModel operation, SessionDBModel operationSession, ApiOperationClientWSDTO operationClient, ApiOperationCampaignWSDTO operationCampaign, ApiOperationChannelWSDTO operationChannel) {
        this.operation = operation;
        this.operationSession = operationSession;
        this.operationClient = operationClient;
        this.operationCampaign = operationCampaign;
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

    public ApiOperationChannelWSDTO getOperationChannel() {
        return operationChannel;
    }

    public void setOperationChannel(ApiOperationChannelWSDTO operationChannel) {
        this.operationChannel = operationChannel;
    }
}
