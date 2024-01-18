package com.faas.core.api.model.ws.campaign.details.dto;

import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;


public class ApiCampaignDetailsWSDTO {

    private CampaignDBModel campaign;
    private ApiCampaignProcessWSDTO campaignProcess;
    private ApiOperationListWSDTO readyOperation;
    private ApiOperationListWSDTO activeOperation;

    public ApiCampaignDetailsWSDTO() {
    }

    public ApiCampaignDetailsWSDTO(CampaignDBModel campaign, ApiCampaignProcessWSDTO campaignProcess, ApiOperationListWSDTO readyOperation, ApiOperationListWSDTO activeOperation) {
        this.campaign = campaign;
        this.campaignProcess = campaignProcess;
        this.readyOperation = readyOperation;
        this.activeOperation = activeOperation;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public ApiCampaignProcessWSDTO getCampaignProcess() {
        return campaignProcess;
    }

    public void setCampaignProcess(ApiCampaignProcessWSDTO campaignProcess) {
        this.campaignProcess = campaignProcess;
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
