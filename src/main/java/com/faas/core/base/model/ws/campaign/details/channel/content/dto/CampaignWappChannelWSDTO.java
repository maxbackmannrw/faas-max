package com.faas.core.base.model.ws.campaign.details.channel.content.dto;

import com.faas.core.base.model.db.campaign.details.channel.content.dao.CampaignWappChannelDAO;

public class CampaignWappChannelWSDTO {

    private CampaignWappChannelDAO wappChannel;

    public CampaignWappChannelWSDTO() {
    }

    public CampaignWappChannelWSDTO(CampaignWappChannelDAO wappChannel) {
        this.wappChannel = wappChannel;
    }

    public CampaignWappChannelDAO getWappChannel() {
        return wappChannel;
    }

    public void setWappChannel(CampaignWappChannelDAO wappChannel) {
        this.wappChannel = wappChannel;
    }
}
