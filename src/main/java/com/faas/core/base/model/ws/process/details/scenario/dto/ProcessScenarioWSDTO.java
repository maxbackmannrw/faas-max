package com.faas.core.base.model.ws.process.details.scenario.dto;

import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;

public class ProcessScenarioWSDTO {

    private ProcessScenarioDBModel processScenario;
    public ScenarioDBModel processScenarioDetails;

    public ProcessScenarioWSDTO() {
    }

    public ProcessScenarioWSDTO(ProcessScenarioDBModel processScenario, ScenarioDBModel processScenarioDetails) {
        this.processScenario = processScenario;
        this.processScenarioDetails = processScenarioDetails;
    }

    public ProcessScenarioDBModel getProcessScenario() {
        return processScenario;
    }

    public void setProcessScenario(ProcessScenarioDBModel processScenario) {
        this.processScenario = processScenario;
    }

    public ScenarioDBModel getProcessScenarioDetails() {
        return processScenarioDetails;
    }

    public void setProcessScenarioDetails(ScenarioDBModel processScenarioDetails) {
        this.processScenarioDetails = processScenarioDetails;
    }
}
