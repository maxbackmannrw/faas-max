package com.faas.core.data.ws.base.scenario.settings;

import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.data.ws.base.scenario.settings.dto.ScenarioTypeWSDTO;

import java.util.List;

public class ScenarioTypeWSModel {

    private GeneralWSModel general;
    private List<ScenarioTypeWSDTO> scenarioTypes;

    public ScenarioTypeWSModel() {
    }

    public ScenarioTypeWSModel(GeneralWSModel general, List<ScenarioTypeWSDTO> scenarioTypes) {
        this.general = general;
        this.scenarioTypes = scenarioTypes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ScenarioTypeWSDTO> getScenarioTypes() {
        return scenarioTypes;
    }

    public void setScenarioTypes(List<ScenarioTypeWSDTO> scenarioTypes) {
        this.scenarioTypes = scenarioTypes;
    }
}
