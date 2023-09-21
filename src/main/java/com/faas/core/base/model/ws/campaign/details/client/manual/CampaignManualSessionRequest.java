package com.faas.core.base.model.ws.campaign.details.client.manual;

import com.faas.core.base.model.ws.campaign.details.client.manual.dto.CampaignManualSessionRequestDTO;

import java.util.List;

public class CampaignManualSessionRequest {

    private List<CampaignManualSessionRequestDTO>clientRequests;

    public CampaignManualSessionRequest() {
    }

    public CampaignManualSessionRequest(List<CampaignManualSessionRequestDTO> clientRequests) {
        this.clientRequests = clientRequests;
    }

    public List<CampaignManualSessionRequestDTO> getClientRequests() {
        return clientRequests;
    }

    public void setClientRequests(List<CampaignManualSessionRequestDTO> clientRequests) {
        this.clientRequests = clientRequests;
    }
}
