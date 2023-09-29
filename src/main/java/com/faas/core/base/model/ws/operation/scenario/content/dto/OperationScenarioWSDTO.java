package com.faas.core.base.model.ws.operation.scenario.content.dto;

import com.faas.core.base.model.db.operation.scenario.OperationScenarioDBModel;

public class OperationScenarioWSDTO {

    private OperationScenarioDBModel operationScenario;

    public OperationScenarioWSDTO() {
    }

    public OperationScenarioWSDTO(OperationScenarioDBModel operationScenario) {
        this.operationScenario = operationScenario;
    }

    public OperationScenarioDBModel getOperationScenario() {
        return operationScenario;
    }

    public void setOperationScenario(OperationScenarioDBModel operationScenario) {
        this.operationScenario = operationScenario;
    }
}
