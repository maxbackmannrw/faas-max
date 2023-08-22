package com.faas.core.api.model.ws.operation.scenario.content.dto;

import com.faas.core.base.model.db.scenario.content.dao.ScenarioElement;

public class ApiScenarioElementWSDTO {

    private ScenarioElement scenarioElement;

    public ApiScenarioElementWSDTO() {
    }

    public ApiScenarioElementWSDTO(ScenarioElement scenarioElement) {
        this.scenarioElement = scenarioElement;
    }

    public ScenarioElement getScenarioElement() {
        return scenarioElement;
    }

    public void setScenarioElement(ScenarioElement scenarioElement) {
        this.scenarioElement = scenarioElement;
    }
}
