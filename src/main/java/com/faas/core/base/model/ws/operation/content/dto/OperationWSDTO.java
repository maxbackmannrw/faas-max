package com.faas.core.base.model.ws.operation.content.dto;

import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.flow.OperationFlowDBModel;
import com.faas.core.base.model.db.operation.details.inquiry.OperationInquiryDBModel;

public class OperationWSDTO {

    private OperationDBModel operation;
    private SessionDBModel operationSession;
    private OperationInquiryDBModel operationInquiry;
    private OperationFlowDBModel operationFlow;

    public OperationWSDTO() {
    }

    public OperationWSDTO(OperationDBModel operation, SessionDBModel operationSession, OperationInquiryDBModel operationInquiry, OperationFlowDBModel operationFlow) {
        this.operation = operation;
        this.operationSession = operationSession;
        this.operationInquiry = operationInquiry;
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

    public OperationInquiryDBModel getOperationInquiry() {
        return operationInquiry;
    }

    public void setOperationInquiry(OperationInquiryDBModel operationInquiry) {
        this.operationInquiry = operationInquiry;
    }

    public OperationFlowDBModel getOperationFlow() {
        return operationFlow;
    }

    public void setOperationFlow(OperationFlowDBModel operationFlow) {
        this.operationFlow = operationFlow;
    }
}
