package com.faas.core.api.model.ws.client.details.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class ApiClientInquiryWSDTO {

    private List<ApiClientInquiryContent>clientInquiries;
    private PaginationWSDTO pagination;

    public ApiClientInquiryWSDTO() {
    }

    public ApiClientInquiryWSDTO(List<ApiClientInquiryContent> clientInquiries, PaginationWSDTO pagination) {
        this.clientInquiries = clientInquiries;
        this.pagination = pagination;
    }

    public List<ApiClientInquiryContent> getClientInquiries() {
        return clientInquiries;
    }

    public void setClientInquiries(List<ApiClientInquiryContent> clientInquiries) {
        this.clientInquiries = clientInquiries;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
