package com.faas.core.api.model.ws.campaign.details.dto;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.data.db.campaign.details.remote.CampaignRemoteDBModel;

import java.util.List;

public class ApiCampaignDetailsWSDTO {

    private ApiCampaignWSDTO campaign;
    private List<CampaignRemoteDBModel> campaignRemotes;
    private ApiOperationListWSDTO readyOperation;
    private ApiOperationListWSDTO activeOperation;

    public ApiCampaignDetailsWSDTO() {
    }

    public ApiCampaignDetailsWSDTO(ApiCampaignWSDTO campaign, List<CampaignRemoteDBModel> campaignRemotes, ApiOperationListWSDTO readyOperation, ApiOperationListWSDTO activeOperation) {
        this.campaign = campaign;
        this.campaignRemotes = campaignRemotes;
        this.readyOperation = readyOperation;
        this.activeOperation = activeOperation;
    }

    public ApiCampaignWSDTO getCampaign() {
        return campaign;
    }

    public void setCampaign(ApiCampaignWSDTO campaign) {
        this.campaign = campaign;
    }

    public List<CampaignRemoteDBModel> getCampaignRemotes() {
        return campaignRemotes;
    }

    public void setCampaignRemotes(List<CampaignRemoteDBModel> campaignRemotes) {
        this.campaignRemotes = campaignRemotes;
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
