package com.faas.core.api.model.ws.operation.manager.client;

import com.faas.core.api.model.ws.operation.manager.client.dto.ApiOperationClientOSINTWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationClientOSINTWSModel {

    private GeneralWSModel general;
    private List<ApiOperationClientOSINTWSDTO> clientOSINTs;

    public ApiOperationClientOSINTWSModel() {
    }

    public ApiOperationClientOSINTWSModel(GeneralWSModel general, List<ApiOperationClientOSINTWSDTO> clientOSINTs) {
        this.general = general;
        this.clientOSINTs = clientOSINTs;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationClientOSINTWSDTO> getClientOSINTs() {
        return clientOSINTs;
    }

    public void setClientOSINTs(List<ApiOperationClientOSINTWSDTO> clientOSINTs) {
        this.clientOSINTs = clientOSINTs;
    }
}
