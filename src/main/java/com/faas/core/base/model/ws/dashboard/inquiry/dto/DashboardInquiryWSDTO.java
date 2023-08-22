package com.faas.core.base.model.ws.dashboard.inquiry.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;

public class DashboardInquiryWSDTO {

    private CampaignDBModel campaign;

    public DashboardInquiryWSDTO() {
    }

    public DashboardInquiryWSDTO(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }
}
