package com.faas.core.base.model.ws.campaign.details.channel.content.dto;

import com.faas.core.base.model.db.campaign.details.channel.content.dao.CampaignSipChannelDAO;

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
