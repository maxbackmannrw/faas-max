package com.faas.core.base.model.ws.operation.scenario.content.dto;

import com.faas.core.base.model.db.operation.scenario.ScenarioExecutionDBModel;

public class ScenarioExecutionWSDTO {

    private ScenarioExecutionDBModel scenarioExecute;

    public ScenarioExecutionWSDTO() {
    }

    public ScenarioExecutionWSDTO(ScenarioExecutionDBModel scenarioExecute) {
        this.scenarioExecute = scenarioExecute;
    }

    public ScenarioExecutionDBModel getScenarioExecute() {
        return scenarioExecute;
    }

    public void setScenarioExecute(ScenarioExecutionDBModel scenarioExecute) {
        this.scenarioExecute = scenarioExecute;
    }
}
