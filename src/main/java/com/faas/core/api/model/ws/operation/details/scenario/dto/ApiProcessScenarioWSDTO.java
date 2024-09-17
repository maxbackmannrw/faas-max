package com.faas.core.api.model.ws.operation.details.scenario.dto;

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
