package com.faas.core.base.model.ws.campaign.details.client.manual;

import com.faas.core.base.model.ws.campaign.details.client.manual.dto.CampaignManualClientRequestDTO;

import java.util.List;

public class CampaignManualClientRequest {

    private List<CampaignManualClientRequestDTO>clientRequests;

    public CampaignManualClientRequest() {
    }

    public CampaignManualClientRequest(List<CampaignManualClientRequestDTO> clientRequests) {
        this.clientRequests = clientRequests;
    }

    public List<CampaignManualClientRequestDTO> getClientRequests() {
        return clientRequests;
    }

    public void setClientRequests(List<CampaignManualClientRequestDTO> clientRequests) {
        this.clientRequests = clientRequests;
    }
}
