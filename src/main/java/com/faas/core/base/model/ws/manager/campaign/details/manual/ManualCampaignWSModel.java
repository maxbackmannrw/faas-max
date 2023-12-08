package com.faas.core.base.model.ws.manager.campaign.details.manual;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.campaign.details.manual.dto.ManualCampaignWSDTO;

import java.util.List;

public class ManualCampaignWSModel {

    private GeneralWSModel general;
    private List<ManualCampaignWSDTO>manualCampaigns;

    public ManualCampaignWSModel() {
    }

    public ManualCampaignWSModel(GeneralWSModel general, List<ManualCampaignWSDTO> manualCampaigns) {
        this.general = general;
        this.manualCampaigns = manualCampaigns;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ManualCampaignWSDTO> getManualCampaigns() {
        return manualCampaigns;
    }

    public void setManualCampaigns(List<ManualCampaignWSDTO> manualCampaigns) {
        this.manualCampaigns = manualCampaigns;
    }
}
