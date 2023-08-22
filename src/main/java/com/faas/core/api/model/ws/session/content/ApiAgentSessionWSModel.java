package com.faas.core.api.model.ws.session.content;

import com.faas.core.api.model.ws.session.content.dto.ApiAgentSessionWSDTO;
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
