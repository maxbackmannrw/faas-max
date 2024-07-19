package com.faas.core.base.model.ws.campaign.details.trigger.details.dto;

import com.faas.core.base.model.db.campaign.details.trigger.AITriggerDBModel;

public class CampaignAITriggerWSDTO {

    private AITriggerDBModel campaignAITrigger;

    public CampaignAITriggerWSDTO() {
    }

    public CampaignAITriggerWSDTO(AITriggerDBModel campaignAITrigger) {
        this.campaignAITrigger = campaignAITrigger;
    }

    public AITriggerDBModel getCampaignAITrigger() {
        return campaignAITrigger;
    }

    public void setCampaignAITrigger(AITriggerDBModel campaignAITrigger) {
        this.campaignAITrigger = campaignAITrigger;
    }
}
