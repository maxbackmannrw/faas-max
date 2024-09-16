package com.faas.core.data.ws.base.campaign.manager.content;

import com.faas.core.data.ws.base.campaign.manager.content.dto.CampaignManagerDetailsWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

public class CampaignManagerDetailsWSModel {

    private GeneralWSModel general;
    private CampaignManagerDetailsWSDTO campaignManagerDetails;

    public CampaignManagerDetailsWSModel() {
    }

    public CampaignManagerDetailsWSModel(GeneralWSModel general, CampaignManagerDetailsWSDTO campaignManagerDetails) {
        this.general = general;
        this.campaignManagerDetails = campaignManagerDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignManagerDetailsWSDTO getCampaignManagerDetails() {
        return campaignManagerDetails;
    }

    public void setCampaignManagerDetails(CampaignManagerDetailsWSDTO campaignManagerDetails) {
        this.campaignManagerDetails = campaignManagerDetails;
    }
}
