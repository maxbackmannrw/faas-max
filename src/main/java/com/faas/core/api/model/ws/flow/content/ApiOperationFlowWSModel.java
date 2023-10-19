package com.faas.core.api.model.ws.flow.content;

import com.faas.core.api.model.ws.flow.content.dto.ApiOperationFlowWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationFlowWSModel {

    private GeneralWSModel general;
    private ApiOperationFlowWSDTO operationFlow;

    public ApiOperationFlowWSModel() {
    }

    public ApiOperationFlowWSModel(GeneralWSModel general, ApiOperationFlowWSDTO operationFlow) {
        this.general = general;
        this.operationFlow = operationFlow;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationFlowWSDTO getOperationFlow() {
        return operationFlow;
    }

    public void setOperationFlow(ApiOperationFlowWSDTO operationFlow) {
        this.operationFlow = operationFlow;
    }
}
