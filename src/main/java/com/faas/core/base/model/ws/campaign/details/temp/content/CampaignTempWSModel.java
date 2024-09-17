package com.faas.core.base.model.ws.campaign.details.temp.content;

import com.faas.core.base.model.ws.campaign.details.temp.content.dto.CampaignTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

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
