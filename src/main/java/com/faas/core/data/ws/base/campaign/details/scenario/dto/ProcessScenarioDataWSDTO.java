package com.faas.core.data.ws.base.campaign.details.scenario.dto;

import com.faas.core.data.db.scenario.content.dao.ScenarioDataDAO;

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
