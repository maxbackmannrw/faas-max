package com.faas.core.api.model.ws.operation.scenario;

import com.faas.core.api.model.ws.operation.scenario.dto.ApiOperationScenarioWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationScenarioWSModel {

    private GeneralWSModel general;
    private List<ApiOperationScenarioWSDTO>scenarioExecutions;

    public ApiOperationScenarioWSModel() {
    }

    public ApiOperationScenarioWSModel(GeneralWSModel general, List<ApiOperationScenarioWSDTO> scenarioExecutions) {
        this.general = general;
        this.scenarioExecutions = scenarioExecutions;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationScenarioWSDTO> getScenarioExecutions() {
        return scenarioExecutions;
    }

    public void setScenarioExecutions(List<ApiOperationScenarioWSDTO> scenarioExecutions) {
        this.scenarioExecutions = scenarioExecutions;
    }
}
