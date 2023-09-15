package com.faas.core.base.model.ws.process.details.inquiry.dto;

import com.faas.core.base.model.db.process.details.inquiry.dao.InquiryDataDAO;

public class InquiryDataWSDTO {

    private InquiryDataDAO inquiryData;

    public InquiryDataWSDTO() {
    }

    public InquiryDataWSDTO(InquiryDataDAO inquiryData) {
        this.inquiryData = inquiryData;
    }

    public InquiryDataDAO getInquiryData() {
        return inquiryData;
    }

    public void setInquiryData(InquiryDataDAO inquiryData) {
        this.inquiryData = inquiryData;
    }
}
