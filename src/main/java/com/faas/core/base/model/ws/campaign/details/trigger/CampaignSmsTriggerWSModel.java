package com.faas.core.base.model.ws.campaign.details.trigger;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.trigger.dto.CampaignSmsTriggerWSDTO;

import java.util.List;

public class CampaignSmsTriggerWSModel {

    private GeneralWSModel general;
    private List<CampaignSmsTriggerWSDTO>campaignSmsTriggers;

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
