package com.faas.core.data.ws.api.operation.details.remote.dto;

import com.faas.core.data.db.remoteapp.RemoteAppDBModel;

public class ApiOperationClientRemoteWSDTO {

    private RemoteAppDBModel clientRemote;

    public ApiOperationClientRemoteWSDTO() {
    }

    public ApiOperationClientRemoteWSDTO(RemoteAppDBModel clientRemote) {
        this.clientRemote = clientRemote;
    }

    public RemoteAppDBModel getClientRemote() {
        return clientRemote;
    }

    public void setClientRemote(RemoteAppDBModel clientRemote) {
        this.clientRemote = clientRemote;
    }
}
