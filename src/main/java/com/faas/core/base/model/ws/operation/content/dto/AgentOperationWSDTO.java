package com.faas.core.base.model.ws.operation.content.dto;

import com.faas.core.base.model.db.operation.content.OperationDBModel;

public class AgentOperationWSDTO {

    private OperationDBModel operation;

    public AgentOperationWSDTO() {
    }

    public AgentOperationWSDTO(OperationDBModel operation) {
        this.operation = operation;
    }

    public OperationDBModel getOperation() {
        return operation;
    }

    public void setOperation(OperationDBModel operation) {
        this.operation = operation;
    }
}
