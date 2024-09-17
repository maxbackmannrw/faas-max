package com.faas.core.base.model.ws.campaign.details.temp.details;

import com.faas.core.base.model.ws.campaign.details.temp.details.dto.CampaignWappMessageTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

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
