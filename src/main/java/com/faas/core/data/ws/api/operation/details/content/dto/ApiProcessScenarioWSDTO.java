package com.faas.core.data.ws.api.operation.details.content.dto;

import com.faas.core.data.db.campaign.details.scenario.CampaignScenarioDBModel;

public class ApiProcessScenarioWSDTO {

    private CampaignScenarioDBModel processScenario;

    public ApiProcessScenarioWSDTO() {
    }

    public ApiProcessScenarioWSDTO(CampaignScenarioDBModel processScenario) {
        this.processScenario = processScenario;
    }

    public CampaignScenarioDBModel getProcessScenario() {
        return processScenario;
    }

    public void setProcessScenario(CampaignScenarioDBModel processScenario) {
        this.processScenario = processScenario;
    }
}
