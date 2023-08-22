package com.faas.core.base.model.ws.campaign.details.client.content;

import com.faas.core.base.model.ws.campaign.details.client.content.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class CampaignClientWSModel {

    private GeneralWSModel general;
    private CampaignClientWSDTO campaignClient;

    public CampaignClientWSModel() {
    }

    public CampaignClientWSModel(GeneralWSModel general, CampaignClientWSDTO campaignClient) {
        this.general = general;
        this.campaignClient = campaignClient;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignClientWSDTO getCampaignClient() {
        return campaignClient;
    }

    public void setCampaignClient(CampaignClientWSDTO campaignClient) {
        this.campaignClient = campaignClient;
    }
}
