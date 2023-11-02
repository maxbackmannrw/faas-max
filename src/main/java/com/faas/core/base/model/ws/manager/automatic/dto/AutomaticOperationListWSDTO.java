package com.faas.core.base.model.ws.manager.automatic.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class AutomaticOperationListWSDTO {

    private List<AutomaticOperationWSDTO>operations;
    private PaginationWSDTO pagination;

    public AutomaticOperationListWSDTO() {
    }

    public AutomaticOperationListWSDTO(List<AutomaticOperationWSDTO> operations, PaginationWSDTO pagination) {
        this.operations = operations;
        this.pagination = pagination;
    }

    public List<AutomaticOperationWSDTO> getOperations() {
        return operations;
    }

    public void setOperations(List<AutomaticOperationWSDTO> operations) {
        this.operations = operations;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
