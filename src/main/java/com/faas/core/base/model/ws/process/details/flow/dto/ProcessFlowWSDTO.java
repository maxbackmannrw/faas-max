package com.faas.core.base.model.ws.process.details.flow.dto;

import com.faas.core.base.model.db.process.content.dao.ProcessFlowDAO;

public class ProcessFlowWSDTO {

    private ProcessFlowDAO processFlow;

    public ProcessFlowWSDTO() {
    }

    public ProcessFlowWSDTO(ProcessFlowDAO processFlow) {
        this.processFlow = processFlow;
    }

    public ProcessFlowDAO getProcessFlow() {
        return processFlow;
    }

    public void setProcessFlow(ProcessFlowDAO processFlow) {
        this.processFlow = processFlow;
    }
}
