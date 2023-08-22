package com.faas.core.base.model.ws.scenario.details.content.dto;

import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;

public class ScenarioDetailsWSDTO {

    private ScenarioDBModel scenario;

    public ScenarioDetailsWSDTO() {
    }

    public ScenarioDetailsWSDTO(ScenarioDBModel scenario) {
        this.scenario = scenario;
    }

    public ScenarioDBModel getScenario() {
        return scenario;
    }

    public void setScenario(ScenarioDBModel scenario) {
        this.scenario = scenario;
    }
}
