package com.faas.core.api.model.ws.operation.content;

import com.faas.core.api.model.ws.operation.content.dto.ApiOperationValidateWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationValidateWSModel {

    private GeneralWSModel general;
    private ApiOperationValidateWSDTO operationValidate;

    public ApiOperationValidateWSModel() {
    }

    public ApiOperationValidateWSModel(GeneralWSModel general, ApiOperationValidateWSDTO operationValidate) {
        this.general = general;
        this.operationValidate = operationValidate;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationValidateWSDTO getOperationValidate() {
        return operationValidate;
    }

    public void setOperationValidate(ApiOperationValidateWSDTO operationValidate) {
        this.operationValidate = operationValidate;
    }
}
