package com.faas.core.api.model.ws.operation.content.dto;

import com.faas.core.data.db.operation.content.OperationDBModel;

public class ApiOperationWSDTO {

    private OperationDBModel operation;

    public ApiOperationWSDTO() {
    }

    public ApiOperationWSDTO(OperationDBModel operation) {
        this.operation = operation;
    }

    public OperationDBModel getOperation() {
        return operation;
    }

    public void setOperation(OperationDBModel operation) {
        this.operation = operation;
    }
}
