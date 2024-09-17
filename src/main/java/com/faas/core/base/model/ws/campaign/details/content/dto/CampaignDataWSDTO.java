package com.faas.core.base.model.ws.campaign.details.content.dto;

import com.faas.core.data.db.campaign.content.dao.CampaignDataDAO;

public class CampaignDataWSDTO {

    private CampaignDataDAO campaignData;

    public CampaignDataWSDTO() {
    }

    public CampaignDataWSDTO(CampaignDataDAO campaignData) {
        this.campaignData = campaignData;
    }

    public CampaignDataDAO getCampaignData() {
        return campaignData;
    }

    public void setCampaignData(CampaignDataDAO campaignData) {
        this.campaignData = campaignData;
    }
}
