package com.faas.core.base.model.ws.campaign.details.channel.temp.dto;

import com.faas.core.base.model.db.campaign.details.channel.temp.PushTempDBModel;

public class CampaignPushTempWSDTO {

    private PushTempDBModel campaignPushTemp;

    public CampaignPushTempWSDTO() {
    }

    public CampaignPushTempWSDTO(PushTempDBModel campaignPushTemp) {
        this.campaignPushTemp = campaignPushTemp;
    }

    public PushTempDBModel getCampaignPushTemp() {
        return campaignPushTemp;
    }

    public void setCampaignPushTemp(PushTempDBModel campaignPushTemp) {
        this.campaignPushTemp = campaignPushTemp;
    }
}
