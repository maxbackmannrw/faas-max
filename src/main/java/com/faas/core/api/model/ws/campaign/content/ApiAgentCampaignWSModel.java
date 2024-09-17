package com.faas.core.api.model.ws.campaign.content;

import com.faas.core.api.model.ws.campaign.content.dto.ApiAgentCampaignWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiAgentCampaignWSModel {

    private GeneralWSModel general;
    private ApiAgentCampaignWSDTO agentCampaign;

    public ApiAgentCampaignWSModel() {
    }

    public ApiAgentCampaignWSModel(GeneralWSModel general, ApiAgentCampaignWSDTO agentCampaign) {
        this.general = general;
        this.agentCampaign = agentCampaign;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiAgentCampaignWSDTO getAgentCampaign() {
        return agentCampaign;
    }

    public void setAgentCampaign(ApiAgentCampaignWSDTO agentCampaign) {
        this.agentCampaign = agentCampaign;
    }
}
