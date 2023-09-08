package com.faas.core.base.model.ws.client.flow.dto;

import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class FlowCampaignWSDTO {

    private CampaignWSDTO campaign;
    private PaginationWSDTO pagination;
    private List<FlowWSDTO>flows;

    public FlowCampaignWSDTO() {
    }

    public FlowCampaignWSDTO(CampaignWSDTO campaign, PaginationWSDTO pagination, List<FlowWSDTO> flows) {
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

    public List<FlowWSDTO> getFlows() {
        return flows;
    }

    public void setFlows(List<FlowWSDTO> flows) {
        this.flows = flows;
    }
}
