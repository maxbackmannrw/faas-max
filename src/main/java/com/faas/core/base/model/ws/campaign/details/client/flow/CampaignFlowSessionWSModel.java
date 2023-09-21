package com.faas.core.base.model.ws.campaign.details.client.flow;

import com.faas.core.base.model.ws.campaign.details.client.flow.dto.CampaignFlowSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class CampaignFlowSessionWSModel {

    private GeneralWSModel general;
    private CampaignFlowSessionWSDTO campaignFlow;

    public CampaignFlowSessionWSModel() {
    }

    public CampaignFlowSessionWSModel(GeneralWSModel general, CampaignFlowSessionWSDTO campaignFlow) {
        this.general = general;
        this.campaignFlow = campaignFlow;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignFlowSessionWSDTO getCampaignFlow() {
        return campaignFlow;
    }

    public void setCampaignFlow(CampaignFlowSessionWSDTO campaignFlow) {
        this.campaignFlow = campaignFlow;
    }
}
