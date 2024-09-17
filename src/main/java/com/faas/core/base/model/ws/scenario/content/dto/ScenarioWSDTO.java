package com.faas.core.base.model.ws.scenario.content.dto;

import com.faas.core.data.db.scenario.content.ScenarioDBModel;

public class ScenarioWSDTO {

    private ScenarioDBModel scenario;

    public ScenarioWSDTO() {
    }

    public ScenarioWSDTO(ScenarioDBModel scenario) {
        this.scenario = scenario;
    }

    public ScenarioDBModel getScenario() {
        return scenario;
    }

    public void setScenario(ScenarioDBModel scenario) {
        this.scenario = scenario;
    }
}
