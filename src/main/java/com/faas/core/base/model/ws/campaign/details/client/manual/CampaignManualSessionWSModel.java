package com.faas.core.base.model.ws.campaign.details.client.manual;

import com.faas.core.base.model.ws.campaign.details.client.manual.dto.CampaignManualSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class CampaignManualSessionWSModel {

    private GeneralWSModel general;
    private CampaignManualSessionWSDTO campaignSession;

    public CampaignManualSessionWSModel() {
    }

    public CampaignManualSessionWSModel(GeneralWSModel general, CampaignManualSessionWSDTO campaignSession) {
        this.general = general;
        this.campaignSession = campaignSession;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignManualSessionWSDTO getCampaignSession() {
        return campaignSession;
    }

    public void setCampaignSession(CampaignManualSessionWSDTO campaignSession) {
        this.campaignSession = campaignSession;
    }
}
