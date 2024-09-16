package com.faas.core.data.ws.base.operation.details.channel.dto;

import com.faas.core.data.db.operation.details.channel.OperationWappCallDBModel;

public class WappCallWSDTO {

    private OperationWappCallDBModel operationWappCall;

    public WappCallWSDTO() {
    }

    public WappCallWSDTO(OperationWappCallDBModel operationWappCall) {
        this.operationWappCall = operationWappCall;
    }

    public OperationWappCallDBModel getOperationWappCall() {
        return operationWappCall;
    }

    public void setOperationWappCall(OperationWappCallDBModel operationWappCall) {
        this.operationWappCall = operationWappCall;
    }
}
