package com.faas.core.base.model.ws.process.details.flow;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.flow.dto.ProcessFlowWSDTO;

import java.util.List;

public class ProcessFlowWSModel {

    private GeneralWSModel general;
    private ProcessFlowWSDTO processFlow;

    public ProcessFlowWSModel() {
    }

    public ProcessFlowWSModel(GeneralWSModel general, ProcessFlowWSDTO processFlow) {
        this.general = general;
        this.processFlow = processFlow;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ProcessFlowWSDTO getProcessFlow() {
        return processFlow;
    }

    public void setProcessFlow(ProcessFlowWSDTO processFlow) {
        this.processFlow = processFlow;
    }
}
