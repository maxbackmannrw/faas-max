package com.faas.core.api.model.ws.inquiry.content.dto;

import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.db.operation.inquiry.OperationInquiryDBModel;

public class ApiInquiryWSDTO {

    private SessionDBModel operationSession;
    private OperationInquiryDBModel operationInquiry;

    public ApiInquiryWSDTO() {
    }

    public ApiInquiryWSDTO(SessionDBModel operationSession, OperationInquiryDBModel operationInquiry) {
        this.operationSession = operationSession;
        this.operationInquiry = operationInquiry;
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
