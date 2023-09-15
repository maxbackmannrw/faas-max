package com.faas.core.base.model.ws.process.details.inquiry.dto;

import com.faas.core.base.model.db.process.details.inquiry.ProcessInquiryDBModel;

public class ProcessInquiryWSDTO {

    private ProcessInquiryDBModel processInquiry;

    public ProcessInquiryWSDTO() {
    }

    public ProcessInquiryWSDTO(ProcessInquiryDBModel processInquiry) {
        this.processInquiry = processInquiry;
    }

    public ProcessInquiryDBModel getProcessInquiry() {
        return processInquiry;
    }

    public void setProcessInquiry(ProcessInquiryDBModel processInquiry) {
        this.processInquiry = processInquiry;
    }
}
