package com.faas.core.base.model.ws.manager.app;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.operation.content.dto.OperationManagerWSDTO;

public class AppManagerOperationWSModel {

    private GeneralWSModel general;
    private OperationManagerWSDTO operationManager;

    public AppManagerOperationWSModel() {
    }

    public AppManagerOperationWSModel(GeneralWSModel general, OperationManagerWSDTO operationManager) {
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
