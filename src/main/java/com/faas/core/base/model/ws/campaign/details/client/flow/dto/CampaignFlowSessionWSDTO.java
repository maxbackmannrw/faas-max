package com.faas.core.base.model.ws.campaign.details.client.flow.dto;

import com.faas.core.base.model.ws.operation.flow.dto.OperationFlowSessionWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class CampaignFlowSessionWSDTO {

    private List<OperationFlowSessionWSDTO> flowSessions;
    private PaginationWSDTO pagination;

    public CampaignFlowSessionWSDTO() {
    }

    public CampaignFlowSessionWSDTO(List<OperationFlowSessionWSDTO> flowSessions, PaginationWSDTO pagination) {
        this.flowSessions = flowSessions;
        this.pagination = pagination;
    }

    public List<OperationFlowSessionWSDTO> getFlowSessions() {
        return flowSessions;
    }

    public void setFlowSessions(List<OperationFlowSessionWSDTO> flowSessions) {
        this.flowSessions = flowSessions;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
