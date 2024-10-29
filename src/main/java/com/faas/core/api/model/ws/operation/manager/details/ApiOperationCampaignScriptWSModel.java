package com.faas.core.api.model.ws.operation.manager.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.data.db.campaign.content.dao.CampaignScriptDAO;

import java.util.List;

public class ApiOperationCampaignScriptWSModel {

    private GeneralWSModel general;
    private List<CampaignScriptDAO> campaignScripts;

    public ApiOperationCampaignScriptWSModel() {
    }

    public ApiOperationCampaignScriptWSModel(GeneralWSModel general, List<CampaignScriptDAO> campaignScripts) {
        this.general = general;
        this.campaignScripts = campaignScripts;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignScriptDAO> getCampaignScripts() {
        return campaignScripts;
    }

    public void setCampaignScripts(List<CampaignScriptDAO> campaignScripts) {
        this.campaignScripts = campaignScripts;
    }
}
