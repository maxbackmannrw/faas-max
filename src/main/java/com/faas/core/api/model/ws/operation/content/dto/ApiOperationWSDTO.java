package com.faas.core.api.model.ws.operation.content.dto;

import com.faas.core.base.model.db.client.flow.ClientFlowDBModel;
import com.faas.core.base.model.db.client.inquiry.ClientInquiryDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;

public class ApiOperationWSDTO {

    private OperationDBModel operation;
    private SessionDBModel operationSession;
    private ClientInquiryDBModel operationInquiry;
    private ClientFlowDBModel operationFlow;

    public ApiOperationWSDTO() {
    }

    public ApiOperationWSDTO(OperationDBModel operation, SessionDBModel operationSession, ClientInquiryDBModel operationInquiry, ClientFlowDBModel operationFlow) {
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

    public ClientInquiryDBModel getOperationInquiry() {
        return operationInquiry;
    }

    public void setOperationInquiry(ClientInquiryDBModel operationInquiry) {
        this.operationInquiry = operationInquiry;
    }

    public ClientFlowDBModel getOperationFlow() {
        return operationFlow;
    }

    public void setOperationFlow(ClientFlowDBModel operationFlow) {
        this.operationFlow = operationFlow;
    }
}
