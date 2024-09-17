package com.faas.core.base.model.ws.campaign.details.trigger.details;

import com.faas.core.base.model.ws.campaign.details.trigger.details.dto.CampaignWappCallTriggerWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class CampaignWappCallTriggerWSModel {

    private GeneralWSModel general;
    private List<CampaignWappCallTriggerWSDTO> campaignWappCallTriggers;

    public CampaignWappCallTriggerWSModel() {
    }

    public CampaignWappCallTriggerWSModel(GeneralWSModel general, List<CampaignWappCallTriggerWSDTO> campaignWappCallTriggers) {
        this.general = general;
        this.campaignWappCallTriggers = campaignWappCallTriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignWappCallTriggerWSDTO> getCampaignWappCallTriggers() {
        return campaignWappCallTriggers;
    }

    public void setCampaignWappCallTriggers(List<CampaignWappCallTriggerWSDTO> campaignWappCallTriggers) {
        this.campaignWappCallTriggers = campaignWappCallTriggers;
    }
}
