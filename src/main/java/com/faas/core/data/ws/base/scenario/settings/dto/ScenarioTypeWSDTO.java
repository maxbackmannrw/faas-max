package com.faas.core.data.ws.base.scenario.settings.dto;

import com.faas.core.data.db.scenario.settings.ScenarioTypeDBModel;

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
