package com.faas.core.api.model.ws.operation.scenario.content;

import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiOperationScenarioWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationScenarioWSModel {

    private GeneralWSModel general;
    private ApiOperationScenarioWSDTO operationScenario;

    public ApiOperationScenarioWSModel() {
    }

    public ApiOperationScenarioWSModel(GeneralWSModel general, ApiOperationScenarioWSDTO operationScenario) {
        this.general = general;
        this.operationScenario = operationScenario;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationScenarioWSDTO getOperationScenario() {
        return operationScenario;
    }

    public void setOperationScenario(ApiOperationScenarioWSDTO operationScenario) {
        this.operationScenario = operationScenario;
    }
}
