package com.faas.core.api.model.ws.inquiry.content.dto;

import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.inquiry.OperationInquiryDBModel;

public class ApiInquiryWSDTO {

    private OperationDBModel operation;
    private SessionDBModel operationSession;
    private OperationInquiryDBModel operationInquiry;

    public ApiInquiryWSDTO() {
    }

    public ApiInquiryWSDTO(OperationDBModel operation, SessionDBModel operationSession, OperationInquiryDBModel operationInquiry) {
        this.operation = operation;
        this.operationSession = operationSession;
        this.operationInquiry = operationInquiry;
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

    public OperationInquiryDBModel getOperationInquiry() {
        return operationInquiry;
    }

    public void setOperationInquiry(OperationInquiryDBModel operationInquiry) {
        this.operationInquiry = operationInquiry;
    }
}
