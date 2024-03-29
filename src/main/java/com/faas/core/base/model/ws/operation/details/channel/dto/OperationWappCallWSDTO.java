package com.faas.core.base.model.ws.operation.details.channel.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationWappCallDBModel;

public class OperationWappCallWSDTO {

    private OperationWappCallDBModel operationWappCall;

    public OperationWappCallWSDTO() {
    }

    public OperationWappCallWSDTO(OperationWappCallDBModel operationWappCall) {
        this.operationWappCall = operationWappCall;
    }

    public OperationWappCallDBModel getOperationWappCall() {
        return operationWappCall;
    }

    public void setOperationWappCall(OperationWappCallDBModel operationWappCall) {
        this.operationWappCall = operationWappCall;
    }
}
