package com.faas.core.base.model.ws.client.flow.dto;

import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class FlowCampaignWSDTO {

    private CampaignWSDTO campaign;
    private PaginationWSDTO pagination;
    private List<ClientFlowWSDTO>flows;

    public FlowCampaignWSDTO() {
    }

    public FlowCampaignWSDTO(CampaignWSDTO campaign, PaginationWSDTO pagination, List<ClientFlowWSDTO> flows) {
        this.campaign = campaign;
        this.pagination = pagination;
        this.flows = flows;
    }

    public CampaignWSDTO getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignWSDTO campaign) {
        this.campaign = campaign;
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
