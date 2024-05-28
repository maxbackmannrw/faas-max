package com.faas.core.base.model.ws.operation.manager.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.manager.content.dto.OperationManagerWSDTO;

public class OperationManagerWSModel {

    private GeneralWSModel general;
    private OperationManagerWSDTO operationManager;

    public OperationManagerWSModel() {
    }

    public OperationManagerWSModel(GeneralWSModel general, OperationManagerWSDTO operationManager) {
        this.general = general;
        this.operationManager = operationManager;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public OperationManagerWSDTO getOperationManager() {
        return operationManager;
    }

    public void setOperationManager(OperationManagerWSDTO operationManager) {
        this.operationManager = operationManager;
    }
}
