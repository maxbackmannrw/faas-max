package com.faas.core.data.ws.base.campaign.manager.operation;

import com.faas.core.data.ws.base.campaign.manager.operation.dto.CampaignOperationWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

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
