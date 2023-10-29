package com.faas.core.base.model.ws.operation.details.content.dto;

import com.faas.core.base.model.db.operation.details.flow.OperationFlowDBModel;

public class OperationDetailsWSDTO {

    private OperationFlowDBModel clientFlow;

    public OperationDetailsWSDTO() {
    }

    public OperationDetailsWSDTO(OperationFlowDBModel clientFlow) {
        this.clientFlow = clientFlow;
    }

    public OperationFlowDBModel getClientFlow() {
        return clientFlow;
    }

    public void setClientFlow(OperationFlowDBModel clientFlow) {
        this.clientFlow = clientFlow;
    }
}
