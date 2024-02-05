package com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationWappCallDBModel;


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
