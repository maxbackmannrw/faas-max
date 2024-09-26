package com.faas.core.api.model.ws.operation.scenario.dto;

import com.faas.core.data.db.operation.content.dao.OperationScenarioDAO;

public class ApiOperationScenarioWSDTO {

    private OperationScenarioDAO operationScenario;

    public ApiOperationScenarioWSDTO() {
    }

    public ApiOperationScenarioWSDTO(OperationScenarioDAO operationScenario) {
        this.operationScenario = operationScenario;
    }

    public OperationScenarioDAO getOperationScenario() {
        return operationScenario;
    }

    public void setOperationScenario(OperationScenarioDAO operationScenario) {
        this.operationScenario = operationScenario;
    }
}
