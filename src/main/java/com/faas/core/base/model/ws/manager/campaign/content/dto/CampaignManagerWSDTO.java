package com.faas.core.base.model.ws.manager.campaign.content.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;

public class CampaignManagerWSDTO {

    private CampaignDBModel campaign;

    public CampaignManagerWSDTO() {
    }

    public CampaignManagerWSDTO(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }
}
