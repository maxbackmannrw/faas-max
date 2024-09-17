package com.faas.core.base.model.ws.campaign.details.scenario.dto;

import com.faas.core.data.db.campaign.details.scenario.CampaignScenarioDBModel;

public class CampaignScenarioWSDTO {

    private CampaignScenarioDBModel campaignScenario;

    public CampaignScenarioWSDTO() {
    }

    public CampaignScenarioWSDTO(CampaignScenarioDBModel campaignScenario) {
        this.campaignScenario = campaignScenario;
    }

    public CampaignScenarioDBModel getCampaignScenario() {
        return campaignScenario;
    }

    public void setCampaignScenario(CampaignScenarioDBModel campaignScenario) {
        this.campaignScenario = campaignScenario;
    }
}
