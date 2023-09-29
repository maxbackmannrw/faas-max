package com.faas.core.api.model.ws.operation.scenario.process;

import com.faas.core.api.model.ws.operation.scenario.process.dto.ApiProcessScenarioElementWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiProcessScenarioElementWSModel {

    private GeneralWSModel general;
    private List<ApiProcessScenarioElementWSDTO>scenarioElements;

    public ApiProcessScenarioElementWSModel() {
    }

    public ApiProcessScenarioElementWSModel(GeneralWSModel general, List<ApiProcessScenarioElementWSDTO> scenarioElements) {
        this.general = general;
        this.scenarioElements = scenarioElements;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiProcessScenarioElementWSDTO> getScenarioElements() {
        return scenarioElements;
    }

    public void setScenarioElements(List<ApiProcessScenarioElementWSDTO> scenarioElements) {
        this.scenarioElements = scenarioElements;
    }
}
