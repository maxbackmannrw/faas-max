package com.faas.core.data.ws.base.scenario.details.dto;

import com.faas.core.data.db.scenario.content.ScenarioDBModel;

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
