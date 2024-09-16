package com.faas.core.data.ws.base.campaign.content;

import com.faas.core.data.ws.base.campaign.content.dto.CampaignWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class CampaignWSModel {

    private GeneralWSModel general;
    private List<CampaignWSDTO> campaigns;

    public CampaignWSModel() {
    }

    public CampaignWSModel(GeneralWSModel general, List<CampaignWSDTO> campaigns) {
        this.general = general;
        this.campaigns = campaigns;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignWSDTO> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<CampaignWSDTO> campaigns) {
        this.campaigns = campaigns;
    }
}
