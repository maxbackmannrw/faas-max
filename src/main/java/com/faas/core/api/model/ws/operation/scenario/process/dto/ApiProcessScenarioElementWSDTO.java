package com.faas.core.api.model.ws.operation.scenario.process.dto;

import com.faas.core.base.model.db.process.details.scenario.dao.ProcessScenarioElement;

public class ApiProcessScenarioElementWSDTO {

    private ProcessScenarioElement scenarioElement;

    public ApiProcessScenarioElementWSDTO() {
    }

    public ApiProcessScenarioElementWSDTO(ProcessScenarioElement scenarioElement) {
        this.scenarioElement = scenarioElement;
    }

    public ProcessScenarioElement getScenarioElement() {
        return scenarioElement;
    }

    public void setScenarioElement(ProcessScenarioElement scenarioElement) {
        this.scenarioElement = scenarioElement;
    }
}
