package com.faas.core.base.model.ws.process.details.inquiry.dto;

import com.faas.core.base.model.db.process.details.inquiry.dao.ProcessInquiryDataDAO;

public class ProcessInquiryDataWSDTO {

    private ProcessInquiryDataDAO inquiryData;

    public ProcessInquiryDataWSDTO() {
    }

    public ProcessInquiryDataWSDTO(ProcessInquiryDataDAO inquiryData) {
        this.inquiryData = inquiryData;
    }

    public ProcessInquiryDataDAO getInquiryData() {
        return inquiryData;
    }

    public void setInquiryData(ProcessInquiryDataDAO inquiryData) {
        this.inquiryData = inquiryData;
    }
}
