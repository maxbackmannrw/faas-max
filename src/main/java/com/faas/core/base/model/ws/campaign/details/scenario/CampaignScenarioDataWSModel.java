package com.faas.core.base.model.ws.campaign.details.scenario;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.scenario.dto.ProcessScenarioDataWSDTO;

import java.util.List;

public class CampaignScenarioDataWSModel {

    private GeneralWSModel general;
    private List<ProcessScenarioDataWSDTO>scenarioDatas;

    public CampaignScenarioDataWSModel() {
    }

    public CampaignScenarioDataWSModel(GeneralWSModel general, List<ProcessScenarioDataWSDTO> scenarioDatas) {
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
