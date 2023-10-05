package com.faas.core.api.model.ws.operation.scenario.content.dto;

import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;

public class ApiProcessScenarioWSDTO {

    private ProcessScenarioDBModel processScenario;

    public ApiProcessScenarioWSDTO() {
    }

    public ApiProcessScenarioWSDTO(ProcessScenarioDBModel processScenario) {
        this.processScenario = processScenario;
    }

    public ProcessScenarioDBModel getProcessScenario() {
        return processScenario;
    }

    public void setProcessScenario(ProcessScenarioDBModel processScenario) {
        this.processScenario = processScenario;
    }
}
