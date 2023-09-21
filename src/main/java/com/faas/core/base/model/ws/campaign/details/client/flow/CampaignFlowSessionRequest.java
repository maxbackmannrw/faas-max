package com.faas.core.base.model.ws.campaign.details.client.flow;

import com.faas.core.base.model.ws.campaign.details.client.flow.dto.CampaignFlowSessionRequestDTO;

import java.util.List;

public class CampaignFlowSessionRequest {

    private List<CampaignFlowSessionRequestDTO> flowRequests;

    public CampaignFlowSessionRequest() {
    }

    public CampaignFlowSessionRequest(List<CampaignFlowSessionRequestDTO> flowRequests) {
        this.flowRequests = flowRequests;
    }

    public List<CampaignFlowSessionRequestDTO> getFlowRequests() {
        return flowRequests;
    }

    public void setFlowRequests(List<CampaignFlowSessionRequestDTO> flowRequests) {
        this.flowRequests = flowRequests;
    }

}
