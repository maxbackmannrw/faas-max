package com.faas.core.base.model.ws.operation.manual.content.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class ManualOperationListWSDTO {

    private List<ManualOperationWSDTO>operations;
    private PaginationWSDTO pagination;

    public ManualOperationListWSDTO() {
    }

    public ManualOperationListWSDTO(List<ManualOperationWSDTO> operations, PaginationWSDTO pagination) {
        this.operations = operations;
        this.pagination = pagination;
    }

    public List<ManualOperationWSDTO> getOperations() {
        return operations;
    }

    public void setOperations(List<ManualOperationWSDTO> operations) {
        this.operations = operations;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
