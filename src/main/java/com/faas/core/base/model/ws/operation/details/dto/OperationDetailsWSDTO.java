package com.faas.core.base.model.ws.operation.details.dto;

import com.faas.core.base.model.db.operation.content.OperationDBModel;

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
