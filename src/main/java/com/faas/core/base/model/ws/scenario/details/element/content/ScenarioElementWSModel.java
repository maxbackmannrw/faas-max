package com.faas.core.base.model.ws.scenario.details.element.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.element.content.dto.ScenarioElementWSDTO;

import java.util.List;

public class ScenarioElementWSModel {

    private GeneralWSModel general;
    private List<ScenarioElementWSDTO> scenarioElements;

    public ScenarioElementWSModel() {
    }

    public ScenarioElementWSModel(GeneralWSModel general, List<ScenarioElementWSDTO> scenarioElements) {
        this.general = general;
        this.scenarioElements = scenarioElements;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ScenarioElementWSDTO> getScenarioElements() {
        return scenarioElements;
    }

    public void setScenarioElements(List<ScenarioElementWSDTO> scenarioElements) {
        this.scenarioElements = scenarioElements;
    }
}
