package com.faas.core.api.model.ws.client.flow.content.dto;

public class ApiAgentFlowWSDTO {

    private ApiFlowWSDTO readyFlow;
    private ApiFlowWSDTO activeFlow;

    public ApiAgentFlowWSDTO() {
    }

    public ApiAgentFlowWSDTO(ApiFlowWSDTO readyFlow, ApiFlowWSDTO activeFlow) {
        this.readyFlow = readyFlow;
        this.activeFlow = activeFlow;
    }

    public ApiFlowWSDTO getReadyFlow() {
        return readyFlow;
    }

    public void setReadyFlow(ApiFlowWSDTO readyFlow) {
        this.readyFlow = readyFlow;
    }

    public ApiFlowWSDTO getActiveFlow() {
        return activeFlow;
    }

    public void setActiveFlow(ApiFlowWSDTO activeFlow) {
        this.activeFlow = activeFlow;
    }
}
