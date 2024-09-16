package com.faas.core.data.ws.base.dashboard.operation.dto;

import com.faas.core.data.db.campaign.content.CampaignDBModel;

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
