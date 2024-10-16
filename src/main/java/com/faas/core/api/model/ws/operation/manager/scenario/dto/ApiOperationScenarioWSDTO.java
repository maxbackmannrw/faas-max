package com.faas.core.api.model.ws.operation.manager.scenario.dto;

import com.faas.core.data.db.operation.details.scenario.OperationScenarioDBModel;

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
