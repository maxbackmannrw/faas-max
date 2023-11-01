package com.faas.core.base.model.ws.operation.automatic;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.automatic.dto.AutomaticOperationListWSDTO;

public class AutomaticOperationListWSModel {

    private GeneralWSModel general;
    private AutomaticOperationListWSDTO operationList;

    public AutomaticOperationListWSModel() {
    }

    public AutomaticOperationListWSModel(GeneralWSModel general, AutomaticOperationListWSDTO operationList) {
        this.general = general;
        this.operationList = operationList;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public AutomaticOperationListWSDTO getOperationList() {
        return operationList;
    }

    public void setOperationList(AutomaticOperationListWSDTO operationList) {
        this.operationList = operationList;
    }
}
