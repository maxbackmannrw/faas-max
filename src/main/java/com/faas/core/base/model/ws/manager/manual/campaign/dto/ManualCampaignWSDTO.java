package com.faas.core.base.model.ws.manager.manual.campaign.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;

public class ManualCampaignWSDTO {

    private CampaignDBModel campaign;

    public ManualCampaignWSDTO() {
    }

    public ManualCampaignWSDTO(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }
}
