package com.faas.core.base.model.ws.campaign.details.client.flow;

import com.faas.core.base.model.ws.campaign.details.client.flow.dto.FlowClientRequestDTO;

import java.util.List;

public class FlowClientRequest {

    private List<FlowClientRequestDTO> flowRequests;

    public FlowClientRequest() {
    }

    public FlowClientRequest(List<FlowClientRequestDTO> flowRequests) {
        this.flowRequests = flowRequests;
    }

    public List<FlowClientRequestDTO> getFlowRequests() {
        return flowRequests;
    }

    public void setFlowRequests(List<FlowClientRequestDTO> flowRequests) {
        this.flowRequests = flowRequests;
    }

}
