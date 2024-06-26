package com.faas.core.api.model.ws.operation.details.content.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.details.scenario.CampaignScenarioDBModel;

import java.util.List;

public class ApiOperationCampaignWSDTO {

    private CampaignDBModel operationCampaign;
    private List<CampaignScenarioDBModel> processScenarios;

    public ApiOperationCampaignWSDTO() {
    }

    public ApiOperationCampaignWSDTO(CampaignDBModel operationCampaign, List<CampaignScenarioDBModel> processScenarios) {
        this.operationCampaign = operationCampaign;
        this.processScenarios = processScenarios;
    }

    public CampaignDBModel getOperationCampaign() {
        return operationCampaign;
    }

    public void setOperationCampaign(CampaignDBModel operationCampaign) {
        this.operationCampaign = operationCampaign;
    }

    public List<CampaignScenarioDBModel> getProcessScenarios() {
        return processScenarios;
    }

    public void setProcessScenarios(List<CampaignScenarioDBModel> processScenarios) {
        this.processScenarios = processScenarios;
    }
}
