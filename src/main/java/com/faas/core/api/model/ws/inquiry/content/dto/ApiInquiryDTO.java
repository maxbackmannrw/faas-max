package com.faas.core.api.model.ws.inquiry.content.dto;

import com.faas.core.base.model.db.inquiry.InquiryDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;

public class ApiInquiryDTO {

    private InquiryDBModel inquiry;
    private SessionDBModel inquirySession;

    public ApiInquiryDTO() {
    }

    public ApiInquiryDTO(InquiryDBModel inquiry, SessionDBModel inquirySession) {
        this.inquiry = inquiry;
        this.inquirySession = inquirySession;
    }

    public InquiryDBModel getInquiry() {
        return inquiry;
    }

    public void setInquiry(InquiryDBModel inquiry) {
        this.inquiry = inquiry;
    }

    public SessionDBModel getInquirySession() {
        return inquirySession;
    }

    public void setInquirySession(SessionDBModel inquirySession) {
        this.inquirySession = inquirySession;
    }
}
