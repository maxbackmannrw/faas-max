package com.faas.core.api.model.ws.client.details;

import com.faas.core.api.model.ws.client.details.dto.ApiClientDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiClientDetailsWSModel {

    private GeneralWSModel general;
    private ApiClientDetailsWSDTO clientDetails;

    public ApiClientDetailsWSModel() {
    }

    public ApiClientDetailsWSModel(GeneralWSModel general, ApiClientDetailsWSDTO clientDetails) {
        this.general = general;
        this.clientDetails = clientDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiClientDetailsWSDTO getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(ApiClientDetailsWSDTO clientDetails) {
        this.clientDetails = clientDetails;
    }
}
