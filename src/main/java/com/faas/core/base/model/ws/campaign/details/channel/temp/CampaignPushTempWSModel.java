package com.faas.core.base.model.ws.campaign.details.channel.temp;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.channel.temp.dto.CampaignPushTempWSDTO;

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
