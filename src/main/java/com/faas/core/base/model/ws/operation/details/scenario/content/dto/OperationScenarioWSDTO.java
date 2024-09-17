package com.faas.core.base.model.ws.operation.details.scenario.content.dto;

import com.faas.core.data.db.operation.content.dao.OperationScenarioDAO;

public class OperationScenarioWSDTO {

    private OperationScenarioDAO operationScenario;

    public OperationScenarioWSDTO() {
    }

    public OperationScenarioWSDTO(OperationScenarioDAO operationScenario) {
        this.operationScenario = operationScenario;
    }

    public OperationScenarioDAO getOperationScenario() {
        return operationScenario;
    }

    public void setOperationScenario(OperationScenarioDAO operationScenario) {
        this.operationScenario = operationScenario;
    }
}
