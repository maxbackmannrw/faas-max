package com.faas.core.base.model.ws.campaign.manager.client;

import com.faas.core.base.model.ws.campaign.manager.client.dto.CampaignClientRequestDTO;

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
