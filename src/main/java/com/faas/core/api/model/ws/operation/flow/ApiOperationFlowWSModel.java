package com.faas.core.api.model.ws.operation.flow;

import com.faas.core.api.model.ws.operation.flow.dto.ApiOperationFlowWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;


public class ApiOperationFlowWSModel {

    private GeneralWSModel general;
    private List<ApiOperationFlowWSDTO> operationFlows;

    public ApiOperationFlowWSModel() {
    }

    public ApiOperationFlowWSModel(GeneralWSModel general, List<ApiOperationFlowWSDTO> operationFlows) {
        this.general = general;
        this.operationFlows = operationFlows;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationFlowWSDTO> getOperationFlows() {
        return operationFlows;
    }

    public void setOperationFlows(List<ApiOperationFlowWSDTO> operationFlows) {
        this.operationFlows = operationFlows;
    }
}
