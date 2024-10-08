package com.faas.core.base.model.ws.campaign.manager.operation.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;

import java.util.List;

public class CampaignOperationWSDTO {

    private List<OperationWSDTO> operations;
    private PaginationWSDTO pagination;

    public CampaignOperationWSDTO() {
    }

    public CampaignOperationWSDTO(List<OperationWSDTO> operations, PaginationWSDTO pagination) {
        this.operations = operations;
        this.pagination = pagination;
    }

    public List<OperationWSDTO> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationWSDTO> operations) {
        this.operations = operations;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
