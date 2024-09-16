package com.faas.core.data.ws.api.campaign.content;

import com.faas.core.data.ws.api.campaign.content.dto.ApiAgentCampaignWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

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
