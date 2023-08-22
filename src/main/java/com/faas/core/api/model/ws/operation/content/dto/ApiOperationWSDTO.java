package com.faas.core.api.model.ws.operation.content.dto;

import com.faas.core.base.model.db.flow.FlowDBModel;
import com.faas.core.base.model.db.inquiry.InquiryDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;

public class ApiOperationWSDTO {

    private OperationDBModel operation;
    private SessionDBModel operationSession;
    private InquiryDBModel operationInquiry;
    private FlowDBModel operationFlow;

    public ApiOperationWSDTO() {
    }

    public ApiOperationWSDTO(OperationDBModel operation, SessionDBModel operationSession, InquiryDBModel operationInquiry, FlowDBModel operationFlow) {
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

    public InquiryDBModel getOperationInquiry() {
        return operationInquiry;
    }

    public void setOperationInquiry(InquiryDBModel operationInquiry) {
        this.operationInquiry = operationInquiry;
    }

    public FlowDBModel getOperationFlow() {
        return operationFlow;
    }

    public void setOperationFlow(FlowDBModel operationFlow) {
        this.operationFlow = operationFlow;
    }
}
