package com.faas.core.base.model.ws.campaign.details.assets;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.assets.dto.CampaignAssetWSDTO;

import java.util.List;

public class CampaignAssetWSModel {

    private GeneralWSModel general;
    private List<CampaignAssetWSDTO>campaignAssets;

    public CampaignAssetWSModel() {
    }

    public CampaignAssetWSModel(GeneralWSModel general, List<CampaignAssetWSDTO> campaignAssets) {
        this.general = general;
        this.campaignAssets = campaignAssets;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignAssetWSDTO> getCampaignAssets() {
        return campaignAssets;
    }

    public void setCampaignAssets(List<CampaignAssetWSDTO> campaignAssets) {
        this.campaignAssets = campaignAssets;
    }
}
