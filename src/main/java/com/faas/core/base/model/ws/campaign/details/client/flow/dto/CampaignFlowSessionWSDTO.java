package com.faas.core.base.model.ws.campaign.details.client.flow.dto;

import com.faas.core.base.model.ws.client.flow.dto.FlowSessionWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class CampaignFlowSessionWSDTO {

    private List<FlowSessionWSDTO> flowSessions;
    private PaginationWSDTO pagination;

    public CampaignFlowSessionWSDTO() {
    }

    public CampaignFlowSessionWSDTO(List<FlowSessionWSDTO> flowSessions, PaginationWSDTO pagination) {
        this.flowSessions = flowSessions;
        this.pagination = pagination;
    }

    public List<FlowSessionWSDTO> getFlowSessions() {
        return flowSessions;
    }

    public void setFlowSessions(List<FlowSessionWSDTO> flowSessions) {
        this.flowSessions = flowSessions;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
