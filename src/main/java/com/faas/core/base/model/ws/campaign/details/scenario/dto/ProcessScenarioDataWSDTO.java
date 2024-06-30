package com.faas.core.base.model.ws.campaign.details.scenario.dto;

import com.faas.core.base.model.db.scenario.content.dao.ScenarioDataDAO;

public class ProcessScenarioDataWSDTO {

    private ScenarioDataDAO scenarioData;

    public ProcessScenarioDataWSDTO() {
    }

    public ProcessScenarioDataWSDTO(ScenarioDataDAO scenarioData) {
        this.scenarioData = scenarioData;
    }

    public ScenarioDataDAO getScenarioData() {
        return scenarioData;
    }

    public void setScenarioData(ScenarioDataDAO scenarioData) {
        this.scenarioData = scenarioData;
    }
}
