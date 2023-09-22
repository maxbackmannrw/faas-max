package com.faas.core.base.model.ws.client.inquiry.dto;

import com.faas.core.base.model.db.client.inquiry.ClientInquiryDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;

public class InquirySessionWSDTO {

    private SessionDBModel clientSession;
    private ClientInquiryDBModel clientInquiry;

    public InquirySessionWSDTO() {
    }

    public InquirySessionWSDTO(SessionDBModel clientSession, ClientInquiryDBModel clientInquiry) {
        this.clientSession = clientSession;
        this.clientInquiry = clientInquiry;
    }

    public SessionDBModel getClientSession() {
        return clientSession;
    }

    public void setClientSession(SessionDBModel clientSession) {
        this.clientSession = clientSession;
    }

    public ClientInquiryDBModel getClientInquiry() {
        return clientInquiry;
    }

    public void setClientInquiry(ClientInquiryDBModel clientInquiry) {
        this.clientInquiry = clientInquiry;
    }
}
