package com.faas.core.api.model.ws.operation.scenario.content.dto;

import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;

public class ApiScenarioWSDTO {

    private ScenarioDBModel scenario;
    private ProcessScenarioDBModel processScenario;

    public ApiScenarioWSDTO() {
    }

    public ApiScenarioWSDTO(ScenarioDBModel scenario, ProcessScenarioDBModel processScenario) {
        this.scenario = scenario;
        this.processScenario = processScenario;
    }

    public ScenarioDBModel getScenario() {
        return scenario;
    }

    public void setScenario(ScenarioDBModel scenario) {
        this.scenario = scenario;
    }

    public ProcessScenarioDBModel getProcessScenario() {
        return processScenario;
    }

    public void setProcessScenario(ProcessScenarioDBModel processScenario) {
        this.processScenario = processScenario;
    }
}
