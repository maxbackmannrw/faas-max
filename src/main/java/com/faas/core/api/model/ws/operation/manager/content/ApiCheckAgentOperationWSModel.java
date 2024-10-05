package com.faas.core.api.model.ws.operation.manager.content;

import com.faas.core.api.model.ws.operation.manager.content.dto.ApiCheckAgentOperationWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiCheckAgentOperationWSModel {

    private GeneralWSModel general;
    private ApiCheckAgentOperationWSDTO checkAgentOperation;

    public ApiCheckAgentOperationWSModel() {
    }

    public ApiCheckAgentOperationWSModel(GeneralWSModel general, ApiCheckAgentOperationWSDTO checkAgentOperation) {
        this.general = general;
        this.checkAgentOperation = checkAgentOperation;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiCheckAgentOperationWSDTO getCheckAgentOperation() {
        return checkAgentOperation;
    }

    public void setCheckAgentOperation(ApiCheckAgentOperationWSDTO checkAgentOperation) {
        this.checkAgentOperation = checkAgentOperation;
    }
}
