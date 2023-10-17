package com.faas.core.api.model.ws.client.flow.content.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class ApiClientFlowWSDTO {

    private List<ApiClientFlowContent> clientFlows;
    private PaginationWSDTO pagination;

    public ApiClientFlowWSDTO() {
    }

    public ApiClientFlowWSDTO(List<ApiClientFlowContent> clientFlows, PaginationWSDTO pagination) {
        this.clientFlows = clientFlows;
        this.pagination = pagination;
    }

    public List<ApiClientFlowContent> getClientFlows() {
        return clientFlows;
    }

    public void setClientFlows(List<ApiClientFlowContent> clientFlows) {
        this.clientFlows = clientFlows;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
