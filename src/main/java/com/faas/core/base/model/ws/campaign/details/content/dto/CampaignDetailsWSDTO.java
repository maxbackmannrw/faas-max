package com.faas.core.base.model.ws.campaign.details.content.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.ws.campaign.details.channel.dto.CampaignChannelWSDTO;
import com.faas.core.base.model.ws.campaign.details.temp.content.dto.CampaignTempWSDTO;
import com.faas.core.base.model.ws.campaign.details.remote.dto.CampaignRemoteWSDTO;
import com.faas.core.base.model.ws.campaign.details.scenario.dto.CampaignScenarioWSDTO;
import com.faas.core.base.model.ws.campaign.details.trigger.dto.CampaignTriggerWSDTO;

import java.util.List;

public class CampaignDetailsWSDTO {

    private CampaignDBModel campaign;
    private CampaignTempWSDTO campaignTemp;
    private CampaignChannelWSDTO campaignChannel;
    private CampaignTriggerWSDTO campaignTrigger;
    private List<CampaignScenarioWSDTO> campaignScenarios;
    private List<CampaignRemoteWSDTO> campaignRemotes;

    public CampaignDetailsWSDTO() {
    }

    public CampaignDetailsWSDTO(CampaignDBModel campaign, CampaignTempWSDTO campaignTemp, CampaignChannelWSDTO campaignChannel, CampaignTriggerWSDTO campaignTrigger, List<CampaignScenarioWSDTO> campaignScenarios, List<CampaignRemoteWSDTO> campaignRemotes) {
        this.campaign = campaign;
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