package com.faas.core.api.model.ws.client.details;

import com.faas.core.api.model.ws.client.details.dto.ApiClientOsIntWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiClientOsIntWSModel {

    private GeneralWSModel general;
    private List<ApiClientOsIntWSDTO> clientOsInts;

    public ApiClientOsIntWSModel() {
    }

    public ApiClientOsIntWSModel(GeneralWSModel general, List<ApiClientOsIntWSDTO> clientOsInts) {
        this.general = general;
        this.clientOsInts = clientOsInts;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiClientOsIntWSDTO> getClientOsInts() {
        return clientOsInts;
    }

    public void setClientOsInts(List<ApiClientOsIntWSDTO> clientOsInts) {
        this.clientOsInts = clientOsInts;
    }
}
