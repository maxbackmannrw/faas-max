package com.faas.core.data.ws.api.operation.details.content;

import com.faas.core.data.ws.api.operation.details.content.dto.ApiOperationDetailsWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

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
