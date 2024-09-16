package com.faas.core.data.ws.api.operation.content;

import com.faas.core.data.ws.api.operation.content.dto.ApiOperationValidateWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

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
