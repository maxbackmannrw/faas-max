package com.faas.core.base.model.ws.campaign.details.channel.temp.dto;

import com.faas.core.base.model.db.campaign.details.channel.temp.EmailTempDBModel;

public class CampaignEmailTempWSDTO {

    private EmailTempDBModel campaignEmailTemp;

    public CampaignEmailTempWSDTO() {
    }

    public CampaignEmailTempWSDTO(EmailTempDBModel campaignEmailTemp) {
        this.campaignEmailTemp = campaignEmailTemp;
    }

    public EmailTempDBModel getCampaignEmailTemp() {
        return campaignEmailTemp;
    }

    public void setCampaignEmailTemp(EmailTempDBModel campaignEmailTemp) {
        this.campaignEmailTemp = campaignEmailTemp;
    }
}
