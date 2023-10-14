package com.faas.core.api.model.ws.operation.content.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class ApiOperationSessionWSDTO {

    private List<ApiOperationWSDTO> operations;
    private PaginationWSDTO pagination;

    public ApiOperationSessionWSDTO() {
    }

    public ApiOperationSessionWSDTO(List<ApiOperationWSDTO> operations, PaginationWSDTO pagination) {
        this.operations = operations;
        this.pagination = pagination;
    }

    public List<ApiOperationWSDTO> getOperations() {
        return operations;
    }

    public void setOperations(List<ApiOperationWSDTO> operations) {
        this.operations = operations;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
