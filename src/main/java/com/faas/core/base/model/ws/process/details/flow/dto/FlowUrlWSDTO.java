package com.faas.core.base.model.ws.process.details.flow.dto;

import com.faas.core.base.model.db.process.details.flow.dao.FlowUrlDAO;

public class FlowUrlWSDTO {

    private FlowUrlDAO flowUrl;

    public FlowUrlWSDTO() {
    }

    public FlowUrlWSDTO(FlowUrlDAO flowUrl) {
        this.flowUrl = flowUrl;
    }

    public FlowUrlDAO getFlowUrl() {
        return flowUrl;
    }

    public void setFlowUrl(FlowUrlDAO flowUrl) {
        this.flowUrl = flowUrl;
    }
}
