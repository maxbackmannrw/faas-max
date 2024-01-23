package com.faas.core.api.model.ws.operation.details.campaign.scenario;

import com.faas.core.api.model.ws.operation.details.campaign.scenario.dto.ApiOperationScenarioWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationScenarioWSModel {

    private GeneralWSModel general;
    private List<ApiOperationScenarioWSDTO>operationScenarios;

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
