package com.faas.core.api.model.ws.client.content;

import com.faas.core.api.model.ws.client.content.dto.ApiClientWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiClientWSModel {

    private GeneralWSModel general;
    private ApiClientWSDTO client;

    public ApiClientWSModel() {
    }

    public ApiClientWSModel(GeneralWSModel general, ApiClientWSDTO client) {
        this.general = general;
        this.client = client;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiClientWSDTO getClient() {
        return client;
    }

    public void setClient(ApiClientWSDTO client) {
        this.client = client;
    }
}
