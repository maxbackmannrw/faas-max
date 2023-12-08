package com.faas.core.base.model.ws.manager.campaign.details.automatic;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.campaign.details.automatic.dto.AutomaticCampaignWSDTO;

import java.util.List;

public class AutomaticCampaignWSModel {

    private GeneralWSModel general;
    private List<AutomaticCampaignWSDTO>automaticCampaigns;

    public AutomaticCampaignWSModel() {
    }

    public AutomaticCampaignWSModel(GeneralWSModel general, List<AutomaticCampaignWSDTO> automaticCampaigns) {
        this.general = general;
        this.automaticCampaigns = automaticCampaigns;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<AutomaticCampaignWSDTO> getAutomaticCampaigns() {
        return automaticCampaigns;
    }

    public void setAutomaticCampaigns(List<AutomaticCampaignWSDTO> automaticCampaigns) {
        this.automaticCampaigns = automaticCampaigns;
    }
}
