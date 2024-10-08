package com.faas.core.base.model.ws.operation.details.content.dto;

import com.faas.core.data.db.operation.content.OperationDBModel;

public class OperationDetailsWSDTO {

    private OperationDBModel operation;

    public OperationDetailsWSDTO() {
    }

    public OperationDetailsWSDTO(OperationDBModel operation) {
        this.operation = operation;
    }

    public OperationDBModel getOperation() {
        return operation;
    }

    public void setOperation(OperationDBModel operation) {
        this.operation = operation;
    }
}
