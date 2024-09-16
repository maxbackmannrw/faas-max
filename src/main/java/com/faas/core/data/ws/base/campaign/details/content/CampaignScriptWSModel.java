package com.faas.core.data.ws.base.campaign.details.content;

import com.faas.core.data.ws.base.campaign.details.content.dto.CampaignScriptWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class CampaignScriptWSModel {

    private GeneralWSModel general;
    private List<CampaignScriptWSDTO> campaignScripts;

    public CampaignScriptWSModel() {
    }

    public CampaignScriptWSModel(GeneralWSModel general, List<CampaignScriptWSDTO> campaignScripts) {
        this.general = general;
        this.campaignScripts = campaignScripts;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignScriptWSDTO> getCampaignScripts() {
        return campaignScripts;
    }

    public void setCampaignScripts(List<CampaignScriptWSDTO> campaignScripts) {
        this.campaignScripts = campaignScripts;
    }
}
