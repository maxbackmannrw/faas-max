package com.faas.core.base.model.ws.manager.inquiry.campaign.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;

public class InquiryCampaignWSDTO {

    private CampaignDBModel campaign;

    public InquiryCampaignWSDTO() {
    }

    public InquiryCampaignWSDTO(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }
}
