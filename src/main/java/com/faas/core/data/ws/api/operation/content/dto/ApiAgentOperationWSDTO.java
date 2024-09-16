package com.faas.core.data.ws.api.operation.content.dto;

public class ApiAgentOperationWSDTO {

    private ApiOperationListWSDTO readyManualOperation;
    private ApiOperationListWSDTO activeManualOperation;
    private ApiOperationListWSDTO readyInquiryOperation;
    private ApiOperationListWSDTO activeInquiryOperation;

    public ApiAgentOperationWSDTO() {
    }

    public ApiAgentOperationWSDTO(ApiOperationListWSDTO readyManualOperation, ApiOperationListWSDTO activeManualOperation, ApiOperationListWSDTO readyInquiryOperation, ApiOperationListWSDTO activeInquiryOperation) {
        this.readyManualOperation = readyManualOperation;
        this.activeManualOperation = activeManualOperation;
        this.readyInquiryOperation = readyInquiryOperation;
        this.activeInquiryOperation = activeInquiryOperation;
    }

    public ApiOperationListWSDTO getReadyManualOperation() {
        return readyManualOperation;
    }

    public void setReadyManualOperation(ApiOperationListWSDTO readyManualOperation) {
        this.readyManualOperation = readyManualOperation;
    }

    public ApiOperationListWSDTO getActiveManualOperation() {
        return activeManualOperation;
    }

    public void setActiveManualOperation(ApiOperationListWSDTO activeManualOperation) {
        this.activeManualOperation = activeManualOperation;
    }

    public ApiOperationListWSDTO getReadyInquiryOperation() {
        return readyInquiryOperation;
    }

    public void setReadyInquiryOperation(ApiOperationListWSDTO readyInquiryOperation) {
        this.readyInquiryOperation = readyInquiryOperation;
    }

    public ApiOperationListWSDTO getActiveInquiryOperation() {
        return activeInquiryOperation;
    }

    public void setActiveInquiryOperation(ApiOperationListWSDTO activeInquiryOperation) {
        this.activeInquiryOperation = activeInquiryOperation;
    }
}
