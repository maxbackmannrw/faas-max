package com.faas.core.base.model.ws.scenario.settings.dto;

import com.faas.core.base.model.db.scenario.settings.ScenarioTypeDBModel;

public class ScenarioTypeWSDTO {

    private ScenarioTypeDBModel scenarioType;

    public ScenarioTypeWSDTO() {
    }

    public ScenarioTypeWSDTO(ScenarioTypeDBModel scenarioType) {
        this.scenarioType = scenarioType;
    }

    public ScenarioTypeDBModel getScenarioType() {
        return scenarioType;
    }

    public void setScenarioType(ScenarioTypeDBModel scenarioType) {
        this.scenarioType = scenarioType;
    }
}
