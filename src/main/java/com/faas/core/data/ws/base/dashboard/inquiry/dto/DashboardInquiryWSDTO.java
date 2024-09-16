package com.faas.core.data.ws.base.dashboard.inquiry.dto;

import com.faas.core.data.db.campaign.content.CampaignDBModel;

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
