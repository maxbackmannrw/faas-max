package com.faas.core.api.model.ws.operation.details.scenario.dto;

import com.faas.core.base.model.db.scenario.content.dao.ScenarioElement;

public class ApiProcessScenarioElementWSDTO {

    private ScenarioElement scenarioElement;

    public ApiProcessScenarioElementWSDTO() {
    }

    public ApiProcessScenarioElementWSDTO(ScenarioElement scenarioElement) {
        this.scenarioElement = scenarioElement;
    }

    public ScenarioElement getScenarioElement() {
        return scenarioElement;
    }

    public void setScenarioElement(ScenarioElement scenarioElement) {
        this.scenarioElement = scenarioElement;
    }
}
