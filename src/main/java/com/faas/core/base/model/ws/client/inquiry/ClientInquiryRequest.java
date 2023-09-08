package com.faas.core.base.model.ws.client.inquiry;

import com.faas.core.base.model.ws.client.inquiry.dto.ClientInquiryRequestDTO;

import java.util.List;

public class ClientInquiryRequest {

    private List<ClientInquiryRequestDTO>inquiryRequests;

    public ClientInquiryRequest() {
    }

    public ClientInquiryRequest(List<ClientInquiryRequestDTO> inquiryRequests) {
        this.inquiryRequests = inquiryRequests;
    }

    public List<ClientInquiryRequestDTO> getInquiryRequests() {
        return inquiryRequests;
    }

    public void setInquiryRequests(List<ClientInquiryRequestDTO> inquiryRequests) {
        this.inquiryRequests = inquiryRequests;
    }
}
