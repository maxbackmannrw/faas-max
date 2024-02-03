package com.faas.core.api.model.ws.operation.details.scenario.dto;

import com.faas.core.base.model.db.operation.content.dao.OperationScenarioDAO;

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
