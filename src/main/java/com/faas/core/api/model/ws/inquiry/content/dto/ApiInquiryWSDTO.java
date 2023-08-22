package com.faas.core.api.model.ws.inquiry.content.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class ApiInquiryWSDTO {

    private List<ApiInquiryDTO> inquiries;
    private PaginationWSDTO pagination;

    public ApiInquiryWSDTO() {
    }

    public ApiInquiryWSDTO(List<ApiInquiryDTO> inquiries, PaginationWSDTO pagination) {
        this.inquiries = inquiries;
        this.pagination = pagination;
    }

    public List<ApiInquiryDTO> getInquiries() {
        return inquiries;
    }

    public void setInquiries(List<ApiInquiryDTO> inquiries) {
        this.inquiries = inquiries;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
