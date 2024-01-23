package com.faas.core.api.model.ws.operation.details.campaign.scenario.dto;

import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;

public class ApiOperationScenarioWSDTO {

    private ProcessScenarioDBModel processScenario;

    public ApiOperationScenarioWSDTO() {
    }

    public ApiOperationScenarioWSDTO(ProcessScenarioDBModel processScenario) {
        this.processScenario = processScenario;
    }

    public ProcessScenarioDBModel getProcessScenario() {
        return processScenario;
    }

    public void setProcessScenario(ProcessScenarioDBModel processScenario) {
        this.processScenario = processScenario;
    }
}
