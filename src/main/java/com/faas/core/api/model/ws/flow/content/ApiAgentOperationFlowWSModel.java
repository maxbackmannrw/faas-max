package com.faas.core.api.model.ws.flow.content;

import com.faas.core.api.model.ws.flow.content.dto.ApiAgentOperationFlowWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiAgentOperationFlowWSModel {

    private GeneralWSModel general;
    private ApiAgentOperationFlowWSDTO agentOperationFlow;

    public ApiAgentOperationFlowWSModel() {
    }

    public ApiAgentOperationFlowWSModel(GeneralWSModel general, ApiAgentOperationFlowWSDTO agentOperationFlow) {
        this.general = general;
        this.agentOperationFlow = agentOperationFlow;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiAgentOperationFlowWSDTO getAgentOperationFlow() {
        return agentOperationFlow;
    }

    public void setAgentOperationFlow(ApiAgentOperationFlowWSDTO agentOperationFlow) {
        this.agentOperationFlow = agentOperationFlow;
    }
}
