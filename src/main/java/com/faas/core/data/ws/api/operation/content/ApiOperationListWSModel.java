package com.faas.core.data.ws.api.operation.content;

import com.faas.core.data.ws.api.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

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
