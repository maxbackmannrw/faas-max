package com.faas.core.api.model.ws.operation.scenario.process;

import com.faas.core.api.model.ws.operation.scenario.process.dto.ApiScenarioElementWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiScenarioElementWSModel {

    private GeneralWSModel general;
    private List<ApiScenarioElementWSDTO>scenarioElements;

    public ApiScenarioElementWSModel() {
    }

    public ApiScenarioElementWSModel(GeneralWSModel general, List<ApiScenarioElementWSDTO> scenarioElements) {
        this.general = general;
        this.scenarioElements = scenarioElements;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiScenarioElementWSDTO> getScenarioElements() {
        return scenarioElements;
    }

    public void setScenarioElements(List<ApiScenarioElementWSDTO> scenarioElements) {
        this.scenarioElements = scenarioElements;
    }
}
