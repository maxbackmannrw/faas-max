package com.faas.core.data.ws.base.campaign.details.channel.dto;

import com.faas.core.data.db.campaign.details.channel.dao.CampaignSipChannelDAO;

public class CampaignSipChannelWSDTO {

    private CampaignSipChannelDAO sipChannel;

    public CampaignSipChannelWSDTO() {
    }

    public CampaignSipChannelWSDTO(CampaignSipChannelDAO sipChannel) {
        this.sipChannel = sipChannel;
    }

    public CampaignSipChannelDAO getSipChannel() {
        return sipChannel;
    }

    public void setSipChannel(CampaignSipChannelDAO sipChannel) {
        this.sipChannel = sipChannel;
    }
}
