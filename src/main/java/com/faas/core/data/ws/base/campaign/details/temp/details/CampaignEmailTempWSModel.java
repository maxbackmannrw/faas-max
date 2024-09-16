package com.faas.core.data.ws.base.campaign.details.temp.details;

import com.faas.core.data.ws.base.campaign.details.temp.details.dto.CampaignEmailTempWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class CampaignEmailTempWSModel {

    private GeneralWSModel general;
    private List<CampaignEmailTempWSDTO> campaignEmailTemps;

    public CampaignEmailTempWSModel() {
    }

    public CampaignEmailTempWSModel(GeneralWSModel general, List<CampaignEmailTempWSDTO> campaignEmailTemps) {
        this.general = general;
        this.campaignEmailTemps = campaignEmailTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignEmailTempWSDTO> getCampaignEmailTemps() {
        return campaignEmailTemps;
    }

    public void setCampaignEmailTemps(List<CampaignEmailTempWSDTO> campaignEmailTemps) {
        this.campaignEmailTemps = campaignEmailTemps;
    }
}
