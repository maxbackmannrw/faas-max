package com.faas.core.data.ws.base.campaign.details.channel.dto;

import com.faas.core.data.db.campaign.details.channel.dao.CampaignSmsChannelDAO;

public class CampaignSmsChannelWSDTO {

    private CampaignSmsChannelDAO smsChannel;

    public CampaignSmsChannelWSDTO() {
    }

    public CampaignSmsChannelWSDTO(CampaignSmsChannelDAO smsChannel) {
        this.smsChannel = smsChannel;
    }

    public CampaignSmsChannelDAO getSmsChannel() {
        return smsChannel;
    }

    public void setSmsChannel(CampaignSmsChannelDAO smsChannel) {
        this.smsChannel = smsChannel;
    }
}
