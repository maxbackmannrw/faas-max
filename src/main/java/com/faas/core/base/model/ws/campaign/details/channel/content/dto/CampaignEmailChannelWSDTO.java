package com.faas.core.base.model.ws.campaign.details.channel.content.dto;

import com.faas.core.base.model.db.campaign.details.channel.content.dao.CampaignEmailChannelDAO;

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
