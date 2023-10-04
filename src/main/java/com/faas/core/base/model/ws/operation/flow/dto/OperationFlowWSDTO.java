package com.faas.core.base.model.ws.operation.flow.dto;

import com.faas.core.base.model.db.operation.flow.OperationFlowDBModel;

public class OperationFlowWSDTO {

    private OperationFlowDBModel clientFlow;

    public OperationFlowWSDTO() {
    }

    public OperationFlowWSDTO(OperationFlowDBModel clientFlow) {
        this.clientFlow = clientFlow;
    }

    public OperationFlowDBModel getClientFlow() {
        return clientFlow;
    }

    public void setClientFlow(OperationFlowDBModel clientFlow) {
        this.clientFlow = clientFlow;
    }
}
