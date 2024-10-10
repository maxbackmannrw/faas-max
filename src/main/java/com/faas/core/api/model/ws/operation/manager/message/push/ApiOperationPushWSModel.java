package com.faas.core.api.model.ws.operation.manager.message.push;

import com.faas.core.api.model.ws.operation.manager.message.push.dto.ApiOperationPushWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationPushWSModel {

    private GeneralWSModel general;
    private List<ApiOperationPushWSDTO> operationPushes;

    public ApiOperationPushWSModel() {
    }

    public ApiOperationPushWSModel(GeneralWSModel general, List<ApiOperationPushWSDTO> operationPushes) {
        this.general = general;
        this.operationPushes = operationPushes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationPushWSDTO> getOperationPushes() {
        return operationPushes;
    }

    public void setOperationPushes(List<ApiOperationPushWSDTO> operationPushes) {
        this.operationPushes = operationPushes;
    }
}
