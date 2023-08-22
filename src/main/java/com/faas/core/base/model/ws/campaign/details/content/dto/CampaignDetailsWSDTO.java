package com.faas.core.base.model.ws.campaign.details.content.dto;


import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.ws.campaign.details.agent.dto.CampaignAgentWSDTO;

import java.util.List;

public class CampaignDetailsWSDTO {

    private CampaignDBModel campaign;
    private List<CampaignAgentWSDTO> campaignAgents;
    private CampaignProcessWSDTO campaignProcess;


    public CampaignDetailsWSDTO() {
    }

    public CampaignDetailsWSDTO(CampaignDBModel campaign, List<CampaignAgentWSDTO> campaignAgents, CampaignProcessWSDTO campaignProcess) {
        this.campaign = campaign;
        this.campaignAgents = campaignAgents;
        this.campaignProcess = campaignProcess;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public List<CampaignAgentWSDTO> getCampaignAgents() {
        return campaignAgents;
    }

    public void setCampaignAgents(List<CampaignAgentWSDTO> campaignAgents) {
        this.campaignAgents = campaignAgents;
    }

    public CampaignProcessWSDTO getCampaignProcess() {
        return campaignProcess;
    }

    public void setCampaignProcess(CampaignProcessWSDTO campaignProcess) {
        this.campaignProcess = campaignProcess;
    }
}
