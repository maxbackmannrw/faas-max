package com.faas.core.api.model.ws.flow.details;

import com.faas.core.api.model.ws.flow.details.dto.ApiOperationFlowDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationFlowDetailsWSModel {

    private GeneralWSModel general;
    private ApiOperationFlowDetailsWSDTO operationFlowDetails;

    public ApiOperationFlowDetailsWSModel() {
    }

    public ApiOperationFlowDetailsWSModel(GeneralWSModel general, ApiOperationFlowDetailsWSDTO operationFlowDetails) {
        this.general = general;
        this.operationFlowDetails = operationFlowDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationFlowDetailsWSDTO getOperationFlowDetails() {
        return operationFlowDetails;
    }

    public void setOperationFlowDetails(ApiOperationFlowDetailsWSDTO operationFlowDetails) {
        this.operationFlowDetails = operationFlowDetails;
    }
}
