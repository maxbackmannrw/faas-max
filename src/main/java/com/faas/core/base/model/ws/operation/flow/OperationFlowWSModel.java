package com.faas.core.base.model.ws.operation.flow;

import com.faas.core.base.model.ws.operation.flow.dto.OperationFlowWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class OperationFlowWSModel {

    private GeneralWSModel general;
    private List<OperationFlowWSDTO>operationFlows;

    public OperationFlowWSModel() {
    }

    public OperationFlowWSModel(GeneralWSModel general, List<OperationFlowWSDTO> operationFlows) {
        this.general = general;
        this.operationFlows = operationFlows;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationFlowWSDTO> getOperationFlows() {
        return operationFlows;
    }

    public void setOperationFlows(List<OperationFlowWSDTO> operationFlows) {
        this.operationFlows = operationFlows;
    }
}
