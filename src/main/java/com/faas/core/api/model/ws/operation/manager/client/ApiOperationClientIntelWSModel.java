package com.faas.core.api.model.ws.operation.manager.client;

import com.faas.core.api.model.ws.operation.manager.client.dto.ApiOperationClientIntelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationClientIntelWSModel {

    private GeneralWSModel general;
    private List<ApiOperationClientIntelWSDTO> operationClientIntels;

    public ApiOperationClientIntelWSModel() {
    }

    public ApiOperationClientIntelWSModel(GeneralWSModel general, List<ApiOperationClientIntelWSDTO> operationClientIntels) {
        this.general = general;
        this.operationClientIntels = operationClientIntels;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationClientIntelWSDTO> getOperationClientIntels() {
        return operationClientIntels;
    }

    public void setOperationClientIntels(List<ApiOperationClientIntelWSDTO> operationClientIntels) {
        this.operationClientIntels = operationClientIntels;
    }
}
