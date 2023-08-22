package com.faas.core.base.model.ws.campaign.details.agent.dto;

import com.faas.core.base.model.db.user.content.UserDBModel;

public class CampaignAgentWSDTO {

    private UserDBModel campaignAgent;

    public CampaignAgentWSDTO() {
    }

    public CampaignAgentWSDTO(UserDBModel campaignAgent) {
        this.campaignAgent = campaignAgent;
    }

    public UserDBModel getCampaignAgent() {
        return campaignAgent;
    }

    public void setCampaignAgent(UserDBModel campaignAgent) {
        this.campaignAgent = campaignAgent;
    }
}
