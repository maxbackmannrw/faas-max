package com.faas.core.base.model.ws.dashboard.operation.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;

public class DashboardOperationWSDTO {

    private CampaignDBModel campaign;

    public DashboardOperationWSDTO() {
    }

    public DashboardOperationWSDTO(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }
}
