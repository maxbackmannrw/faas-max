package com.faas.core.api.model.ws.user.details;

import com.faas.core.api.model.ws.user.details.dto.ApiAgentSipAccountWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiAgentSipAccountWSModel {

    private GeneralWSModel general;
    private ApiAgentSipAccountWSDTO agentSipAccount;

    public ApiAgentSipAccountWSModel() {
    }

    public ApiAgentSipAccountWSModel(GeneralWSModel general, ApiAgentSipAccountWSDTO agentSipAccount) {
        this.general = general;
        this.agentSipAccount = agentSipAccount;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiAgentSipAccountWSDTO getAgentSipAccount() {
        return agentSipAccount;
    }

    public void setAgentSipAccount(ApiAgentSipAccountWSDTO agentSipAccount) {
        this.agentSipAccount = agentSipAccount;
    }
}
