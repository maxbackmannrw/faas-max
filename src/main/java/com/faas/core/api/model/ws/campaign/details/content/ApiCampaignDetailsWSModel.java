package com.faas.core.api.model.ws.campaign.details.content;

import com.faas.core.api.model.ws.campaign.details.content.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiCampaignDetailsWSModel {

    private GeneralWSModel general;
    private List<ApiCampaignDetailsWSDTO>campaignDetails;


    public ApiCampaignDetailsWSModel() {
    }

    public ApiCampaignDetailsWSModel(GeneralWSModel general, List<ApiCampaignDetailsWSDTO> campaignDetails) {
        this.general = general;
        this.campaignDetails = campaignDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiCampaignDetailsWSDTO> getCampaignDetails() {
        return campaignDetails;
    }

    public void setCampaignDetails(List<ApiCampaignDetailsWSDTO> campaignDetails) {
        this.campaignDetails = campaignDetails;
    }
}
