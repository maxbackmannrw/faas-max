package com.faas.core.data.ws.base.scenario.details.dto;

import com.faas.core.data.db.scenario.content.dao.ScenarioDataDAO;

public class ScenarioDataWSDTO {

    private ScenarioDataDAO scenarioData;

    public ScenarioDataWSDTO() {
    }

    public ScenarioDataWSDTO(ScenarioDataDAO scenarioData) {
        this.scenarioData = scenarioData;
    }

    public ScenarioDataDAO getScenarioData() {
        return scenarioData;
    }

    public void setScenarioData(ScenarioDataDAO scenarioData) {
        this.scenarioData = scenarioData;
    }
}
