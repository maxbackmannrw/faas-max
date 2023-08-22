package com.faas.core.api.model.ws.operation.scenario.content.dto;


import com.faas.core.api.model.ws.operation.scenario.execution.dto.ApiScenarioExecutionWSDTO;

import java.util.List;

public class ApiOperationScenarioWSDTO {

    private List<ApiScenarioWSDTO> scenarios;
    private List<ApiScenarioExecutionWSDTO> scenarioExecutions;

    public ApiOperationScenarioWSDTO() {
    }

    public ApiOperationScenarioWSDTO(List<ApiScenarioWSDTO> scenarios, List<ApiScenarioExecutionWSDTO> scenarioExecutions) {
        this.scenarios = scenarios;
        this.scenarioExecutions = scenarioExecutions;
    }

    public List<ApiScenarioWSDTO> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<ApiScenarioWSDTO> scenarios) {
        this.scenarios = scenarios;
    }

    public List<ApiScenarioExecutionWSDTO> getScenarioExecutions() {
        return scenarioExecutions;
    }

    public void setScenarioExecutions(List<ApiScenarioExecutionWSDTO> scenarioExecutions) {
        this.scenarioExecutions = scenarioExecutions;
    }
}
