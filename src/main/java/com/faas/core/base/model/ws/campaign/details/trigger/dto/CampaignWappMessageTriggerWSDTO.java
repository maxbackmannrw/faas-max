package com.faas.core.base.model.ws.campaign.details.trigger.dto;

import com.faas.core.base.model.db.campaign.details.trigger.WappMessageTriggerDBModel;

public class CampaignWappMessageTriggerWSDTO {

    private WappMessageTriggerDBModel campaignWappMessageTrigger;

    public CampaignWappMessageTriggerWSDTO() {
    }

    public CampaignWappMessageTriggerWSDTO(WappMessageTriggerDBModel campaignWappMessageTrigger) {
        this.campaignWappMessageTrigger = campaignWappMessageTrigger;
    }

    public WappMessageTriggerDBModel getCampaignWappMessageTrigger() {
        return campaignWappMessageTrigger;
    }

    public void setCampaignWappMessageTrigger(WappMessageTriggerDBModel campaignWappMessageTrigger) {
        this.campaignWappMessageTrigger = campaignWappMessageTrigger;
    }
}
