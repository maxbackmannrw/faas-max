package com.faas.core.api.model.ws.campaign.details.dto;

import com.faas.core.data.db.campaign.details.scenario.CampaignScenarioDBModel;

public class ApiCampaignScenarioWSDTO {

    private CampaignScenarioDBModel campaignScenario;

    public ApiCampaignScenarioWSDTO() {
    }

    public ApiCampaignScenarioWSDTO(CampaignScenarioDBModel campaignScenario) {
        this.campaignScenario = campaignScenario;
    }

    public CampaignScenarioDBModel getCampaignScenario() {
        return campaignScenario;
    }

    public void setCampaignScenario(CampaignScenarioDBModel campaignScenario) {
        this.campaignScenario = campaignScenario;
    }
}
