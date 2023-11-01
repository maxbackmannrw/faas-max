package com.faas.core.base.model.ws.operation.inquiry.dto;

import com.faas.core.base.model.db.operation.details.inquiry.OperationInquiryDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;

public class OperationInquirySessionWSDTO {

    private SessionDBModel clientSession;
    private OperationInquiryDBModel clientInquiry;

    public OperationInquirySessionWSDTO() {
    }

    public OperationInquirySessionWSDTO(SessionDBModel clientSession, OperationInquiryDBModel clientInquiry) {
        this.clientSession = clientSession;
        this.clientInquiry = clientInquiry;
    }

    public SessionDBModel getClientSession() {
        return clientSession;
    }

    public void setClientSession(SessionDBModel clientSession) {
        this.clientSession = clientSession;
    }

    public OperationInquiryDBModel getClientInquiry() {
        return clientInquiry;
    }

    public void setClientInquiry(OperationInquiryDBModel clientInquiry) {
        this.clientInquiry = clientInquiry;
    }
}
