package com.faas.core.base.model.ws.campaign.manager.details.dto;


import com.faas.core.base.model.db.campaign.content.CampaignDBModel;

public class CampaignManagerDetailsWSDTO {

    private CampaignDBModel campaign;

    public CampaignManagerDetailsWSDTO() {
    }

    public CampaignManagerDetailsWSDTO(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }
}
