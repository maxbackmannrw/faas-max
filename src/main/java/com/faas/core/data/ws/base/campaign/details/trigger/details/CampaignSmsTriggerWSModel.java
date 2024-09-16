package com.faas.core.data.ws.base.campaign.details.trigger.details;

import com.faas.core.data.ws.base.campaign.details.trigger.details.dto.CampaignSmsTriggerWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class CampaignSmsTriggerWSModel {

    private GeneralWSModel general;
    private List<CampaignSmsTriggerWSDTO> campaignSmsTriggers;

    public CampaignSmsTriggerWSModel() {
    }

    public CampaignSmsTriggerWSModel(GeneralWSModel general, List<CampaignSmsTriggerWSDTO> campaignSmsTriggers) {
        this.general = general;
        this.campaignSmsTriggers = campaignSmsTriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignSmsTriggerWSDTO> getCampaignSmsTriggers() {
        return campaignSmsTriggers;
    }

    public void setCampaignSmsTriggers(List<CampaignSmsTriggerWSDTO> campaignSmsTriggers) {
        this.campaignSmsTriggers = campaignSmsTriggers;
    }
}
