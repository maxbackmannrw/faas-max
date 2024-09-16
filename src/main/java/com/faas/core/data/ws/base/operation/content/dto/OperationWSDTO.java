package com.faas.core.data.ws.base.operation.content.dto;

import com.faas.core.data.db.operation.content.OperationDBModel;

public class OperationWSDTO {

    private OperationDBModel operation;

    public OperationWSDTO() {
    }

    public OperationWSDTO(OperationDBModel operation) {
        this.operation = operation;
    }

    public OperationDBModel getOperation() {
        return operation;
    }

    public void setOperation(OperationDBModel operation) {
        this.operation = operation;
    }
}
