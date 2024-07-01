package com.faas.core.base.model.ws.campaign.details.channel.dto;

import com.faas.core.base.model.db.campaign.details.channel.dao.CampaignSmsChannelDAO;

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
