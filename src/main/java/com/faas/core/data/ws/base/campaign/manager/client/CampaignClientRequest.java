package com.faas.core.data.ws.base.campaign.manager.client;

import com.faas.core.data.ws.base.campaign.manager.client.dto.CampaignClientRequestDTO;

import java.util.List;

public class CampaignClientRequest {

    private List<CampaignClientRequestDTO> clientRequests;

    public CampaignClientRequest() {
    }

    public CampaignClientRequest(List<CampaignClientRequestDTO> clientRequests) {
        this.clientRequests = clientRequests;
    }

    public List<CampaignClientRequestDTO> getClientRequests() {
        return clientRequests;
    }

    public void setClientRequests(List<CampaignClientRequestDTO> clientRequests) {
        this.clientRequests = clientRequests;
    }
}
