package com.faas.core.api.model.ws.operation.details.channel.call.sip.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationSipCallDBModel;

public class ApiOperationSipCallWSDTO {

    private OperationSipCallDBModel operationSipCall;

    public ApiOperationSipCallWSDTO() {
    }

    public ApiOperationSipCallWSDTO(OperationSipCallDBModel operationSipCall) {
        this.operationSipCall = operationSipCall;
    }

    public OperationSipCallDBModel getOperationSipCall() {
        return operationSipCall;
    }

    public void setOperationSipCall(OperationSipCallDBModel operationSipCall) {
        this.operationSipCall = operationSipCall;
    }
}
