package com.faas.core.base.model.ws.operation.details.inquiry.dto;

import com.faas.core.base.model.db.operation.details.inquiry.OperationInquiryDBModel;

public class InquiryOperationWSDTO {

    private OperationInquiryDBModel clientInquiry;

    public InquiryOperationWSDTO() {
    }

    public InquiryOperationWSDTO(OperationInquiryDBModel clientInquiry) {
        this.clientInquiry = clientInquiry;
    }

    public OperationInquiryDBModel getClientInquiry() {
        return clientInquiry;
    }

    public void setClientInquiry(OperationInquiryDBModel clientInquiry) {
        this.clientInquiry = clientInquiry;
    }
}
