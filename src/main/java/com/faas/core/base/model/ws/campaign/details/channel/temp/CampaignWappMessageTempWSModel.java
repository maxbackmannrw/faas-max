package com.faas.core.base.model.ws.campaign.details.channel.temp;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.channel.temp.dto.CampaignWappMessageTempWSDTO;

import java.util.List;

public class CampaignWappMessageTempWSModel {

    private GeneralWSModel general;
    private List<CampaignWappMessageTempWSDTO> campaignWappMessageTemps;

    public CampaignWappMessageTempWSModel() {
    }

    public CampaignWappMessageTempWSModel(GeneralWSModel general, List<CampaignWappMessageTempWSDTO> campaignWappMessageTemps) {
        this.general = general;
        this.campaignWappMessageTemps = campaignWappMessageTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignWappMessageTempWSDTO> getCampaignWappMessageTemps() {
        return campaignWappMessageTemps;
    }

    public void setCampaignWappMessageTemps(List<CampaignWappMessageTempWSDTO> campaignWappMessageTemps) {
        this.campaignWappMessageTemps = campaignWappMessageTemps;
    }
}
