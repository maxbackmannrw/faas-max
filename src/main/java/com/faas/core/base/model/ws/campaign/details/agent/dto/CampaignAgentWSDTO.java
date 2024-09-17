package com.faas.core.base.model.ws.campaign.details.agent.dto;

import com.faas.core.data.db.campaign.details.agent.CampaignAgentDBModel;
import com.faas.core.data.db.user.content.UserDBModel;

public class CampaignAgentWSDTO {

    private UserDBModel agentUser;
    private CampaignAgentDBModel campaignAgent;

    public CampaignAgentWSDTO() {
    }

    public CampaignAgentWSDTO(UserDBModel agentUser, CampaignAgentDBModel campaignAgent) {
        this.agentUser = agentUser;
        this.campaignAgent = campaignAgent;
    }

    public UserDBModel getAgentUser() {
        return agentUser;
    }

    public void setAgentUser(UserDBModel agentUser) {
        this.agentUser = agentUser;
    }

    public CampaignAgentDBModel getCampaignAgent() {
        return campaignAgent;
    }

    public void setCampaignAgent(CampaignAgentDBModel campaignAgent) {
        this.campaignAgent = campaignAgent;
    }
}
