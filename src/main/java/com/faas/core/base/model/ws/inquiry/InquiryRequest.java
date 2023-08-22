package com.faas.core.base.model.ws.inquiry;

import com.faas.core.base.model.ws.inquiry.dto.InquiryRequestDTO;

import java.util.List;

public class InquiryRequest {

    private List<InquiryRequestDTO>inquiryRequests;

    public InquiryRequest() {
    }

    public InquiryRequest(List<InquiryRequestDTO> inquiryRequests) {
        this.inquiryRequests = inquiryRequests;
    }

    public List<InquiryRequestDTO> getInquiryRequests() {
        return inquiryRequests;
    }

    public void setInquiryRequests(List<InquiryRequestDTO> inquiryRequests) {
        this.inquiryRequests = inquiryRequests;
    }
}
