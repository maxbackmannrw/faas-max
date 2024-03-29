package com.faas.core.base.model.ws.operation.details.channel.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationSipCallDBModel;

public class OperationSipCallWSDTO {

    private OperationSipCallDBModel operationSipCall;

    public OperationSipCallWSDTO() {
    }

    public OperationSipCallWSDTO(OperationSipCallDBModel operationSipCall) {
        this.operationSipCall = operationSipCall;
    }

    public OperationSipCallDBModel getOperationSipCall() {
        return operationSipCall;
    }

    public void setOperationSipCall(OperationSipCallDBModel operationSipCall) {
        this.operationSipCall = operationSipCall;
    }
}
