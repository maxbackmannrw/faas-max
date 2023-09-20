package com.faas.core.base.model.ws.campaign.details.client.flow.dto;

import com.faas.core.base.model.ws.client.flow.dto.ClientFlowWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class CampaignFlowWSDTO {

    private List<ClientFlowWSDTO> flows;
    private PaginationWSDTO pagination;

    public CampaignFlowWSDTO() {
    }

    public CampaignFlowWSDTO(PaginationWSDTO pagination, List<ClientFlowWSDTO> flows) {
        this.pagination = pagination;
        this.flows = flows;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }

    public List<ClientFlowWSDTO> getFlows() {
        return flows;
    }

    public void setFlows(List<ClientFlowWSDTO> flows) {
        this.flows = flows;
    }
}
