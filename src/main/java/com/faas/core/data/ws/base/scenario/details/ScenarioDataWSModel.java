package com.faas.core.data.ws.base.scenario.details;

import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.data.ws.base.scenario.details.dto.ScenarioDataWSDTO;

import java.util.List;

public class ScenarioDataWSModel {

    private GeneralWSModel general;
    private List<ScenarioDataWSDTO> scenarioDatas;

    public ScenarioDataWSModel() {
    }

    public ScenarioDataWSModel(GeneralWSModel general, List<ScenarioDataWSDTO> scenarioDatas) {
        this.general = general;
        this.scenarioDatas = scenarioDatas;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ScenarioDataWSDTO> getScenarioDatas() {
        return scenarioDatas;
    }

    public void setScenarioDatas(List<ScenarioDataWSDTO> scenarioDatas) {
        this.scenarioDatas = scenarioDatas;
    }
}
