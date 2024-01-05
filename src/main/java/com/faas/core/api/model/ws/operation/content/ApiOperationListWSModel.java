package com.faas.core.api.model.ws.operation.content;

import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationListWSModel {

    private GeneralWSModel general;
    private ApiOperationListWSDTO operationList;

    public ApiOperationListWSModel() {
    }

    public ApiOperationListWSModel(GeneralWSModel general, ApiOperationListWSDTO operationList) {
        this.general = general;
        this.operationList = operationList;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationListWSDTO getOperationList() {
        return operationList;
    }

    public void setOperationList(ApiOperationListWSDTO operationList) {
        this.operationList = operationList;
    }
}
