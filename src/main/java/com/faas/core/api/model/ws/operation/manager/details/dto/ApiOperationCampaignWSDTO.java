package com.faas.core.api.model.ws.operation.manager.details.dto;

import com.faas.core.data.db.campaign.content.CampaignDBModel;
import com.faas.core.data.db.campaign.details.scenario.CampaignScenarioDBModel;

import java.util.List;

public class ApiOperationCampaignWSDTO {

    private CampaignDBModel campaign;
    private List<CampaignScenarioDBModel> campaignScenarios;

    public ApiOperationCampaignWSDTO() {
    }

    public ApiOperationCampaignWSDTO(CampaignDBModel campaign, List<CampaignScenarioDBModel> campaignScenarios) {
        this.campaign = campaign;
        this.campaignScenarios = campaignScenarios;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public List<CampaignScenarioDBModel> getCampaignScenarios() {
        return campaignScenarios;
    }

    public void setCampaignScenarios(List<CampaignScenarioDBModel> campaignScenarios) {
        this.campaignScenarios = campaignScenarios;
    }
}
