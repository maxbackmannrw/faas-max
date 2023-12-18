package com.faas.core.api.model.ws.flow.content.dto;

import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;

public class ApiFlowWSDTO {

    private OperationDBModel operation;
    private SessionDBModel operationSession;

    public ApiFlowWSDTO() {
    }

    public ApiFlowWSDTO(OperationDBModel operation, SessionDBModel operationSession) {
        this.operation = operation;
        this.operationSession = operationSession;
    }

    public OperationDBModel getOperation() {
        return operation;
    }

    public void setOperation(OperationDBModel operation) {
        this.operation = operation;
    }

    public SessionDBModel getOperationSession() {
        return operationSession;
    }

    public void setOperationSession(SessionDBModel operationSession) {
        this.operationSession = operationSession;
    }
}
