package com.faas.core.data.ws.base.campaign.details.temp.details.dto;

import com.faas.core.data.db.campaign.details.temp.SmsTempDBModel;

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
