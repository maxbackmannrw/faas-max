package com.faas.core.data.ws.base.campaign.details.temp.details;

import com.faas.core.data.ws.base.campaign.details.temp.details.dto.CampaignSmsTempWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class CampaignSmsTempWSModel {

    private GeneralWSModel general;
    private List<CampaignSmsTempWSDTO> campaignSmsTemps;

    public CampaignSmsTempWSModel() {
    }

    public CampaignSmsTempWSModel(GeneralWSModel general, List<CampaignSmsTempWSDTO> campaignSmsTemps) {
        this.general = general;
        this.campaignSmsTemps = campaignSmsTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignSmsTempWSDTO> getCampaignSmsTemps() {
        return campaignSmsTemps;
    }

    public void setCampaignSmsTemps(List<CampaignSmsTempWSDTO> campaignSmsTemps) {
        this.campaignSmsTemps = campaignSmsTemps;
    }
}
