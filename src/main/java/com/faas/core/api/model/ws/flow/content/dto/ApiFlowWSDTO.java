package com.faas.core.api.model.ws.flow.content.dto;

import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.flow.OperationFlowDBModel;
import com.faas.core.base.model.db.operation.inquiry.OperationInquiryDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class ApiFlowWSDTO {

    private OperationDBModel operation;
    private SessionDBModel operationSession;
    private OperationFlowDBModel operationFlow;

    public ApiFlowWSDTO() {
    }

    public ApiFlowWSDTO(OperationDBModel operation, SessionDBModel operationSession, OperationFlowDBModel operationFlow) {
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
