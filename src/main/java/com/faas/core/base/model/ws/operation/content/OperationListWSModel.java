package com.faas.core.base.model.ws.operation.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;

public class OperationListWSModel {

    private GeneralWSModel general;
    private OperationListWSDTO operationList;

    public OperationListWSModel() {
    }

    public OperationListWSModel(GeneralWSModel general, OperationListWSDTO operationList) {
        this.general = general;
        this.operationList = operationList;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public OperationListWSDTO getOperationList() {
        return operationList;
    }

    public void setOperationList(OperationListWSDTO operationList) {
        this.operationList = operationList;
    }
}
