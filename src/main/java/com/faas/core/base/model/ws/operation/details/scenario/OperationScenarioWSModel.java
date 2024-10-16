package com.faas.core.base.model.ws.operation.details.scenario;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.scenario.dto.OperationScenarioWSDTO;

import java.util.List;

public class OperationScenarioWSModel {

    private GeneralWSModel general;
    private List<OperationScenarioWSDTO> scenarioExecutions;

    public OperationScenarioWSModel() {
    }

    public OperationScenarioWSModel(GeneralWSModel general, List<OperationScenarioWSDTO> scenarioExecutions) {
        this.general = general;
        this.scenarioExecutions = scenarioExecutions;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationScenarioWSDTO> getScenarioExecutions() {
        return scenarioExecutions;
    }

    public void setScenarioExecutions(List<OperationScenarioWSDTO> scenarioExecutions) {
        this.scenarioExecutions = scenarioExecutions;
    }
}
