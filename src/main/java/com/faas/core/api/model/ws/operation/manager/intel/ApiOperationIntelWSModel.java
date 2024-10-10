package com.faas.core.api.model.ws.operation.manager.intel;

import com.faas.core.api.model.ws.operation.manager.intel.dto.ApiOperationIntelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationIntelWSModel {

    private GeneralWSModel general;
    private List<ApiOperationIntelWSDTO> operationIntels;

    public ApiOperationIntelWSModel() {
    }

    public ApiOperationIntelWSModel(GeneralWSModel general, List<ApiOperationIntelWSDTO> operationIntels) {
        this.general = general;
        this.operationIntels = operationIntels;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationIntelWSDTO> getOperationIntels() {
        return operationIntels;
    }

    public void setOperationIntels(List<ApiOperationIntelWSDTO> operationIntels) {
        this.operationIntels = operationIntels;
    }
}
