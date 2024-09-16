package com.faas.core.data.ws.api.operation.client.details;

import com.faas.core.data.ws.api.operation.client.details.dto.ApiOperationClientOSINTWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

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
