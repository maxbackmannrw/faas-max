package com.faas.core.base.model.ws.campaign.details.trigger.details.dto;

import com.faas.core.base.model.db.campaign.details.trigger.SipTriggerDBModel;

public class CampaignSipTriggerWSDTO {

    private SipTriggerDBModel campaignSipTrigger;

    public CampaignSipTriggerWSDTO() {
    }

    public CampaignSipTriggerWSDTO(SipTriggerDBModel campaignSipTrigger) {
        this.campaignSipTrigger = campaignSipTrigger;
    }

    public SipTriggerDBModel getCampaignSipTrigger() {
        return campaignSipTrigger;
    }

    public void setCampaignSipTrigger(SipTriggerDBModel campaignSipTrigger) {
        this.campaignSipTrigger = campaignSipTrigger;
    }
}
