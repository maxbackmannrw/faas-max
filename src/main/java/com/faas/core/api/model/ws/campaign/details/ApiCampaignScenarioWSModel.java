package com.faas.core.api.model.ws.campaign.details;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignScenarioWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiCampaignScenarioWSModel {

    private GeneralWSModel general;
    private List<ApiCampaignScenarioWSDTO> campaignScenarios;

    public ApiCampaignScenarioWSModel() {
    }

    public ApiCampaignScenarioWSModel(GeneralWSModel general, List<ApiCampaignScenarioWSDTO> campaignScenarios) {
        this.general = general;
        this.campaignScenarios = campaignScenarios;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiCampaignScenarioWSDTO> getCampaignScenarios() {
        return campaignScenarios;
    }

    public void setCampaignScenarios(List<ApiCampaignScenarioWSDTO> campaignScenarios) {
        this.campaignScenarios = campaignScenarios;
    }
}
