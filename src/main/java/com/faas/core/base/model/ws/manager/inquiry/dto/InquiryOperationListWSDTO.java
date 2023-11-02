package com.faas.core.base.model.ws.manager.inquiry.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class InquiryOperationListWSDTO {

    private List<InquiryOperationWSDTO>operations;
    private PaginationWSDTO pagination;

    public InquiryOperationListWSDTO() {
    }

    public InquiryOperationListWSDTO(List<InquiryOperationWSDTO> operations, PaginationWSDTO pagination) {
        this.operations = operations;
        this.pagination = pagination;
    }

    public List<InquiryOperationWSDTO> getOperations() {
        return operations;
    }

    public void setOperations(List<InquiryOperationWSDTO> operations) {
        this.operations = operations;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
