package com.faas.core.api.model.ws.operation.manager.details.dto;

import com.faas.core.data.db.campaign.content.CampaignDBModel;

public class ApiOperationCampaignWSDTO {

    private CampaignDBModel campaign;

    public ApiOperationCampaignWSDTO() {
    }

    public ApiOperationCampaignWSDTO(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }
}
