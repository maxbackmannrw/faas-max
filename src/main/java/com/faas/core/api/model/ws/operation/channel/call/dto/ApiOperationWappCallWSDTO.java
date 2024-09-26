package com.faas.core.api.model.ws.operation.channel.call.dto;

import com.faas.core.data.db.operation.details.channel.OperationWappCallDBModel;


public class ApiOperationWappCallWSDTO {

    private OperationWappCallDBModel operationWappCall;

    public ApiOperationWappCallWSDTO() {
    }

    public ApiOperationWappCallWSDTO(OperationWappCallDBModel operationWappCall) {
        this.operationWappCall = operationWappCall;
    }

    public OperationWappCallDBModel getOperationWappCall() {
        return operationWappCall;
    }

    public void setOperationWappCall(OperationWappCallDBModel operationWappCall) {
        this.operationWappCall = operationWappCall;
    }
}
