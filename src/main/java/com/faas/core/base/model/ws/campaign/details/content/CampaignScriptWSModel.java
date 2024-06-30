package com.faas.core.base.model.ws.campaign.details.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignScriptWSDTO;

import java.util.List;

public class CampaignScriptWSModel {

    private GeneralWSModel general;
    private List<CampaignScriptWSDTO>campaignScripts;

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
