package com.faas.core.api.model.ws.operation.manager.channel.message.wapp.dto;

import com.faas.core.data.db.operation.details.channel.OperationWappMessageDBModel;

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
