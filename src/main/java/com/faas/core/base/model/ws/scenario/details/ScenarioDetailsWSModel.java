package com.faas.core.base.model.ws.scenario.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.dto.ScenarioDetailsWSDTO;

public class ScenarioDetailsWSModel {

    private GeneralWSModel general;
    private ScenarioDetailsWSDTO scenarioDetails;

    public ScenarioDetailsWSModel() {
    }

    public ScenarioDetailsWSModel(GeneralWSModel general, ScenarioDetailsWSDTO scenarioDetails) {
        this.general = general;
        this.scenarioDetails = scenarioDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ScenarioDetailsWSDTO getScenarioDetails() {
        return scenarioDetails;
    }

    public void setScenarioDetails(ScenarioDetailsWSDTO scenarioDetails) {
        this.scenarioDetails = scenarioDetails;
    }
}
