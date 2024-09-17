package com.faas.core.base.model.ws.campaign.settings.dto;

import com.faas.core.data.db.campaign.settings.CampaignTypeDBModel;

public class CampaignTypeWSDTO {

    private CampaignTypeDBModel campaignType;

    public CampaignTypeWSDTO() {
    }

    public CampaignTypeWSDTO(CampaignTypeDBModel campaignType) {
        this.campaignType = campaignType;
    }

    public CampaignTypeDBModel getCampaignType() {
        return campaignType;
    }

    public void setCampaignType(CampaignTypeDBModel campaignType) {
        this.campaignType = campaignType;
    }
}
