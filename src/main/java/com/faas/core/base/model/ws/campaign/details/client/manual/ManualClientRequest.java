package com.faas.core.base.model.ws.campaign.details.client.manual;

import com.faas.core.base.model.ws.campaign.details.client.manual.dto.ManualClientRequestDTO;

import java.util.List;

public class ManualClientRequest {

    private List<ManualClientRequestDTO>clientRequests;

    public ManualClientRequest() {
    }

    public ManualClientRequest(List<ManualClientRequestDTO> clientRequests) {
        this.clientRequests = clientRequests;
    }

    public List<ManualClientRequestDTO> getClientRequests() {
        return clientRequests;
    }

    public void setClientRequests(List<ManualClientRequestDTO> clientRequests) {
        this.clientRequests = clientRequests;
    }
}
