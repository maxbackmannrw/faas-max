package com.faas.core.api.model.ws.client.inquiry.content.dto;

import com.faas.core.base.model.db.operation.inquiry.OperationInquiryDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;

public class ApiInquiryDTO {

    private OperationInquiryDBModel inquiry;
    private SessionDBModel inquirySession;

    public ApiInquiryDTO() {
    }

    public ApiInquiryDTO(OperationInquiryDBModel inquiry, SessionDBModel inquirySession) {
        this.inquiry = inquiry;
        this.inquirySession = inquirySession;
    }

    public OperationInquiryDBModel getInquiry() {
        return inquiry;
    }

    public void setInquiry(OperationInquiryDBModel inquiry) {
        this.inquiry = inquiry;
    }

    public SessionDBModel getInquirySession() {
        return inquirySession;
    }

    public void setInquirySession(SessionDBModel inquirySession) {
        this.inquirySession = inquirySession;
    }
}
