package com.faas.core.api.model.ws.operation.manager.details;

import com.faas.core.api.model.ws.operation.manager.details.dto.ApiOperationDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationDetailsWSModel {

    private GeneralWSModel general;
    private ApiOperationDetailsWSDTO operationDetails;

    public ApiOperationDetailsWSModel() {
    }

    public ApiOperationDetailsWSModel(GeneralWSModel general, ApiOperationDetailsWSDTO operationDetails) {
        this.general = general;
        this.operationDetails = operationDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationDetailsWSDTO getOperationDetails() {
        return operationDetails;
    }

    public void setOperationDetails(ApiOperationDetailsWSDTO operationDetails) {
        this.operationDetails = operationDetails;
    }
}
