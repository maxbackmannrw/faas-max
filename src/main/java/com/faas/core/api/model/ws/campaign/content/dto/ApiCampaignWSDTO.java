package com.faas.core.api.model.ws.campaign.content.dto;

import com.faas.core.data.db.campaign.content.CampaignDBModel;

public class ApiCampaignWSDTO {

    private CampaignDBModel campaign;
    private ApiCampaignSummary campaignSummary;

    public ApiCampaignWSDTO() {
    }

    public ApiCampaignWSDTO(CampaignDBModel campaign, ApiCampaignSummary campaignSummary) {
        this.campaign = campaign;
        this.campaignSummary = campaignSummary;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public ApiCampaignSummary getCampaignSummary() {
        return campaignSummary;
    }

    public void setCampaignSummary(ApiCampaignSummary campaignSummary) {
        this.campaignSummary = campaignSummary;
    }
}
