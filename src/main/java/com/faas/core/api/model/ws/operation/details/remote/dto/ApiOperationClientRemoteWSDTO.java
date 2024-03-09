package com.faas.core.api.model.ws.operation.details.remote.dto;

import com.faas.core.base.model.db.remote.client.ClientRemoteDBModel;

public class ApiOperationClientRemoteWSDTO {

    private ClientRemoteDBModel clientRemote;

    public ApiOperationClientRemoteWSDTO() {
    }

    public ApiOperationClientRemoteWSDTO(ClientRemoteDBModel clientRemote) {
        this.clientRemote = clientRemote;
    }

    public ClientRemoteDBModel getClientRemote() {
        return clientRemote;
    }

    public void setClientRemote(ClientRemoteDBModel clientRemote) {
        this.clientRemote = clientRemote;
    }
}
