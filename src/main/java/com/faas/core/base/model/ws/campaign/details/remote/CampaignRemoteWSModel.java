package com.faas.core.base.model.ws.campaign.details.remote;

import com.faas.core.base.model.ws.campaign.details.remote.dto.CampaignRemoteWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class CampaignRemoteWSModel {

    private GeneralWSModel general;
    private List<CampaignRemoteWSDTO> campaignRemotes;

    public CampaignRemoteWSModel() {
    }

    public CampaignRemoteWSModel(GeneralWSModel general, List<CampaignRemoteWSDTO> campaignRemotes) {
        this.general = general;
        this.campaignRemotes = campaignRemotes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignRemoteWSDTO> getCampaignRemotes() {
        return campaignRemotes;
    }

    public void setCampaignRemotes(List<CampaignRemoteWSDTO> campaignRemotes) {
        this.campaignRemotes = campaignRemotes;
    }
}
