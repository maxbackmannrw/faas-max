package com.faas.core.base.model.ws.operation.automatic.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.automatic.details.dto.AutomaticCampaignWSDTO;

import java.util.List;

public class AutomaticCampaignWSModel {

    private GeneralWSModel general;
    private List<AutomaticCampaignWSDTO>campaigns;

    public AutomaticCampaignWSModel() {
    }

    public AutomaticCampaignWSModel(GeneralWSModel general, List<AutomaticCampaignWSDTO> campaigns) {
        this.general = general;
        this.campaigns = campaigns;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<AutomaticCampaignWSDTO> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<AutomaticCampaignWSDTO> campaigns) {
        this.campaigns = campaigns;
    }
}
