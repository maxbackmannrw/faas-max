package com.faas.core.base.model.ws.operation.details.scenario.dto;

import com.faas.core.data.db.operation.details.scenario.OperationScenarioDBModel;

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
