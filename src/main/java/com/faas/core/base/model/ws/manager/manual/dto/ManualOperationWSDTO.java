package com.faas.core.base.model.ws.manager.manual.dto;

import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;

public class ManualOperationWSDTO {

    private OperationDBModel operation;
    private SessionDBModel operationSession;

    public ManualOperationWSDTO() {
    }

    public ManualOperationWSDTO(OperationDBModel operation, SessionDBModel operationSession) {
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
