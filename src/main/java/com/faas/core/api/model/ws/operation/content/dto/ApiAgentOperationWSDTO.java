package com.faas.core.api.model.ws.operation.content.dto;


public class ApiAgentOperationWSDTO {

    private ApiOperationListWSDTO readyManualOperation;
    private ApiOperationListWSDTO readyInquiryOperation;

    public ApiAgentOperationWSDTO() {
    }

    public ApiAgentOperationWSDTO(ApiOperationListWSDTO readyManualOperation, ApiOperationListWSDTO readyInquiryOperation) {
        this.readyManualOperation = readyManualOperation;
        this.readyInquiryOperation = readyInquiryOperation;
    }

    public ApiOperationListWSDTO getReadyManualOperation() {
        return readyManualOperation;
    }

    public void setReadyManualOperation(ApiOperationListWSDTO readyManualOperation) {
        this.readyManualOperation = readyManualOperation;
    }

    public ApiOperationListWSDTO getReadyInquiryOperation() {
        return readyInquiryOperation;
    }

    public void setReadyInquiryOperation(ApiOperationListWSDTO readyInquiryOperation) {
        this.readyInquiryOperation = readyInquiryOperation;
    }
}
