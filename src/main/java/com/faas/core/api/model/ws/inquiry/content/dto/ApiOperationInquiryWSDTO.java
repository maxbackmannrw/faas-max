package com.faas.core.api.model.ws.inquiry.content.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class ApiOperationInquiryWSDTO {

    private List<ApiInquiryWSDTO>inquiries;
    private PaginationWSDTO pagination;

    public ApiOperationInquiryWSDTO() {
    }

    public ApiOperationInquiryWSDTO(List<ApiInquiryWSDTO> inquiries, PaginationWSDTO pagination) {
        this.inquiries = inquiries;
        this.pagination = pagination;
    }

    public List<ApiInquiryWSDTO> getInquiries() {
        return inquiries;
    }

    public void setInquiries(List<ApiInquiryWSDTO> inquiries) {
        this.inquiries = inquiries;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
