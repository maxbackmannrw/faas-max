package com.faas.core.base.model.ws.process.details.scenario;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioDataWSDTO;

import java.util.List;

public class ProcessScenarioDataWSModel {

    private GeneralWSModel general;
    private List<ProcessScenarioDataWSDTO>scenarioDatas;

    public ProcessScenarioDataWSModel() {
    }

    public ProcessScenarioDataWSModel(GeneralWSModel general, List<ProcessScenarioDataWSDTO> scenarioDatas) {
        this.general = general;
        this.scenarioDatas = scenarioDatas;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessScenarioDataWSDTO> getScenarioDatas() {
        return scenarioDatas;
    }

    public void setScenarioDatas(List<ProcessScenarioDataWSDTO> scenarioDatas) {
        this.scenarioDatas = scenarioDatas;
    }
}
