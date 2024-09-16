package com.faas.core.data.ws.base.campaign.details.trigger.content;

import com.faas.core.data.ws.base.campaign.details.trigger.content.dto.CampaignTriggerWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

public class CampaignTriggerWSModel {

    private GeneralWSModel general;
    private CampaignTriggerWSDTO campaignTrigger;

    public CampaignTriggerWSModel() {
    }

    public CampaignTriggerWSModel(GeneralWSModel general, CampaignTriggerWSDTO campaignTrigger) {
        this.general = general;
        this.campaignTrigger = campaignTrigger;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignTriggerWSDTO getCampaignTrigger() {
        return campaignTrigger;
    }

    public void setCampaignTrigger(CampaignTriggerWSDTO campaignTrigger) {
        this.campaignTrigger = campaignTrigger;
    }
}
