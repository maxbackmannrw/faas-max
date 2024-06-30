package com.faas.core.base.model.ws.campaign.settings;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.settings.dto.CampaignTypeWSDTO;

import java.util.List;

public class CampaignTypeWSModel {

    private GeneralWSModel general;
    private List<CampaignTypeWSDTO> campaignTypes;

    public CampaignTypeWSModel() {
    }

    public CampaignTypeWSModel(GeneralWSModel general, List<CampaignTypeWSDTO> campaignTypes) {
        this.general = general;
        this.campaignTypes = campaignTypes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignTypeWSDTO> getCampaignTypes() {
        return campaignTypes;
    }

    public void setCampaignTypes(List<CampaignTypeWSDTO> campaignTypes) {
        this.campaignTypes = campaignTypes;
    }
}
