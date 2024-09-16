package com.faas.core.data.ws.api.operation.details.content;

import com.faas.core.data.ws.api.operation.details.content.dto.ApiProcessScenarioWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class ApiProcessScenarioWSModel {

    private GeneralWSModel general;
    private List<ApiProcessScenarioWSDTO> processScenarios;

    public ApiProcessScenarioWSModel() {
    }

    public ApiProcessScenarioWSModel(GeneralWSModel general, List<ApiProcessScenarioWSDTO> processScenarios) {
        this.general = general;
        this.processScenarios = processScenarios;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiProcessScenarioWSDTO> getProcessScenarios() {
        return processScenarios;
    }

    public void setProcessScenarios(List<ApiProcessScenarioWSDTO> processScenarios) {
        this.processScenarios = processScenarios;
    }
}
