package com.faas.core.api.model.ws.client.details;

import com.faas.core.api.model.ws.client.details.dto.ApiClientOSINTWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiClientOSINTWSModel {

    private GeneralWSModel general;
    private List<ApiClientOSINTWSDTO> clientOSINTs;

    public ApiClientOSINTWSModel() {
    }

    public ApiClientOSINTWSModel(GeneralWSModel general, List<ApiClientOSINTWSDTO> clientOSINTs) {
        this.general = general;
        this.clientOSINTs = clientOSINTs;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiClientOSINTWSDTO> getClientOSINTs() {
        return clientOSINTs;
    }

    public void setClientOSINTs(List<ApiClientOSINTWSDTO> clientOSINTs) {
        this.clientOSINTs = clientOSINTs;
    }
}
