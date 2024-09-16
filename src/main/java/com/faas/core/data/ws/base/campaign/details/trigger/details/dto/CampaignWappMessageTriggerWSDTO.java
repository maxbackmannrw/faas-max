package com.faas.core.data.ws.base.campaign.details.trigger.details.dto;

import com.faas.core.data.db.campaign.details.trigger.WappMessageTriggerDBModel;

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
