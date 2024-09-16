package com.faas.core.data.ws.base.campaign.manager.operation.dto;

import com.faas.core.data.ws.base.general.PaginationWSDTO;
import com.faas.core.data.ws.base.operation.content.dto.OperationWSDTO;

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
