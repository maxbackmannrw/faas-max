package com.faas.core.data.ws.base.campaign.details.content.dto;

import com.faas.core.data.db.campaign.content.dao.CampaignScriptDAO;

public class CampaignScriptWSDTO {

    private CampaignScriptDAO campaignScript;

    public CampaignScriptWSDTO() {
    }

    public CampaignScriptWSDTO(CampaignScriptDAO campaignScript) {
        this.campaignScript = campaignScript;
    }

    public CampaignScriptDAO getCampaignScript() {
        return campaignScript;
    }

    public void setCampaignScript(CampaignScriptDAO campaignScript) {
        this.campaignScript = campaignScript;
    }
}
