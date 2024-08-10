package com.faas.core.base.model.ws.campaign.manager.details.content.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.ws.campaign.details.agent.dto.CampaignAgentWSDTO;
import com.faas.core.base.model.ws.campaign.details.channel.dto.CampaignChannelWSDTO;
import com.faas.core.base.model.ws.campaign.details.remote.dto.CampaignRemoteWSDTO;
import com.faas.core.base.model.ws.campaign.details.scenario.dto.CampaignScenarioWSDTO;
import com.faas.core.base.model.ws.campaign.details.temp.content.dto.CampaignTempWSDTO;
import com.faas.core.base.model.ws.campaign.details.trigger.content.dto.CampaignTriggerWSDTO;
import com.faas.core.base.model.ws.campaign.manager.content.dto.CampaignSummaryWSDTO;

import java.util.List;

public class CampaignManagerDetailsWSDTO {

    private CampaignDBModel campaign;
    private CampaignSummaryWSDTO campaignSummary;
    private List<CampaignAgentWSDTO> campaignAgents;
    private CampaignTempWSDTO campaignTemp;
    private CampaignChannelWSDTO campaignChannel;
    private CampaignTriggerWSDTO campaignTrigger;
    private List<CampaignScenarioWSDTO> campaignScenarios;
    private List<CampaignRemoteWSDTO> campaignRemotes;

    public CampaignManagerDetailsWSDTO() {
    }

    public CampaignManagerDetailsWSDTO(CampaignDBModel campaign, CampaignSummaryWSDTO campaignSummary, List<CampaignAgentWSDTO> campaignAgents, CampaignTempWSDTO campaignTemp, CampaignChannelWSDTO campaignChannel, CampaignTriggerWSDTO campaignTrigger, List<CampaignScenarioWSDTO> campaignScenarios, List<CampaignRemoteWSDTO> campaignRemotes) {
        this.campaign = campaign;
        this.campaignSummary = campaignSummary;
        this.campaignAgents = campaignAgents;
        this.campaignTemp = campaignTemp;
        this.campaignChannel = campaignChannel;
        this.campaignTrigger = campaignTrigger;
        this.campaignScenarios = campaignScenarios;
        this.campaignRemotes = campaignRemotes;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public CampaignSummaryWSDTO getCampaignSummary() {
        return campaignSummary;
    }

    public void setCampaignSummary(CampaignSummaryWSDTO campaignSummary) {
        this.campaignSummary = campaignSummary;
    }

    public List<CampaignAgentWSDTO> getCampaignAgents() {
        return campaignAgents;
    }

    public void setCampaignAgents(List<CampaignAgentWSDTO> campaignAgents) {
        this.campaignAgents = campaignAgents;
    }

    public CampaignTempWSDTO getCampaignTemp() {
        return campaignTemp;
    }

    public void setCampaignTemp(CampaignTempWSDTO campaignTemp) {
        this.campaignTemp = campaignTemp;
    }

    public CampaignChannelWSDTO getCampaignChannel() {
        return campaignChannel;
    }

    public void setCampaignChannel(CampaignChannelWSDTO campaignChannel) {
        this.campaignChannel = campaignChannel;
    }

    public CampaignTriggerWSDTO getCampaignTrigger() {
        return campaignTrigger;
    }

    public void setCampaignTrigger(CampaignTriggerWSDTO campaignTrigger) {
        this.campaignTrigger = campaignTrigger;
    }

    public List<CampaignScenarioWSDTO> getCampaignScenarios() {
        return campaignScenarios;
    }

    public void setCampaignScenarios(List<CampaignScenarioWSDTO> campaignScenarios) {
        this.campaignScenarios = campaignScenarios;
    }

    public List<CampaignRemoteWSDTO> getCampaignRemotes() {
        return campaignRemotes;
    }

    public void setCampaignRemotes(List<CampaignRemoteWSDTO> campaignRemotes) {
        this.campaignRemotes = campaignRemotes;
    }
}