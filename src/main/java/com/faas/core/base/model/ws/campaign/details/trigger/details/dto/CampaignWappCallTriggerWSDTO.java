package com.faas.core.base.model.ws.campaign.details.trigger.details.dto;

import com.faas.core.data.db.campaign.details.trigger.WappCallTriggerDBModel;

public class CampaignWappCallTriggerWSDTO {

    private WappCallTriggerDBModel campaignWappCallTrigger;

    public CampaignWappCallTriggerWSDTO() {
    }

    public CampaignWappCallTriggerWSDTO(WappCallTriggerDBModel campaignWappCallTrigger) {
        this.campaignWappCallTrigger = campaignWappCallTrigger;
    }

    public WappCallTriggerDBModel getCampaignWappCallTrigger() {
        return campaignWappCallTrigger;
    }

    public void setCampaignWappCallTrigger(WappCallTriggerDBModel campaignWappCallTrigger) {
        this.campaignWappCallTrigger = campaignWappCallTrigger;
    }
}
