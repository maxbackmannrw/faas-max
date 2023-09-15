package com.faas.core.base.model.ws.process.details.flow.dto;

import com.faas.core.base.model.db.process.details.flow.ProcessFlowDBModel;

public class ProcessFlowWSDTO {

    private ProcessFlowDBModel processFlow;

    public ProcessFlowWSDTO() {
    }

    public ProcessFlowWSDTO(ProcessFlowDBModel processFlow) {
        this.processFlow = processFlow;
    }

    public ProcessFlowDBModel getProcessFlow() {
        return processFlow;
    }

    public void setProcessFlow(ProcessFlowDBModel processFlow) {
        this.processFlow = processFlow;
    }
}
