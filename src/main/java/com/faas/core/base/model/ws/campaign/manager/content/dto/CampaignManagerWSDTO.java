package com.faas.core.base.model.ws.campaign.manager.content.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;

public class CampaignManagerWSDTO {

    private CampaignDBModel campaign;
    private CampaignSummaryWSDTO campaignSummary;

    public CampaignManagerWSDTO() {
    }

    public CampaignManagerWSDTO(CampaignDBModel campaign, CampaignSummaryWSDTO campaignSummary) {
        this.campaign = campaign;
        this.campaignSummary = campaignSummary;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public CampaignSummaryWSDTO getCampaignSummary() {
        return campaignSummary;
    }

    public void setCampaignSummary(CampaignSummaryWSDTO campaignSummary) {
        this.campaignSummary = campaignSummary;
    }
}
