package com.faas.core.base.model.ws.process.details.inquiry.dto;

import com.faas.core.base.model.db.process.details.inquiry.dao.InquiryUrlDAO;

public class InquiryUrlWSDTO {

    private InquiryUrlDAO inquiryUrl;

    public InquiryUrlWSDTO() {
    }

    public InquiryUrlWSDTO(InquiryUrlDAO inquiryUrl) {
        this.inquiryUrl = inquiryUrl;
    }

    public InquiryUrlDAO getInquiryUrl() {
        return inquiryUrl;
    }

    public void setInquiryUrl(InquiryUrlDAO inquiryUrl) {
        this.inquiryUrl = inquiryUrl;
    }
}
