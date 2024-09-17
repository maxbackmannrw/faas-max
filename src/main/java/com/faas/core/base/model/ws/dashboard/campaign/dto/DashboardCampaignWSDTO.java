package com.faas.core.base.model.ws.dashboard.campaign.dto;

import com.faas.core.data.db.campaign.content.CampaignDBModel;

public class DashboardCampaignWSDTO {

    private CampaignDBModel campaign;

    public DashboardCampaignWSDTO() {
    }

    public DashboardCampaignWSDTO(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }
}
