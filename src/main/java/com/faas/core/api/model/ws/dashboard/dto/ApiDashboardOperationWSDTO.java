package com.faas.core.api.model.ws.dashboard.dto;

import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class ApiDashboardOperationWSDTO {

    private List<ApiOperationWSDTO> operations;
    private PaginationWSDTO pagination;

    public ApiDashboardOperationWSDTO() {
    }

    public ApiDashboardOperationWSDTO(List<ApiOperationWSDTO> operations, PaginationWSDTO pagination) {
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
