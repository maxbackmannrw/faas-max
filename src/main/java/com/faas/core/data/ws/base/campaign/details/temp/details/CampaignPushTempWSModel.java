package com.faas.core.data.ws.base.campaign.details.temp.details;

import com.faas.core.data.ws.base.campaign.details.temp.details.dto.CampaignPushTempWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class CampaignPushTempWSModel {

    private GeneralWSModel general;
    private List<CampaignPushTempWSDTO> campaignPushTemps;

    public CampaignPushTempWSModel() {
    }

    public CampaignPushTempWSModel(GeneralWSModel general, List<CampaignPushTempWSDTO> campaignPushTemps) {
        this.general = general;
        this.campaignPushTemps = campaignPushTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignPushTempWSDTO> getCampaignPushTemps() {
        return campaignPushTemps;
    }

    public void setCampaignPushTemps(List<CampaignPushTempWSDTO> campaignPushTemps) {
        this.campaignPushTemps = campaignPushTemps;
    }
}
