package com.faas.core.base.model.ws.scenario.details.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.content.dto.ScenarioWSDTO;

import java.util.List;

public class ScenarioDetailsWSModel {

    private GeneralWSModel general;
    private List<ScenarioWSDTO> scenarios;

    public ScenarioDetailsWSModel() {
    }

    public ScenarioDetailsWSModel(GeneralWSModel general, List<ScenarioWSDTO> scenarios) {
        this.general = general;
        this.scenarios = scenarios;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ScenarioWSDTO> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<ScenarioWSDTO> scenarios) {
        this.scenarios = scenarios;
    }
}
