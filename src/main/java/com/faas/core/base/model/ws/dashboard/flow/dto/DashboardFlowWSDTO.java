package com.faas.core.base.model.ws.dashboard.flow.dto;

import com.faas.core.data.db.campaign.content.CampaignDBModel;

public class DashboardFlowWSDTO {

    private CampaignDBModel campaign;

    public DashboardFlowWSDTO() {
    }

    public DashboardFlowWSDTO(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }
}
