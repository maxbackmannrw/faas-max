package com.faas.core.api.model.ws.agent.details;

import com.faas.core.api.model.ws.agent.details.dto.ApiAgentSipAccountWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiAgentSipAccountWSModel {

    private GeneralWSModel general;
    private ApiAgentSipAccountWSDTO sipAccount;

    public ApiAgentSipAccountWSModel() {
    }

    public ApiAgentSipAccountWSModel(GeneralWSModel general, ApiAgentSipAccountWSDTO sipAccount) {
        this.general = general;
        this.sipAccount = sipAccount;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiAgentSipAccountWSDTO getSipAccount() {
        return sipAccount;
    }

    public void setSipAccount(ApiAgentSipAccountWSDTO sipAccount) {
        this.sipAccount = sipAccount;
    }
}
