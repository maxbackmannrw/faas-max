package com.faas.core.base.model.ws.operation.flow.dto;

import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class OperationFlowCampaignWSDTO {

    private CampaignWSDTO campaign;
    private PaginationWSDTO pagination;
    private List<OperationFlowWSDTO>flows;

    public OperationFlowCampaignWSDTO() {
    }

    public OperationFlowCampaignWSDTO(CampaignWSDTO campaign, PaginationWSDTO pagination, List<OperationFlowWSDTO> flows) {
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

    public List<OperationFlowWSDTO> getFlows() {
        return flows;
    }

    public void setFlows(List<OperationFlowWSDTO> flows) {
        this.flows = flows;
    }
}
