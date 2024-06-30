package com.faas.core.base.model.ws.campaign.details.trigger;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.trigger.dto.CampaignAITriggerWSDTO;

import java.util.List;

public class CampaignAITriggerWSModel {

    private GeneralWSModel general;
    private List<CampaignAITriggerWSDTO>campaignAITriggers;

    public CampaignAITriggerWSModel() {
    }

    public CampaignAITriggerWSModel(GeneralWSModel general, List<CampaignAITriggerWSDTO> campaignAITriggers) {
        this.general = general;
        this.campaignAITriggers = campaignAITriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignAITriggerWSDTO> getCampaignAITriggers() {
        return campaignAITriggers;
    }

    public void setCampaignAITriggers(List<CampaignAITriggerWSDTO> campaignAITriggers) {
        this.campaignAITriggers = campaignAITriggers;
    }
}
