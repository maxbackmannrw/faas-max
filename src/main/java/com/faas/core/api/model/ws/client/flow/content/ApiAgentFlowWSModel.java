package com.faas.core.api.model.ws.client.flow.content;

import com.faas.core.api.model.ws.client.flow.content.dto.ApiAgentFlowWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiAgentFlowWSModel {

    private GeneralWSModel general;
    private ApiAgentFlowWSDTO agentFlow;

    public ApiAgentFlowWSModel() {
    }

    public ApiAgentFlowWSModel(GeneralWSModel general, ApiAgentFlowWSDTO agentFlow) {
        this.general = general;
        this.agentFlow = agentFlow;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiAgentFlowWSDTO getAgentFlow() {
        return agentFlow;
    }

    public void setAgentFlow(ApiAgentFlowWSDTO agentFlow) {
        this.agentFlow = agentFlow;
    }
}
