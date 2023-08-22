package com.faas.core.base.model.ws.dashboard.content.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;

public class DashboardWSDTO {

    private CampaignDBModel campaign;

    public DashboardWSDTO() {
    }

    public DashboardWSDTO(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }
}
