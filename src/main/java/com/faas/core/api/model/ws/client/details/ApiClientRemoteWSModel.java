package com.faas.core.api.model.ws.client.details;

import com.faas.core.api.model.ws.client.details.dto.ApiClientRemoteWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiClientRemoteWSModel {

    private GeneralWSModel general;
    private List<ApiClientRemoteWSDTO> clientRemotes;

    public ApiClientRemoteWSModel() {
    }

    public ApiClientRemoteWSModel(GeneralWSModel general, List<ApiClientRemoteWSDTO> clientRemotes) {
        this.general = general;
        this.clientRemotes = clientRemotes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiClientRemoteWSDTO> getClientRemotes() {
        return clientRemotes;
    }

    public void setClientRemotes(List<ApiClientRemoteWSDTO> clientRemotes) {
        this.clientRemotes = clientRemotes;
    }
}
