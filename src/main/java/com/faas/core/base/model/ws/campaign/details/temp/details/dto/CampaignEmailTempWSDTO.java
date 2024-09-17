package com.faas.core.base.model.ws.campaign.details.temp.details.dto;

import com.faas.core.data.db.campaign.details.temp.EmailTempDBModel;

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
