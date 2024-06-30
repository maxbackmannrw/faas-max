package com.faas.core.base.model.ws.campaign.details.channel.temp;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.channel.temp.dto.CampaignSmsTempWSDTO;

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
