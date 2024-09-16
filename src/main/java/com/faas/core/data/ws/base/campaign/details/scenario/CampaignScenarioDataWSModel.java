package com.faas.core.data.ws.base.campaign.details.scenario;

import com.faas.core.data.ws.base.campaign.details.scenario.dto.ProcessScenarioDataWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class CampaignScenarioDataWSModel {

    private GeneralWSModel general;
    private List<ProcessScenarioDataWSDTO> scenarioDatas;

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
