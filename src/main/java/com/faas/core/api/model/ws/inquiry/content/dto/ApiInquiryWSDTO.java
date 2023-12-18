package com.faas.core.api.model.ws.inquiry.content.dto;

import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;

public class ApiInquiryWSDTO {

    private OperationDBModel operation;
    private SessionDBModel operationSession;

    public ApiInquiryWSDTO() {
    }

    public ApiInquiryWSDTO(OperationDBModel operation, SessionDBModel operationSession) {
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
