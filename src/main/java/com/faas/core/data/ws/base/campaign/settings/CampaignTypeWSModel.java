package com.faas.core.data.ws.base.campaign.settings;

import com.faas.core.data.ws.base.campaign.settings.dto.CampaignTypeWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

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
