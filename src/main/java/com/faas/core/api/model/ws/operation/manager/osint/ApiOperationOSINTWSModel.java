package com.faas.core.api.model.ws.operation.manager.osint;

import com.faas.core.api.model.ws.operation.manager.osint.dto.ApiOperationOSINTWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationOSINTWSModel {

    private GeneralWSModel general;
    private List<ApiOperationOSINTWSDTO> operationOSINTs;

    public ApiOperationOSINTWSModel() {
    }

    public ApiOperationOSINTWSModel(GeneralWSModel general, List<ApiOperationOSINTWSDTO> operationOSINTs) {
        this.general = general;
        this.operationOSINTs = operationOSINTs;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationOSINTWSDTO> getOperationOSINTs() {
        return operationOSINTs;
    }

    public void setOperationOSINTs(List<ApiOperationOSINTWSDTO> operationOSINTs) {
        this.operationOSINTs = operationOSINTs;
    }
}
