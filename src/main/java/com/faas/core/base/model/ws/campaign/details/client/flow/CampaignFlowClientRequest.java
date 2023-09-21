package com.faas.core.base.model.ws.campaign.details.client.flow;

import com.faas.core.base.model.ws.campaign.details.client.flow.dto.CampaignFlowClientRequestDTO;

import java.util.List;

public class CampaignFlowClientRequest {

    private List<CampaignFlowClientRequestDTO> flowRequests;

    public CampaignFlowClientRequest() {
    }

    public CampaignFlowClientRequest(List<CampaignFlowClientRequestDTO> flowRequests) {
        this.flowRequests = flowRequests;
    }

    public List<CampaignFlowClientRequestDTO> getFlowRequests() {
        return flowRequests;
    }

    public void setFlowRequests(List<CampaignFlowClientRequestDTO> flowRequests) {
        this.flowRequests = flowRequests;
    }

}
