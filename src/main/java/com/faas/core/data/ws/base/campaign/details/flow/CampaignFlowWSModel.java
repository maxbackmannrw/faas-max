package com.faas.core.data.ws.base.campaign.details.flow;

import com.faas.core.data.ws.base.campaign.details.flow.dto.CampaignFlowWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

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
