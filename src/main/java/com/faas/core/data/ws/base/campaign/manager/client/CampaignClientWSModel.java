package com.faas.core.data.ws.base.campaign.manager.client;

import com.faas.core.data.ws.base.campaign.manager.client.dto.CampaignClientWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

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
