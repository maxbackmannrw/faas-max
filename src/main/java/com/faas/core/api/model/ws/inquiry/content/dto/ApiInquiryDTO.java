package com.faas.core.api.model.ws.inquiry.content.dto;

import com.faas.core.base.model.db.client.inquiry.ClientInquiryDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;

public class ApiInquiryDTO {

    private ClientInquiryDBModel inquiry;
    private SessionDBModel inquirySession;

    public ApiInquiryDTO() {
    }

    public ApiInquiryDTO(ClientInquiryDBModel inquiry, SessionDBModel inquirySession) {
        this.inquiry = inquiry;
        this.inquirySession = inquirySession;
    }

    public ClientInquiryDBModel getInquiry() {
        return inquiry;
    }

    public void setInquiry(ClientInquiryDBModel inquiry) {
        this.inquiry = inquiry;
    }

    public SessionDBModel getInquirySession() {
        return inquirySession;
    }

    public void setInquirySession(SessionDBModel inquirySession) {
        this.inquirySession = inquirySession;
    }
}
