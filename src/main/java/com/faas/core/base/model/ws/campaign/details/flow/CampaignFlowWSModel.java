package com.faas.core.base.model.ws.campaign.details.flow;

import com.faas.core.base.model.ws.campaign.details.flow.dto.CampaignFlowWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class CampaignFlowWSModel {

    private GeneralWSModel general;
    private CampaignFlowWSDTO campaignFlow;

    public CampaignFlowWSModel() {
    }

    public CampaignFlowWSModel(GeneralWSModel general, CampaignFlowWSDTO campaignFlow) {
        this.general = general;
        this.campaignFlow = campaignFlow;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignFlowWSDTO getCampaignFlow() {
        return campaignFlow;
    }

    public void setCampaignFlow(CampaignFlowWSDTO campaignFlow) {
        this.campaignFlow = campaignFlow;
    }
}
