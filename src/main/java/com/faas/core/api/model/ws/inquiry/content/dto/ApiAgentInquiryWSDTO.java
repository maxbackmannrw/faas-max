package com.faas.core.api.model.ws.inquiry.content.dto;

public class ApiAgentInquiryWSDTO {

    private ApiOperationInquiryWSDTO readyOperationInquiry;
    private ApiOperationInquiryWSDTO activeOperationInquiry;

    public ApiAgentInquiryWSDTO() {
    }

    public ApiAgentInquiryWSDTO(ApiOperationInquiryWSDTO readyOperationInquiry, ApiOperationInquiryWSDTO activeOperationInquiry) {
        this.readyOperationInquiry = readyOperationInquiry;
        this.activeOperationInquiry = activeOperationInquiry;
    }

    public ApiOperationInquiryWSDTO getReadyOperationInquiry() {
        return readyOperationInquiry;
    }

    public void setReadyOperationInquiry(ApiOperationInquiryWSDTO readyOperationInquiry) {
        this.readyOperationInquiry = readyOperationInquiry;
    }

    public ApiOperationInquiryWSDTO getActiveOperationInquiry() {
        return activeOperationInquiry;
    }

    public void setActiveOperationInquiry(ApiOperationInquiryWSDTO activeOperationInquiry) {
        this.activeOperationInquiry = activeOperationInquiry;
    }
}
