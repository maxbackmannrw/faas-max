package com.faas.core.base.model.ws.process.details.flow.dto;

import com.faas.core.base.model.db.process.details.flow.dao.ProcessFlowDataDAO;

public class ProcessFlowDataWSDTO {

    private ProcessFlowDataDAO flowData;

    public ProcessFlowDataWSDTO() {
    }

    public ProcessFlowDataWSDTO(ProcessFlowDataDAO flowData) {
        this.flowData = flowData;
    }

    public ProcessFlowDataDAO getFlowData() {
        return flowData;
    }

    public void setFlowData(ProcessFlowDataDAO flowData) {
        this.flowData = flowData;
    }
}
