package com.faas.core.base.model.ws.campaign.details.temp.details.dto;

import com.faas.core.base.model.db.campaign.details.temp.SmsTempDBModel;

public class CampaignSmsTempWSDTO {

    private SmsTempDBModel campaignSmsTemp;

    public CampaignSmsTempWSDTO() {
    }

    public CampaignSmsTempWSDTO(SmsTempDBModel campaignSmsTemp) {
        this.campaignSmsTemp = campaignSmsTemp;
    }

    public SmsTempDBModel getCampaignSmsTemp() {
        return campaignSmsTemp;
    }

    public void setCampaignSmsTemp(SmsTempDBModel campaignSmsTemp) {
        this.campaignSmsTemp = campaignSmsTemp;
    }
}
