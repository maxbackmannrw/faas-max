package com.faas.core.api.model.ws.inquiry.content.dto;

public class ApiAgentInquiryWSDTO {

    private ApiInquiryWSDTO readyInquiry;
    private ApiInquiryWSDTO activeInquiry;

    public ApiAgentInquiryWSDTO() {
    }

    public ApiAgentInquiryWSDTO(ApiInquiryWSDTO readyInquiry, ApiInquiryWSDTO activeInquiry) {
        this.readyInquiry = readyInquiry;
        this.activeInquiry = activeInquiry;
    }

    public ApiInquiryWSDTO getReadyInquiry() {
        return readyInquiry;
    }

    public void setReadyInquiry(ApiInquiryWSDTO readyInquiry) {
        this.readyInquiry = readyInquiry;
    }

    public ApiInquiryWSDTO getActiveInquiry() {
        return activeInquiry;
    }

    public void setActiveInquiry(ApiInquiryWSDTO activeInquiry) {
        this.activeInquiry = activeInquiry;
    }
}
