package com.faas.core.api.model.ws.operation.manager.content;

import com.faas.core.api.model.ws.operation.manager.content.dto.ApiOperationManagerWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationManagerWSModel {

    private GeneralWSModel general;
    private ApiOperationManagerWSDTO operationManager;

    public ApiOperationManagerWSModel() {
    }

    public ApiOperationManagerWSModel(GeneralWSModel general, ApiOperationManagerWSDTO operationManager) {
        this.general = general;
        this.operationManager = operationManager;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationManagerWSDTO getOperationManager() {
        return operationManager;
    }

    public void setOperationManager(ApiOperationManagerWSDTO operationManager) {
        this.operationManager = operationManager;
    }
}
