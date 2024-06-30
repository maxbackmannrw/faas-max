package com.faas.core.base.model.ws.campaign.details.channel.temp;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.channel.temp.dto.CampaignTempWSDTO;

public class CampaignTempWSModel {

    private GeneralWSModel general;
    private CampaignTempWSDTO campaignTemp;

    public CampaignTempWSModel() {
    }

    public CampaignTempWSModel(GeneralWSModel general, CampaignTempWSDTO campaignTemp) {
        this.general = general;
        this.campaignTemp = campaignTemp;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignTempWSDTO getCampaignTemp() {
        return campaignTemp;
    }

    public void setCampaignTemp(CampaignTempWSDTO campaignTemp) {
        this.campaignTemp = campaignTemp;
    }
}
