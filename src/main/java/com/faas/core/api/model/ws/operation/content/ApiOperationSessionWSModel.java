package com.faas.core.api.model.ws.operation.content;

import com.faas.core.api.model.ws.operation.content.dto.ApiOperationSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationSessionWSModel {

    private GeneralWSModel general;
    private ApiOperationSessionWSDTO operation;

    public ApiOperationSessionWSModel() {
    }

    public ApiOperationSessionWSModel(GeneralWSModel general, ApiOperationSessionWSDTO operation) {
        this.general = general;
        this.operation = operation;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationSessionWSDTO getOperation() {
        return operation;
    }

    public void setOperation(ApiOperationSessionWSDTO operation) {
        this.operation = operation;
    }
}
