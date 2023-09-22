package com.faas.core.base.model.ws.campaign.details.client.flow;

import com.faas.core.base.model.ws.campaign.details.client.flow.dto.CampaignFlowSessionRequestDTO;

import java.util.List;

public class CampaignFlowSessionRequest {

    private List<CampaignFlowSessionRequestDTO> sessionRequests;

    public CampaignFlowSessionRequest() {
    }

    public CampaignFlowSessionRequest(List<CampaignFlowSessionRequestDTO> sessionRequests) {
        this.sessionRequests = sessionRequests;
    }

    public List<CampaignFlowSessionRequestDTO> getSessionRequests() {
        return sessionRequests;
    }

    public void setSessionRequests(List<CampaignFlowSessionRequestDTO> sessionRequests) {
        this.sessionRequests = sessionRequests;
    }
}
