package com.faas.core.base.model.ws.campaign.settings.dto;

import com.faas.core.base.model.db.campaign.settings.FlowTypeDBModel;

public class FlowTypeWSDTO {

    private FlowTypeDBModel flowType;

    public FlowTypeWSDTO() {
    }

    public FlowTypeWSDTO(FlowTypeDBModel flowType) {
        this.flowType = flowType;
    }

    public FlowTypeDBModel getFlowType() {
        return flowType;
    }

    public void setFlowType(FlowTypeDBModel flowType) {
        this.flowType = flowType;
    }
}
