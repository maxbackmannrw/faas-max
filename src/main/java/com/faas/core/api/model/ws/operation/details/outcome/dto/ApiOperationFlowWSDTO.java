package com.faas.core.api.model.ws.operation.details.outcome.dto;

import com.faas.core.base.model.db.operation.flow.OperationFlowDBModel;

public class ApiOperationFlowWSDTO {

    private OperationFlowDBModel operationFlow;

    public ApiOperationFlowWSDTO() {
    }

    public ApiOperationFlowWSDTO(OperationFlowDBModel operationFlow) {
        this.operationFlow = operationFlow;
    }

    public OperationFlowDBModel getOperationFlow() {
        return operationFlow;
    }

    public void setOperationFlow(OperationFlowDBModel operationFlow) {
        this.operationFlow = operationFlow;
    }
}
