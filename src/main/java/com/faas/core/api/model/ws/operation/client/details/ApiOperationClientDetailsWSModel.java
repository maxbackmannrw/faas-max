package com.faas.core.api.model.ws.operation.client.details;

import com.faas.core.api.model.ws.operation.client.details.dto.ApiOperationClientDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationClientDetailsWSModel {

    private GeneralWSModel general;
    private ApiOperationClientDetailsWSDTO clientDetails;

    public ApiOperationClientDetailsWSModel() {
    }

    public ApiOperationClientDetailsWSModel(GeneralWSModel general, ApiOperationClientDetailsWSDTO clientDetails) {
        this.general = general;
        this.clientDetails = clientDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationClientDetailsWSDTO getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(ApiOperationClientDetailsWSDTO clientDetails) {
        this.clientDetails = clientDetails;
    }
}
