package com.faas.core.api.model.ws.operation.scenario.content.dto;

import com.faas.core.base.model.db.operation.scenario.OperationScenarioDBModel;

public class ApiOperationScenarioWSDTO {

    private OperationScenarioDBModel operationScenario;

    public ApiOperationScenarioWSDTO() {
    }

    public ApiOperationScenarioWSDTO(OperationScenarioDBModel operationScenario) {
        this.operationScenario = operationScenario;
    }

    public OperationScenarioDBModel getOperationScenario() {
        return operationScenario;
    }

    public void setOperationScenario(OperationScenarioDBModel operationScenario) {
        this.operationScenario = operationScenario;
    }
}
