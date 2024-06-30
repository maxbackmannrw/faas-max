package com.faas.core.base.model.ws.campaign.details.channel.temp.dto;

import com.faas.core.base.model.db.campaign.details.channel.temp.SmsTempDBModel;

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
