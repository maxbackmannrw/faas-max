package com.faas.core.data.ws.api.campaign.details;

import com.faas.core.data.ws.api.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

public class ApiCampaignDetailsWSModel {

    private GeneralWSModel general;
    private ApiCampaignDetailsWSDTO campaignDetails;

    public ApiCampaignDetailsWSModel() {
    }

    public ApiCampaignDetailsWSModel(GeneralWSModel general, ApiCampaignDetailsWSDTO campaignDetails) {
        this.general = general;
        this.campaignDetails = campaignDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiCampaignDetailsWSDTO getCampaignDetails() {
        return campaignDetails;
    }

    public void setCampaignDetails(ApiCampaignDetailsWSDTO campaignDetails) {
        this.campaignDetails = campaignDetails;
    }
}
