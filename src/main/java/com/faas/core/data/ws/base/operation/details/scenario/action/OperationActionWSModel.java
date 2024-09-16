package com.faas.core.data.ws.base.operation.details.scenario.action;

import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.data.ws.base.operation.details.scenario.action.dto.OperationActionWSDTO;

import java.util.List;

public class OperationActionWSModel {

    private GeneralWSModel general;
    private List<OperationActionWSDTO> operationActions;

    public OperationActionWSModel() {
    }

    public OperationActionWSModel(GeneralWSModel general, List<OperationActionWSDTO> operationActions) {
        this.general = general;
        this.operationActions = operationActions;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationActionWSDTO> getOperationActions() {
        return operationActions;
    }

    public void setOperationActions(List<OperationActionWSDTO> operationActions) {
        this.operationActions = operationActions;
    }
}
