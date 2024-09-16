package com.faas.core.data.ws.base.campaign.details.agent;

import com.faas.core.data.ws.base.campaign.details.agent.dto.CampaignAgentWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class CampaignAgentWSModel {

    private GeneralWSModel general;
    private List<CampaignAgentWSDTO> campaignAgents;

    public CampaignAgentWSModel() {
    }

    public CampaignAgentWSModel(GeneralWSModel general, List<CampaignAgentWSDTO> campaignAgents) {
        this.general = general;
        this.campaignAgents = campaignAgents;
    }


    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignAgentWSDTO> getCampaignAgents() {
        return campaignAgents;
    }

    public void setCampaignAgents(List<CampaignAgentWSDTO> campaignAgents) {
        this.campaignAgents = campaignAgents;
    }
}
