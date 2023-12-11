package com.faas.core.base.model.ws.manager.campaign.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;

import java.util.List;

public class CampaignManagerWSModel {

    private GeneralWSModel general;
    private List<CampaignManagerWSDTO> campaignManagers;

    public CampaignManagerWSModel() {
    }

    public CampaignManagerWSModel(GeneralWSModel general, List<CampaignManagerWSDTO> campaignManagers) {
        this.general = general;
        this.campaignManagers = campaignManagers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignManagerWSDTO> getCampaignManagers() {
        return campaignManagers;
    }

    public void setCampaignManagers(List<CampaignManagerWSDTO> campaignManagers) {
        this.campaignManagers = campaignManagers;
    }
}
