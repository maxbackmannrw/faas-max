package com.faas.core.api.model.ws.operation.scenario.content;

import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiScenarioWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiScenarioWSModel {

    private GeneralWSModel general;
    private List<ApiScenarioWSDTO>scenarios;

    public ApiScenarioWSModel() {
    }

    public ApiScenarioWSModel(GeneralWSModel general, List<ApiScenarioWSDTO> scenarios) {
        this.general = general;
        this.scenarios = scenarios;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiScenarioWSDTO> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<ApiScenarioWSDTO> scenarios) {
        this.scenarios = scenarios;
    }
}
