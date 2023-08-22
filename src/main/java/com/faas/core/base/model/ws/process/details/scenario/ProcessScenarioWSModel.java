package com.faas.core.base.model.ws.process.details.scenario;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;

import java.util.List;

public class ProcessScenarioWSModel {

    private GeneralWSModel general;
    private List<ProcessScenarioWSDTO> processScenarios;

    public ProcessScenarioWSModel() {
    }

    public ProcessScenarioWSModel(GeneralWSModel general, List<ProcessScenarioWSDTO> processScenarios) {
        this.general = general;
        this.processScenarios = processScenarios;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessScenarioWSDTO> getProcessScenarios() {
        return processScenarios;
    }

    public void setProcessScenarios(List<ProcessScenarioWSDTO> processScenarios) {
        this.processScenarios = processScenarios;
    }
}
