package com.faas.core.api.model.ws.operation.details.client;

import com.faas.core.api.model.ws.operation.details.client.dto.ApiOperationClientRemoteWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationClientRemoteWSModel {

    private GeneralWSModel general;
    private List<ApiOperationClientRemoteWSDTO> clientRemotes;

    public ApiOperationClientRemoteWSModel() {
    }

    public ApiOperationClientRemoteWSModel(GeneralWSModel general, List<ApiOperationClientRemoteWSDTO> clientRemotes) {
        this.general = general;
        this.clientRemotes = clientRemotes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationClientRemoteWSDTO> getClientRemotes() {
        return clientRemotes;
    }

    public void setClientRemotes(List<ApiOperationClientRemoteWSDTO> clientRemotes) {
        this.clientRemotes = clientRemotes;
    }
}
