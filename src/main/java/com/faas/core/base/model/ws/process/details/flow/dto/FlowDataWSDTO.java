package com.faas.core.base.model.ws.process.details.flow.dto;

import com.faas.core.base.model.db.process.details.flow.dao.FlowDataDAO;

public class FlowDataWSDTO {

    private FlowDataDAO flowData;

    public FlowDataWSDTO() {
    }

    public FlowDataWSDTO(FlowDataDAO flowData) {
        this.flowData = flowData;
    }

    public FlowDataDAO getFlowData() {
        return flowData;
    }

    public void setFlowData(FlowDataDAO flowData) {
        this.flowData = flowData;
    }
}
