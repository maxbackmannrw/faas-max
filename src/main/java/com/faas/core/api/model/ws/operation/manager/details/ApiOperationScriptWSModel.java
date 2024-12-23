package com.faas.core.api.model.ws.operation.manager.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.data.db.campaign.content.dao.CampaignScriptDAO;

import java.util.List;

public class ApiOperationScriptWSModel {

    private GeneralWSModel general;
    private List<CampaignScriptDAO> operationScripts;

    public ApiOperationScriptWSModel() {
    }

    public ApiOperationScriptWSModel(GeneralWSModel general, List<CampaignScriptDAO> operationScripts) {
        this.general = general;
        this.operationScripts = operationScripts;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignScriptDAO> getOperationScripts() {
        return operationScripts;
    }

    public void setOperationScripts(List<CampaignScriptDAO> operationScripts) {
        this.operationScripts = operationScripts;
    }
}
