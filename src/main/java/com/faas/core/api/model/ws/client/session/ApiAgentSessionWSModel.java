package com.faas.core.api.model.ws.client.session;

import com.faas.core.api.model.ws.client.session.dto.ApiAgentSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiAgentSessionWSModel {

    private GeneralWSModel general;
    private ApiAgentSessionWSDTO agentSession;

    public ApiAgentSessionWSModel() {
    }

    public ApiAgentSessionWSModel(GeneralWSModel general, ApiAgentSessionWSDTO agentSession) {
        this.general = general;
        this.agentSession = agentSession;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiAgentSessionWSDTO getAgentSession() {
        return agentSession;
    }

    public void setAgentSession(ApiAgentSessionWSDTO agentSession) {
        this.agentSession = agentSession;
    }
}
