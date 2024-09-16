package com.faas.core.data.ws.base.campaign.details.trigger.details.dto;

import com.faas.core.data.db.campaign.details.trigger.EmailTriggerDBModel;

public class CampaignEmailTriggerWSDTO {

    private EmailTriggerDBModel campaignEmailTrigger;

    public CampaignEmailTriggerWSDTO() {
    }

    public CampaignEmailTriggerWSDTO(EmailTriggerDBModel campaignEmailTrigger) {
        this.campaignEmailTrigger = campaignEmailTrigger;
    }

    public EmailTriggerDBModel getCampaignEmailTrigger() {
        return campaignEmailTrigger;
    }

    public void setCampaignEmailTrigger(EmailTriggerDBModel campaignEmailTrigger) {
        this.campaignEmailTrigger = campaignEmailTrigger;
    }
}
