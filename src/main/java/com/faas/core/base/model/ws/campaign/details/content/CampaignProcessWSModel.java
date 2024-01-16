package com.faas.core.base.model.ws.campaign.details.content;

import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignProcessWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class CampaignProcessWSModel {

    private GeneralWSModel general;
    private CampaignProcessWSDTO campaignProcess;

    public CampaignProcessWSModel() {
    }

    public CampaignProcessWSModel(GeneralWSModel general, CampaignProcessWSDTO campaignProcess) {
        this.general = general;
        this.campaignProcess = campaignProcess;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignProcessWSDTO getCampaignProcess() {
        return campaignProcess;
    }

    public void setCampaignProcess(CampaignProcessWSDTO campaignProcess) {
        this.campaignProcess = campaignProcess;
    }
}
