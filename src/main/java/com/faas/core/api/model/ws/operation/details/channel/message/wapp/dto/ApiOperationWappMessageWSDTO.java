package com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;

public class ApiOperationWappMessageWSDTO {

    private OperationWappMessageDBModel operationWappMessage;

    public ApiOperationWappMessageWSDTO() {
    }

    public ApiOperationWappMessageWSDTO(OperationWappMessageDBModel operationWappMessage) {
        this.operationWappMessage = operationWappMessage;
    }

    public OperationWappMessageDBModel getOperationWappMessage() {
        return operationWappMessage;
    }

    public void setOperationWappMessage(OperationWappMessageDBModel operationWappMessage) {
        this.operationWappMessage = operationWappMessage;
    }
}
