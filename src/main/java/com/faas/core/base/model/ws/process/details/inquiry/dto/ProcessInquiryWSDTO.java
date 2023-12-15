package com.faas.core.base.model.ws.process.details.inquiry.dto;

import com.faas.core.base.model.db.process.content.dao.ProcessInquiryDAO;

public class ProcessInquiryWSDTO {

    private ProcessInquiryDAO processInquiry;

    public ProcessInquiryWSDTO() {
    }

    public ProcessInquiryWSDTO(ProcessInquiryDAO processInquiry) {
        this.processInquiry = processInquiry;
    }

    public ProcessInquiryDAO getProcessInquiry() {
        return processInquiry;
    }

    public void setProcessInquiry(ProcessInquiryDAO processInquiry) {
        this.processInquiry = processInquiry;
    }
}
