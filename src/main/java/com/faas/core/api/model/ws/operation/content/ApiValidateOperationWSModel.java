package com.faas.core.api.model.ws.operation.content;

import com.faas.core.api.model.ws.operation.content.dto.ApiValidateOperationWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiValidateOperationWSModel {

    private GeneralWSModel general;
    private ApiValidateOperationWSDTO validateOperation;

    public ApiValidateOperationWSModel() {
    }

    public ApiValidateOperationWSModel(GeneralWSModel general, ApiValidateOperationWSDTO validateOperation) {
        this.general = general;
        this.validateOperation = validateOperation;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiValidateOperationWSDTO getValidateOperation() {
        return validateOperation;
    }

    public void setValidateOperation(ApiValidateOperationWSDTO validateOperation) {
        this.validateOperation = validateOperation;
    }
}
