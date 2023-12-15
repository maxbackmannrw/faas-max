package com.faas.core.base.model.ws.process.details.scenario.dto;

import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;

public class ProcessScenarioWSDTO {

    private ProcessScenarioDBModel processScenario;

    public ProcessScenarioWSDTO() {
    }

    public ProcessScenarioWSDTO(ProcessScenarioDBModel processScenario) {
        this.processScenario = processScenario;
    }

    public ProcessScenarioDBModel getProcessScenario() {
        return processScenario;
    }

    public void setProcessScenario(ProcessScenarioDBModel processScenario) {
        this.processScenario = processScenario;
    }
}
