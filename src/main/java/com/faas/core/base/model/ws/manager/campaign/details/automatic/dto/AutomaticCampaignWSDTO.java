package com.faas.core.base.model.ws.manager.campaign.details.automatic.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;

public class AutomaticCampaignWSDTO {

    private CampaignDBModel campaign;

    public AutomaticCampaignWSDTO() {
    }

    public AutomaticCampaignWSDTO(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }
}
