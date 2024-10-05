package com.faas.core.api.model.ws.operation.manager.content;

import com.faas.core.api.model.ws.operation.manager.content.dto.ApiOperationAgentWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationAgentWSModel {

    private GeneralWSModel general;
    private ApiOperationAgentWSDTO operationAgent;

    public ApiOperationAgentWSModel() {
    }

    public ApiOperationAgentWSModel(GeneralWSModel general, ApiOperationAgentWSDTO operationAgent) {
        this.general = general;
        this.operationAgent = operationAgent;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationAgentWSDTO getOperationAgent() {
        return operationAgent;
    }

    public void setOperationAgent(ApiOperationAgentWSDTO operationAgent) {
        this.operationAgent = operationAgent;
    }
}
