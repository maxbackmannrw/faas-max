package com.faas.core.data.ws.base.operation.details.channel.dto;

import com.faas.core.data.db.operation.details.channel.OperationSipCallDBModel;

public class SipCallWSDTO {

    private OperationSipCallDBModel operationSipCall;

    public SipCallWSDTO() {
    }

    public SipCallWSDTO(OperationSipCallDBModel operationSipCall) {
        this.operationSipCall = operationSipCall;
    }

    public OperationSipCallDBModel getOperationSipCall() {
        return operationSipCall;
    }

    public void setOperationSipCall(OperationSipCallDBModel operationSipCall) {
        this.operationSipCall = operationSipCall;
    }
}
