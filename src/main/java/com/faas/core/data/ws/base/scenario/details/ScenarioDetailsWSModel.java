package com.faas.core.data.ws.base.scenario.details;

import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.data.ws.base.scenario.details.dto.ScenarioDetailsWSDTO;

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
