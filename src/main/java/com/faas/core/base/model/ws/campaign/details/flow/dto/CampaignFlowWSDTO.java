package com.faas.core.base.model.ws.campaign.details.flow.dto;

import com.faas.core.data.db.campaign.content.dao.CampaignFlowDAO;

public class CampaignFlowWSDTO {

    private CampaignFlowDAO campaignFlow;

    public CampaignFlowWSDTO() {
    }

    public CampaignFlowWSDTO(CampaignFlowDAO campaignFlow) {
        this.campaignFlow = campaignFlow;
    }

    public CampaignFlowDAO getCampaignFlow() {
        return campaignFlow;
    }

    public void setCampaignFlow(CampaignFlowDAO campaignFlow) {
        this.campaignFlow = campaignFlow;
    }
}
