package com.faas.core.api.model.ws.operation.manager.campaign;

import com.faas.core.api.model.ws.operation.manager.campaign.dto.ApiOperationCampaignWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

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
