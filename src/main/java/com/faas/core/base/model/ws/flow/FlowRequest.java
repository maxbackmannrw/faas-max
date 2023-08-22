package com.faas.core.base.model.ws.flow;

import com.faas.core.base.model.ws.flow.dto.FlowRequestDTO;

import java.util.List;

public class FlowRequest {

    private List<FlowRequestDTO> flowRequests;

    public FlowRequest() {
    }

    public FlowRequest(List<FlowRequestDTO> flowRequests) {
        this.flowRequests = flowRequests;
    }

    public List<FlowRequestDTO> getFlowRequests() {
        return flowRequests;
    }

    public void setFlowRequests(List<FlowRequestDTO> flowRequests) {
        this.flowRequests = flowRequests;
    }

}
