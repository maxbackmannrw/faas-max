package com.faas.core.api.model.ws.operation.scenario.process;

import com.faas.core.api.model.ws.operation.scenario.process.dto.ApiProcessScenarioWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiProcessScenarioWSModel {

    private GeneralWSModel general;
    private List<ApiProcessScenarioWSDTO>scenarios;

    public ApiProcessScenarioWSModel() {
    }

    public ApiProcessScenarioWSModel(GeneralWSModel general, List<ApiProcessScenarioWSDTO> scenarios) {
        this.general = general;
        this.scenarios = scenarios;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiProcessScenarioWSDTO> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<ApiProcessScenarioWSDTO> scenarios) {
        this.scenarios = scenarios;
    }
}
