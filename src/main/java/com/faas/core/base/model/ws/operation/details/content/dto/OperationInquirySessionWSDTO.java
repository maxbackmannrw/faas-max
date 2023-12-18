package com.faas.core.base.model.ws.operation.details.content.dto;

import com.faas.core.base.model.db.session.SessionDBModel;

public class OperationInquirySessionWSDTO {

    private SessionDBModel clientSession;

    public OperationInquirySessionWSDTO() {
    }

    public OperationInquirySessionWSDTO(SessionDBModel clientSession) {
        this.clientSession = clientSession;
    }

    public SessionDBModel getClientSession() {
        return clientSession;
    }

    public void setClientSession(SessionDBModel clientSession) {
        this.clientSession = clientSession;
    }
}
