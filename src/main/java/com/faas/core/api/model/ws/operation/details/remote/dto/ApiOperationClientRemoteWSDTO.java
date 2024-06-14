package com.faas.core.api.model.ws.operation.details.remote.dto;

import com.faas.core.base.model.db.remote.client.RemoteClientDBModel;

public class ApiOperationClientRemoteWSDTO {

    private RemoteClientDBModel clientRemote;

    public ApiOperationClientRemoteWSDTO() {
    }

    public ApiOperationClientRemoteWSDTO(RemoteClientDBModel clientRemote) {
        this.clientRemote = clientRemote;
    }

    public RemoteClientDBModel getClientRemote() {
        return clientRemote;
    }

    public void setClientRemote(RemoteClientDBModel clientRemote) {
        this.clientRemote = clientRemote;
    }
}
