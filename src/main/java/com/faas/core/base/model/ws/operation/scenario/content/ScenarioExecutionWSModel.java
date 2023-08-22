package com.faas.core.base.model.ws.operation.scenario.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.scenario.content.dto.ScenarioExecutionWSDTO;

import java.util.List;

public class ScenarioExecutionWSModel {

    private GeneralWSModel general;
    private List<ScenarioExecutionWSDTO>scenarioExecutions;

    public ScenarioExecutionWSModel() {
    }

    public ScenarioExecutionWSModel(GeneralWSModel general, List<ScenarioExecutionWSDTO> scenarioExecutions) {
        this.general = general;
        this.scenarioExecutions = scenarioExecutions;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ScenarioExecutionWSDTO> getScenarioExecutions() {
        return scenarioExecutions;
    }

    public void setScenarioExecutions(List<ScenarioExecutionWSDTO> scenarioExecutions) {
        this.scenarioExecutions = scenarioExecutions;
    }
}
