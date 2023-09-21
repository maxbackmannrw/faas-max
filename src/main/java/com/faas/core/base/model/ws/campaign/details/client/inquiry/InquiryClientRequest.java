package com.faas.core.base.model.ws.campaign.details.client.inquiry;

import com.faas.core.base.model.ws.campaign.details.client.inquiry.dto.InquiryClientRequestDTO;

import java.util.List;

public class InquiryClientRequest {

    private List<InquiryClientRequestDTO>inquiryRequests;

    public InquiryClientRequest() {
    }

    public InquiryClientRequest(List<InquiryClientRequestDTO> inquiryRequests) {
        this.inquiryRequests = inquiryRequests;
    }

    public List<InquiryClientRequestDTO> getInquiryRequests() {
        return inquiryRequests;
    }

    public void setInquiryRequests(List<InquiryClientRequestDTO> inquiryRequests) {
        this.inquiryRequests = inquiryRequests;
    }
}
