package com.faas.core.api.model.ws.operation.details.content.dto;

import com.faas.core.api.model.ws.operation.details.campaign.dto.ApiOperationCampaignWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.content.dto.ApiOperationCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.content.dto.ApiOperationMessageChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.client.content.dto.ApiOperationClientWSDTO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;

public class ApiOperationDetailsWSDTO {

    private OperationDBModel operation;
    private SessionDBModel operationSession;
    private ApiOperationClientWSDTO operationClient;
    private ApiOperationCampaignWSDTO operationCampaign;
    private ApiOperationCallChannelWSDTO operationCallChannel;
    private ApiOperationMessageChannelWSDTO operationMessageChannel;

    public ApiOperationDetailsWSDTO() {
    }

    public ApiOperationDetailsWSDTO(OperationDBModel operation, SessionDBModel operationSession, ApiOperationClientWSDTO operationClient, ApiOperationCampaignWSDTO operationCampaign, ApiOperationCallChannelWSDTO operationCallChannel, ApiOperationMessageChannelWSDTO operationMessageChannel) {
        this.operation = operation;
        this.operationSession = operationSession;
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
