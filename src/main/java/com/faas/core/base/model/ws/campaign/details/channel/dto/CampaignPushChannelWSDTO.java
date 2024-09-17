package com.faas.core.base.model.ws.campaign.details.channel.dto;

import com.faas.core.data.db.campaign.details.channel.dao.CampaignPushChannelDAO;

public class CampaignPushChannelWSDTO {

    private CampaignPushChannelDAO pushChannel;

    public CampaignPushChannelWSDTO() {
    }

    public CampaignPushChannelWSDTO(CampaignPushChannelDAO pushChannel) {
        this.pushChannel = pushChannel;
    }

    public CampaignPushChannelDAO getPushChannel() {
        return pushChannel;
    }

    public void setPushChannel(CampaignPushChannelDAO pushChannel) {
        this.pushChannel = pushChannel;
    }
}
