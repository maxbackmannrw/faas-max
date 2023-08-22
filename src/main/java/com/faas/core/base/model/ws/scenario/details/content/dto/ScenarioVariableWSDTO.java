package com.faas.core.base.model.ws.scenario.details.content.dto;

import com.faas.core.base.model.db.scenario.content.dao.ScenarioVariableDAO;

public class ScenarioVariableWSDTO {

    private ScenarioVariableDAO scenarioVariable;

    public ScenarioVariableWSDTO() {
    }

    public ScenarioVariableWSDTO(ScenarioVariableDAO scenarioVariable) {
        this.scenarioVariable = scenarioVariable;
    }

    public ScenarioVariableDAO getScenarioVariable() {
        return scenarioVariable;
    }

    public void setScenarioVariable(ScenarioVariableDAO scenarioVariable) {
        this.scenarioVariable = scenarioVariable;
    }
}
