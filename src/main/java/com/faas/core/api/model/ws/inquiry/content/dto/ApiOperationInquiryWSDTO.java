package com.faas.core.api.model.ws.inquiry.content.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class ApiOperationInquiryWSDTO {

    private List<ApiInquiryWSDTO>operationInquiries;
    private PaginationWSDTO pagination;

    public ApiOperationInquiryWSDTO() {
    }

    public ApiOperationInquiryWSDTO(List<ApiInquiryWSDTO> operationInquiries, PaginationWSDTO pagination) {
        this.operationInquiries = operationInquiries;
        this.pagination = pagination;
    }

    public List<ApiInquiryWSDTO> getOperationInquiries() {
        return operationInquiries;
    }

    public void setOperationInquiries(List<ApiInquiryWSDTO> operationInquiries) {
        this.operationInquiries = operationInquiries;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
