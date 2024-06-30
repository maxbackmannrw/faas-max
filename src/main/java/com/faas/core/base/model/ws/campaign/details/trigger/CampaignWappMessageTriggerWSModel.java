package com.faas.core.base.model.ws.campaign.details.trigger;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.trigger.dto.CampaignWappMessageTriggerWSDTO;

import java.util.List;

public class CampaignWappMessageTriggerWSModel {

    private GeneralWSModel general;
    private List<CampaignWappMessageTriggerWSDTO>campaignWappMessageTriggers;

    public CampaignWappMessageTriggerWSModel() {
    }

    public CampaignWappMessageTriggerWSModel(GeneralWSModel general, List<CampaignWappMessageTriggerWSDTO> campaignWappMessageTriggers) {
        this.general = general;
        this.campaignWappMessageTriggers = campaignWappMessageTriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignWappMessageTriggerWSDTO> getCampaignWappMessageTriggers() {
        return campaignWappMessageTriggers;
    }

    public void setCampaignWappMessageTriggers(List<CampaignWappMessageTriggerWSDTO> campaignWappMessageTriggers) {
        this.campaignWappMessageTriggers = campaignWappMessageTriggers;
    }
}
