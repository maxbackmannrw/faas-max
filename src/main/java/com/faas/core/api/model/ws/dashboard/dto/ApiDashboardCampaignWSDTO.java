package com.faas.core.api.model.ws.dashboard.dto;

import com.faas.core.api.model.ws.campaign.content.dto.ApiAgentCampaignSummary;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;

public class ApiDashboardCampaignWSDTO {

    private CampaignDBModel campaign;
    private ApiAgentCampaignSummary campaignSummary;

    public ApiDashboardCampaignWSDTO() {
    }

    public ApiDashboardCampaignWSDTO(CampaignDBModel campaign, ApiAgentCampaignSummary campaignSummary) {
        this.campaign = campaign;
        this.campaignSummary = campaignSummary;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public ApiAgentCampaignSummary getCampaignSummary() {
        return campaignSummary;
    }

    public void setCampaignSummary(ApiAgentCampaignSummary campaignSummary) {
        this.campaignSummary = campaignSummary;
    }
}
