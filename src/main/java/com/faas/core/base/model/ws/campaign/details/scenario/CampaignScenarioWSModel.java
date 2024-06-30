package com.faas.core.base.model.ws.campaign.details.scenario;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.scenario.dto.CampaignScenarioWSDTO;

import java.util.List;

public class CampaignScenarioWSModel {

    private GeneralWSModel general;
    private List<CampaignScenarioWSDTO> campaignScenarios;

    public CampaignScenarioWSModel() {
    }

    public CampaignScenarioWSModel(GeneralWSModel general, List<CampaignScenarioWSDTO> campaignScenarios) {
        this.general = general;
        this.campaignScenarios = campaignScenarios;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignScenarioWSDTO> getCampaignScenarios() {
        return campaignScenarios;
    }

    public void setCampaignScenarios(List<CampaignScenarioWSDTO> campaignScenarios) {
        this.campaignScenarios = campaignScenarios;
    }
}
