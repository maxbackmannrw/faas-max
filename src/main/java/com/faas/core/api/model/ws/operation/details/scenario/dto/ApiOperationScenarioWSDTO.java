package com.faas.core.api.model.ws.operation.details.scenario.dto;

import com.faas.core.base.model.db.operation.details.scenario.OperationScenarioDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;

public class ApiOperationScenarioWSDTO {

    private OperationScenarioDBModel operationScenario;
    private ProcessScenarioDBModel processScenario;

    public ApiOperationScenarioWSDTO() {
    }

    public ApiOperationScenarioWSDTO(OperationScenarioDBModel operationScenario, ProcessScenarioDBModel processScenario) {
        this.operationScenario = operationScenario;
        this.processScenario = processScenario;
    }

    public OperationScenarioDBModel getOperationScenario() {
        return operationScenario;
    }

    public void setOperationScenario(OperationScenarioDBModel operationScenario) {
        this.operationScenario = operationScenario;
    }

    public ProcessScenarioDBModel getProcessScenario() {
        return processScenario;
    }

    public void setProcessScenario(ProcessScenarioDBModel processScenario) {
        this.processScenario = processScenario;
    }
}
