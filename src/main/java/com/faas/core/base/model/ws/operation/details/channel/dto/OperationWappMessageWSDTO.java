package com.faas.core.base.model.ws.operation.details.channel.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;

public class OperationWappMessageWSDTO {

    private OperationWappMessageDBModel operationWappMessage;

    public OperationWappMessageWSDTO() {
    }

    public OperationWappMessageWSDTO(OperationWappMessageDBModel operationWappMessage) {
        this.operationWappMessage = operationWappMessage;
    }

    public OperationWappMessageDBModel getOperationWappMessage() {
        return operationWappMessage;
    }

    public void setOperationWappMessage(OperationWappMessageDBModel operationWappMessage) {
        this.operationWappMessage = operationWappMessage;
    }
}
