package com.faas.core.base.model.ws.campaign.details.client.operation;

import com.faas.core.base.model.ws.campaign.details.client.operation.dto.CampaignOperationWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class CampaignOperationWSModel {

    private GeneralWSModel general;
    private CampaignOperationWSDTO campaignOperation;

    public CampaignOperationWSModel() {
    }

    public CampaignOperationWSModel(GeneralWSModel general, CampaignOperationWSDTO campaignOperation) {
        this.general = general;
        this.campaignOperation = campaignOperation;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignOperationWSDTO getCampaignOperation() {
        return campaignOperation;
    }

    public void setCampaignOperation(CampaignOperationWSDTO campaignOperation) {
        this.campaignOperation = campaignOperation;
    }
}
