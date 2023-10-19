package com.faas.core.api.model.ws.flow.content.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class ApiOperationFlowWSDTO {

    private List<ApiOperationFlowContent> clientFlows;
    private PaginationWSDTO pagination;

    public ApiOperationFlowWSDTO() {
    }

    public ApiOperationFlowWSDTO(List<ApiOperationFlowContent> clientFlows, PaginationWSDTO pagination) {
        this.clientFlows = clientFlows;
        this.pagination = pagination;
    }

    public List<ApiOperationFlowContent> getClientFlows() {
        return clientFlows;
    }

    public void setClientFlows(List<ApiOperationFlowContent> clientFlows) {
        this.clientFlows = clientFlows;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
