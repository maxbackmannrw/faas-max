package com.faas.core.base.model.ws.manager.manual;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.manual.dto.ManualOperationListWSDTO;

public class ManualOperationListWSModel {

    private GeneralWSModel general;
    private ManualOperationListWSDTO operationList;

    public ManualOperationListWSModel() {
    }

    public ManualOperationListWSModel(GeneralWSModel general, ManualOperationListWSDTO operationList) {
        this.general = general;
        this.operationList = operationList;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ManualOperationListWSDTO getOperationList() {
        return operationList;
    }

    public void setOperationList(ManualOperationListWSDTO operationList) {
        this.operationList = operationList;
    }
}
