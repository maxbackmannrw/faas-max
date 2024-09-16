package com.faas.core.data.ws.base.operation.details.content;

import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.data.ws.base.operation.details.content.dto.OperationDetailsWSDTO;

public class OperationDetailsWSModel {

    private GeneralWSModel general;
    private OperationDetailsWSDTO operationDetails;

    public OperationDetailsWSModel() {
    }

    public OperationDetailsWSModel(GeneralWSModel general, OperationDetailsWSDTO operationDetails) {
        this.general = general;
        this.operationDetails = operationDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public OperationDetailsWSDTO getOperationDetails() {
        return operationDetails;
    }

    public void setOperationDetails(OperationDetailsWSDTO operationDetails) {
        this.operationDetails = operationDetails;
    }
}
