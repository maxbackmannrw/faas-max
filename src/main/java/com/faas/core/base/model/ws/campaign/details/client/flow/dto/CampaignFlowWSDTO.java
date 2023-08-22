package com.faas.core.base.model.ws.campaign.details.client.flow.dto;

import com.faas.core.base.model.ws.flow.dto.FlowWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class CampaignFlowWSDTO {

    private List<FlowWSDTO> flows;
    private PaginationWSDTO pagination;


    public CampaignFlowWSDTO() {
    }

    public CampaignFlowWSDTO(PaginationWSDTO pagination, List<FlowWSDTO> flows) {
        this.pagination = pagination;
        this.flows = flows;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }

    public List<FlowWSDTO> getFlows() {
        return flows;
    }

    public void setFlows(List<FlowWSDTO> flows) {
        this.flows = flows;
    }
}
