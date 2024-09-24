package com.faas.core.api.model.ws.campaign.content;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignListWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiCampaignListWSModel {

    private GeneralWSModel general;
    private ApiCampaignListWSDTO campaignList;

    public ApiCampaignListWSModel() {
    }

    public ApiCampaignListWSModel(GeneralWSModel general, ApiCampaignListWSDTO campaignList) {
        this.general = general;
        this.campaignList = campaignList;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiCampaignListWSDTO getCampaignList() {
        return campaignList;
    }

    public void setCampaignList(ApiCampaignListWSDTO campaignList) {
        this.campaignList = campaignList;
    }
}
