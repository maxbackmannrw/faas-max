package com.faas.core.data.ws.base.campaign.manager.content;

import com.faas.core.data.ws.base.campaign.manager.content.dto.CampaignSummaryWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

public class CampaignSummaryWSModel {

    private GeneralWSModel general;
    private CampaignSummaryWSDTO campaignSummary;

    public CampaignSummaryWSModel() {
    }

    public CampaignSummaryWSModel(GeneralWSModel general, CampaignSummaryWSDTO campaignSummary) {
        this.general = general;
        this.campaignSummary = campaignSummary;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignSummaryWSDTO getCampaignSummary() {
        return campaignSummary;
    }

    public void setCampaignSummary(CampaignSummaryWSDTO campaignSummary) {
        this.campaignSummary = campaignSummary;
    }
}
