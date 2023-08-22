package com.faas.core.base.model.ws.process.details.scenario.dto;

import com.faas.core.base.model.db.process.details.scenario.dao.ProcessScenarioDataDAO;

public class ProcessScenarioDataWSDTO {

    private ProcessScenarioDataDAO scenarioData;

    public ProcessScenarioDataWSDTO() {
    }

    public ProcessScenarioDataWSDTO(ProcessScenarioDataDAO scenarioData) {
        this.scenarioData = scenarioData;
    }

    public ProcessScenarioDataDAO getScenarioData() {
        return scenarioData;
    }

    public void setScenarioData(ProcessScenarioDataDAO scenarioData) {
        this.scenarioData = scenarioData;
    }
}
