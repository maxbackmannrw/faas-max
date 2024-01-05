package com.faas.core.api.model.ws.operation.content;

import com.faas.core.api.model.ws.operation.content.dto.ApiAgentOperationWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiAgentOperationWSModel {

    private GeneralWSModel general;
    private ApiAgentOperationWSDTO agentOperation;

    public ApiAgentOperationWSModel() {
    }

    public ApiAgentOperationWSModel(GeneralWSModel general, ApiAgentOperationWSDTO agentOperation) {
        this.general = general;
        this.agentOperation = agentOperation;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiAgentOperationWSDTO getAgentOperation() {
        return agentOperation;
    }

    public void setAgentOperation(ApiAgentOperationWSDTO agentOperation) {
        this.agentOperation = agentOperation;
    }
}
