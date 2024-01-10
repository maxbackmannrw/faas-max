package com.faas.core.api.model.ws.campaign.details;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

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
