package com.faas.core.base.model.ws.operation.inquiry.dto;

import com.faas.core.base.model.db.operation.inquiry.OperationInquiryDBModel;

public class OperationInquiryWSDTO {

    private OperationInquiryDBModel clientInquiry;

    public OperationInquiryWSDTO() {
    }

    public OperationInquiryWSDTO(OperationInquiryDBModel clientInquiry) {
        this.clientInquiry = clientInquiry;
    }

    public OperationInquiryDBModel getClientInquiry() {
        return clientInquiry;
    }

    public void setClientInquiry(OperationInquiryDBModel clientInquiry) {
        this.clientInquiry = clientInquiry;
    }
}
