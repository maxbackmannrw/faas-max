package com.faas.core.data.ws.api.operation.details.scenario;

import com.faas.core.data.ws.api.operation.details.scenario.dto.ApiOperationScenarioWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class ApiOperationScenarioWSModel {

    private GeneralWSModel general;
    private List<ApiOperationScenarioWSDTO> operationScenarios;

    public ApiOperationScenarioWSModel() {
    }

    public ApiOperationScenarioWSModel(GeneralWSModel general, List<ApiOperationScenarioWSDTO> operationScenarios) {
        this.general = general;
        this.operationScenarios = operationScenarios;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationScenarioWSDTO> getOperationScenarios() {
        return operationScenarios;
    }

    public void setOperationScenarios(List<ApiOperationScenarioWSDTO> operationScenarios) {
        this.operationScenarios = operationScenarios;
    }
}
