package com.faas.core.data.ws.base.campaign.content.dto;

import com.faas.core.data.db.campaign.content.CampaignDBModel;

public class CampaignWSDTO {

    private CampaignDBModel campaign;

    public CampaignWSDTO() {
    }

    public CampaignWSDTO(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }
}
