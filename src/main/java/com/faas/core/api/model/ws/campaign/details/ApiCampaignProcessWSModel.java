package com.faas.core.api.model.ws.campaign.details;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignProcessWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiCampaignProcessWSModel {

    private GeneralWSModel general;
    private ApiCampaignProcessWSDTO campaignProcess;


    public ApiCampaignProcessWSModel() {
    }

    public ApiCampaignProcessWSModel(GeneralWSModel general, ApiCampaignProcessWSDTO campaignProcess) {
        this.general = general;
        this.campaignProcess = campaignProcess;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiCampaignProcessWSDTO getCampaignProcess() {
        return campaignProcess;
    }

    public void setCampaignProcess(ApiCampaignProcessWSDTO campaignProcess) {
        this.campaignProcess = campaignProcess;
    }
}
