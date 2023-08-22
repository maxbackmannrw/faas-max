package com.faas.core.base.model.ws.dashboard.session.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;

public class DashboardSessionWSDTO {

    private CampaignDBModel campaign;

    public DashboardSessionWSDTO() {
    }

    public DashboardSessionWSDTO(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }
}
