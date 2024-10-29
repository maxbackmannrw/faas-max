package com.faas.core.api.model.ws.operation.manager.client;

import com.faas.core.api.model.ws.operation.manager.client.dto.ApiOperationClientWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationClientWSModel {

    private GeneralWSModel general;
    private ApiOperationClientWSDTO operationClient;

    public ApiOperationClientWSModel() {
    }

    public ApiOperationClientWSModel(GeneralWSModel general, ApiOperationClientWSDTO operationClient) {
        this.general = general;
        this.operationClient = operationClient;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationClientWSDTO getOperationClient() {
        return operationClient;
    }

    public void setOperationClient(ApiOperationClientWSDTO operationClient) {
        this.operationClient = operationClient;
    }
}
