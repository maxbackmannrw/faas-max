package com.faas.core.data.ws.api.campaign.content.dto;

import com.faas.core.data.db.campaign.content.CampaignDBModel;

public class ApiCampaignWSDTO {

    private CampaignDBModel campaign;
    private ApiAgentCampaignSummary campaignSummary;

    public ApiCampaignWSDTO() {
    }

    public ApiCampaignWSDTO(CampaignDBModel campaign, ApiAgentCampaignSummary campaignSummary) {
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
