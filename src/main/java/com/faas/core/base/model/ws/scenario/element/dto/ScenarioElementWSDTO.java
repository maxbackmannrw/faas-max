package com.faas.core.base.model.ws.scenario.element.dto;

import com.faas.core.base.model.db.scenario.content.dao.ScenarioElement;

public class ScenarioElementWSDTO {

    private ScenarioElement scenarioElement;

    public ScenarioElementWSDTO() {
    }

    public ScenarioElementWSDTO(ScenarioElement scenarioElement) {
        this.scenarioElement = scenarioElement;
    }

    public ScenarioElement getScenarioElement() {
        return scenarioElement;
    }

    public void setScenarioElement(ScenarioElement scenarioElement) {
        this.scenarioElement = scenarioElement;
    }
}
