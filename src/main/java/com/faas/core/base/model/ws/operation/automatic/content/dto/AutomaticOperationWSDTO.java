package com.faas.core.base.model.ws.operation.automatic.content.dto;

import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.flow.OperationFlowDBModel;

public class AutomaticOperationWSDTO {

    private OperationDBModel operation;
    private SessionDBModel operationSession;
    private OperationFlowDBModel operationFlow;

    public AutomaticOperationWSDTO() {
    }

    public AutomaticOperationWSDTO(OperationDBModel operation, SessionDBModel operationSession, OperationFlowDBModel operationFlow) {
        this.operation = operation;
        this.operationSession = operationSession;
        this.operationFlow = operationFlow;
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

    public OperationFlowDBModel getOperationFlow() {
        return operationFlow;
    }

    public void setOperationFlow(OperationFlowDBModel operationFlow) {
        this.operationFlow = operationFlow;
    }
}
