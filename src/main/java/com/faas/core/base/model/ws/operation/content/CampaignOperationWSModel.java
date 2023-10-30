package com.faas.core.base.model.ws.operation.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.content.dto.CampaignOperationWSDTO;

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
