package com.faas.core.api.model.ws.operation.content.dto;

public class ApiAgentOperationWSDTO {

    private ApiOperationListWSDTO inquiryOperation;
    private ApiOperationListWSDTO manualOperation;

    public ApiAgentOperationWSDTO() {
    }

    public ApiAgentOperationWSDTO(ApiOperationListWSDTO inquiryOperation, ApiOperationListWSDTO manualOperation) {
        this.inquiryOperation = inquiryOperation;
        this.manualOperation = manualOperation;
    }

    public ApiOperationListWSDTO getInquiryOperation() {
        return inquiryOperation;
    }

    public void setInquiryOperation(ApiOperationListWSDTO inquiryOperation) {
        this.inquiryOperation = inquiryOperation;
    }

    public ApiOperationListWSDTO getManualOperation() {
        return manualOperation;
    }

    public void setManualOperation(ApiOperationListWSDTO manualOperation) {
        this.manualOperation = manualOperation;
    }
}
