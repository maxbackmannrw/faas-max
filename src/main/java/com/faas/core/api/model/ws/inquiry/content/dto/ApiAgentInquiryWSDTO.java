package com.faas.core.api.model.ws.inquiry.content.dto;

public class ApiAgentInquiryWSDTO {

    private ApiOperationInquiryWSDTO readyInquiry;
    private ApiOperationInquiryWSDTO activeInquiry;

    public ApiAgentInquiryWSDTO() {
    }

    public ApiAgentInquiryWSDTO(ApiOperationInquiryWSDTO readyInquiry, ApiOperationInquiryWSDTO activeInquiry) {
        this.readyInquiry = readyInquiry;
        this.activeInquiry = activeInquiry;
    }

    public ApiOperationInquiryWSDTO getReadyInquiry() {
        return readyInquiry;
    }

    public void setReadyInquiry(ApiOperationInquiryWSDTO readyInquiry) {
        this.readyInquiry = readyInquiry;
    }

    public ApiOperationInquiryWSDTO getActiveInquiry() {
        return activeInquiry;
    }

    public void setActiveInquiry(ApiOperationInquiryWSDTO activeInquiry) {
        this.activeInquiry = activeInquiry;
    }
}
