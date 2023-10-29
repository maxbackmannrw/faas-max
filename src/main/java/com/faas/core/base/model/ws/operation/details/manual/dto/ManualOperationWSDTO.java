package com.faas.core.base.model.ws.operation.details.manual.dto;

import com.faas.core.base.model.db.operation.details.inquiry.OperationInquiryDBModel;

public class ManualOperationWSDTO {

    private OperationInquiryDBModel clientInquiry;

    public ManualOperationWSDTO() {
    }

    public ManualOperationWSDTO(OperationInquiryDBModel clientInquiry) {
        this.clientInquiry = clientInquiry;
    }

    public OperationInquiryDBModel getClientInquiry() {
        return clientInquiry;
    }

    public void setClientInquiry(OperationInquiryDBModel clientInquiry) {
        this.clientInquiry = clientInquiry;
    }
}
