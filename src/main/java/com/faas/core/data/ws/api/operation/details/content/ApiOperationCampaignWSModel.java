package com.faas.core.data.ws.api.operation.details.content;

import com.faas.core.data.ws.api.operation.details.content.dto.ApiOperationCampaignWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

public class ApiOperationCampaignWSModel {

    private GeneralWSModel general;
    private ApiOperationCampaignWSDTO campaign;


    public ApiOperationCampaignWSModel() {
    }

    public ApiOperationCampaignWSModel(GeneralWSModel general, ApiOperationCampaignWSDTO campaign) {
        this.general = general;
        this.campaign = campaign;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationCampaignWSDTO getCampaign() {
        return campaign;
    }

    public void setCampaign(ApiOperationCampaignWSDTO campaign) {
        this.campaign = campaign;
    }
}
