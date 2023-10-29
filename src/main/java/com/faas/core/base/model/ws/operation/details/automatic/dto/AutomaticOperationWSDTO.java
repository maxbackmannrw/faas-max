package com.faas.core.base.model.ws.operation.details.automatic.dto;

import com.faas.core.base.model.db.operation.details.flow.OperationFlowDBModel;

public class AutomaticOperationWSDTO {

    private OperationFlowDBModel clientFlow;

    public AutomaticOperationWSDTO() {
    }

    public AutomaticOperationWSDTO(OperationFlowDBModel clientFlow) {
        this.clientFlow = clientFlow;
    }

    public OperationFlowDBModel getClientFlow() {
        return clientFlow;
    }

    public void setClientFlow(OperationFlowDBModel clientFlow) {
        this.clientFlow = clientFlow;
    }
}
