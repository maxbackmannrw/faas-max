package com.faas.core.base.model.ws.operation.manager.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.manager.details.dto.OperationManagerDetailsWSDTO;

public class OperationManagerDetailsWSModel {

    private GeneralWSModel general;
    private OperationManagerDetailsWSDTO operationManagerDetails;

    public OperationManagerDetailsWSModel() {
    }

    public OperationManagerDetailsWSModel(GeneralWSModel general, OperationManagerDetailsWSDTO operationManagerDetails) {
        this.general = general;
        this.operationManagerDetails = operationManagerDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public OperationManagerDetailsWSDTO getOperationManagerDetails() {
        return operationManagerDetails;
    }

    public void setOperationManagerDetails(OperationManagerDetailsWSDTO operationManagerDetails) {
        this.operationManagerDetails = operationManagerDetails;
    }
}
