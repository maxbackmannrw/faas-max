package com.faas.core.api.model.ws.campaign.details.dto;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;

public class ApiCampaignDetailsWSDTO {

    private ApiCampaignWSDTO campaign;
    private ApiOperationListWSDTO readyOperation;
    private ApiOperationListWSDTO activeOperation;

    public ApiCampaignDetailsWSDTO() {
    }

    public ApiCampaignDetailsWSDTO(ApiCampaignWSDTO campaign, ApiOperationListWSDTO readyOperation, ApiOperationListWSDTO activeOperation) {
        this.campaign = campaign;
        this.readyOperation = readyOperation;
        this.activeOperation = activeOperation;
    }

    public ApiCampaignWSDTO getCampaign() {
        return campaign;
    }

    public void setCampaign(ApiCampaignWSDTO campaign) {
        this.campaign = campaign;
    }

    public ApiOperationListWSDTO getReadyOperation() {
        return readyOperation;
    }

    public void setReadyOperation(ApiOperationListWSDTO readyOperation) {
        this.readyOperation = readyOperation;
    }

    public ApiOperationListWSDTO getActiveOperation() {
        return activeOperation;
    }

    public void setActiveOperation(ApiOperationListWSDTO activeOperation) {
        this.activeOperation = activeOperation;
    }
}
