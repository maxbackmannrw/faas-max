package com.faas.core.base.model.ws.campaign.details.trigger.details.dto;

import com.faas.core.base.model.db.campaign.details.trigger.SmsTriggerDBModel;

public class CampaignSmsTriggerWSDTO {

    private SmsTriggerDBModel campaignSmsTrigger;

    public CampaignSmsTriggerWSDTO() {
    }

    public CampaignSmsTriggerWSDTO(SmsTriggerDBModel campaignSmsTrigger) {
        this.campaignSmsTrigger = campaignSmsTrigger;
    }

    public SmsTriggerDBModel getCampaignSmsTrigger() {
        return campaignSmsTrigger;
    }

    public void setCampaignSmsTrigger(SmsTriggerDBModel campaignSmsTrigger) {
        this.campaignSmsTrigger = campaignSmsTrigger;
    }
}
