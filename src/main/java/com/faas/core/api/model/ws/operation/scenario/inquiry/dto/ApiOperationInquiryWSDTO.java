package com.faas.core.api.model.ws.operation.scenario.inquiry.dto;

import com.faas.core.base.model.db.operation.inquiry.OperationInquiryDBModel;

public class ApiOperationInquiryWSDTO {

    private OperationInquiryDBModel operationInquiry;

    public ApiOperationInquiryWSDTO() {
    }

    public ApiOperationInquiryWSDTO(OperationInquiryDBModel operationInquiry) {
        this.operationInquiry = operationInquiry;
    }

    public OperationInquiryDBModel getOperationInquiry() {
        return operationInquiry;
    }

    public void setOperationInquiry(OperationInquiryDBModel operationInquiry) {
        this.operationInquiry = operationInquiry;
    }
}
