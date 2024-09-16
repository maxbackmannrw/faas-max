package com.faas.core.data.ws.base.campaign.details.trigger.details;

import com.faas.core.data.ws.base.campaign.details.trigger.details.dto.CampaignEmailTriggerWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class CampaignEmailTriggerWSModel {

    private GeneralWSModel general;
    private List<CampaignEmailTriggerWSDTO> campaignEmailTriggers;

    public CampaignEmailTriggerWSModel() {
    }

    public CampaignEmailTriggerWSModel(GeneralWSModel general, List<CampaignEmailTriggerWSDTO> campaignEmailTriggers) {
        this.general = general;
        this.campaignEmailTriggers = campaignEmailTriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignEmailTriggerWSDTO> getCampaignEmailTriggers() {
        return campaignEmailTriggers;
    }

    public void setCampaignEmailTriggers(List<CampaignEmailTriggerWSDTO> campaignEmailTriggers) {
        this.campaignEmailTriggers = campaignEmailTriggers;
    }
}
