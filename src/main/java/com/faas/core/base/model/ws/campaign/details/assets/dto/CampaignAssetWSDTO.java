package com.faas.core.base.model.ws.campaign.details.assets.dto;

import com.faas.core.base.model.db.campaign.content.dao.CampaignAssetDAO;

public class CampaignAssetWSDTO {

    private CampaignAssetDAO campaignAsset;

    public CampaignAssetWSDTO() {
    }

    public CampaignAssetWSDTO(CampaignAssetDAO campaignAsset) {
        this.campaignAsset = campaignAsset;
    }

    public CampaignAssetDAO getCampaignAsset() {
        return campaignAsset;
    }

    public void setCampaignAsset(CampaignAssetDAO campaignAsset) {
        this.campaignAsset = campaignAsset;
    }
}
