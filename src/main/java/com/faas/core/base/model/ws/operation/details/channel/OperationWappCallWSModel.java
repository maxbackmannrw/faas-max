package com.faas.core.base.model.ws.operation.details.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.channel.dto.OperationWappCallWSDTO;

import java.util.List;

public class OperationWappCallWSModel {

    private GeneralWSModel general;
    private List<OperationWappCallWSDTO>operationWappCalls;

    public OperationWappCallWSModel() {
    }

    public OperationWappCallWSModel(GeneralWSModel general, List<OperationWappCallWSDTO> operationWappCalls) {
        this.general = general;
        this.operationWappCalls = operationWappCalls;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationWappCallWSDTO> getOperationWappCalls() {
        return operationWappCalls;
    }

    public void setOperationWappCalls(List<OperationWappCallWSDTO> operationWappCalls) {
        this.operationWappCalls = operationWappCalls;
    }
}
