package com.faas.core.base.model.ws.manager.manual.campaign;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.manual.campaign.dto.ManualCampaignWSDTO;

import java.util.List;

public class ManualCampaignWSModel {

    private GeneralWSModel general;
    private List<ManualCampaignWSDTO>campaigns;

    public ManualCampaignWSModel() {
    }

    public ManualCampaignWSModel(GeneralWSModel general, List<ManualCampaignWSDTO> campaigns) {
        this.general = general;
        this.campaigns = campaigns;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ManualCampaignWSDTO> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<ManualCampaignWSDTO> campaigns) {
        this.campaigns = campaigns;
    }
}
