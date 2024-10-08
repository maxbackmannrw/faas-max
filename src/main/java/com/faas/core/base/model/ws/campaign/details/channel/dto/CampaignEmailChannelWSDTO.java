package com.faas.core.base.model.ws.campaign.details.channel.dto;

import com.faas.core.data.db.campaign.details.channel.dao.CampaignEmailChannelDAO;

public class CampaignEmailChannelWSDTO {

    private CampaignEmailChannelDAO emailChannel;

    public CampaignEmailChannelWSDTO() {
    }

    public CampaignEmailChannelWSDTO(CampaignEmailChannelDAO emailChannel) {
        this.emailChannel = emailChannel;
    }

    public CampaignEmailChannelDAO getEmailChannel() {
        return emailChannel;
    }

    public void setEmailChannel(CampaignEmailChannelDAO emailChannel) {
        this.emailChannel = emailChannel;
    }
}
