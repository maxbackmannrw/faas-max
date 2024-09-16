package com.faas.core.data.ws.api.operation.content;

import com.faas.core.data.ws.api.operation.content.dto.ApiAgentOperationWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

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
