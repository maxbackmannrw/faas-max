package com.faas.core.api.model.ws.client.flow.content.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class ApiFlowWSDTO {

    private List<ApiFlowDTO> flows;
    private PaginationWSDTO pagination;

    public ApiFlowWSDTO() {
    }

    public ApiFlowWSDTO(List<ApiFlowDTO> flows, PaginationWSDTO pagination) {
        this.flows = flows;
        this.pagination = pagination;
    }

    public List<ApiFlowDTO> getFlows() {
        return flows;
    }

    public void setFlows(List<ApiFlowDTO> flows) {
        this.flows = flows;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
