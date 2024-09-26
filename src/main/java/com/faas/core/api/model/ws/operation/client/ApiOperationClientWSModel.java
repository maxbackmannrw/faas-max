package com.faas.core.api.model.ws.operation.client;

import com.faas.core.api.model.ws.operation.client.dto.ApiOperationClientWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationClientWSModel {

    private GeneralWSModel general;
    private ApiOperationClientWSDTO client;

    public ApiOperationClientWSModel() {
    }

    public ApiOperationClientWSModel(GeneralWSModel general, ApiOperationClientWSDTO client) {
        this.general = general;
        this.client = client;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationClientWSDTO getClient() {
        return client;
    }

    public void setClient(ApiOperationClientWSDTO client) {
        this.client = client;
    }
}
