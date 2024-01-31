package com.faas.core.api.model.ws.operation.details.campaign;

import com.faas.core.api.model.ws.operation.details.campaign.dto.ApiProcessScenarioWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

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
