package com.faas.core.base.model.ws.scenario.details.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.content.dto.ScenarioVariableWSDTO;

import java.util.List;

public class ScenarioVariableWSModel {

    private GeneralWSModel general;
    private List<ScenarioVariableWSDTO> scenarioVariables;

    public ScenarioVariableWSModel() {
    }

    public ScenarioVariableWSModel(GeneralWSModel general, List<ScenarioVariableWSDTO> scenarioVariables) {
        this.general = general;
        this.scenarioVariables = scenarioVariables;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ScenarioVariableWSDTO> getScenarioVariables() {
        return scenarioVariables;
    }

    public void setScenarioVariables(List<ScenarioVariableWSDTO> scenarioVariables) {
        this.scenarioVariables = scenarioVariables;
    }
}
