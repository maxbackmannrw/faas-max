package com.faas.core.base.model.ws.manager.campaign.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;


public class CampaignManagerWSModel {

    private GeneralWSModel general;
    private CampaignManagerWSDTO campaignManager;

    public CampaignManagerWSModel() {
    }

    public CampaignManagerWSModel(GeneralWSModel general, CampaignManagerWSDTO campaignManager) {
        this.general = general;
        this.campaignManager = campaignManager;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignManagerWSDTO getCampaignManager() {
        return campaignManager;
    }

    public void setCampaignManager(CampaignManagerWSDTO campaignManager) {
        this.campaignManager = campaignManager;
    }
}
