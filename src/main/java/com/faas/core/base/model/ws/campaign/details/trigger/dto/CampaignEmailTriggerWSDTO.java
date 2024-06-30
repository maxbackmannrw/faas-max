package com.faas.core.base.model.ws.campaign.details.trigger.dto;

import com.faas.core.base.model.db.campaign.details.trigger.EmailTriggerDBModel;

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
