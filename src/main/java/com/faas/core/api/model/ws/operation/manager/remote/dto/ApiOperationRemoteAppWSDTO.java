package com.faas.core.api.model.ws.operation.manager.remote.dto;

import com.faas.core.data.db.remoteapp.RemoteAppDBModel;

public class ApiOperationRemoteAppWSDTO {

    private RemoteAppDBModel remoteAppDBModel;

    public ApiOperationRemoteAppWSDTO() {
    }

    public ApiOperationRemoteAppWSDTO(RemoteAppDBModel remoteAppDBModel) {
        this.remoteAppDBModel = remoteAppDBModel;
    }

    public RemoteAppDBModel getRemoteAppDBModel() {
        return remoteAppDBModel;
    }

    public void setRemoteAppDBModel(RemoteAppDBModel remoteAppDBModel) {
        this.remoteAppDBModel = remoteAppDBModel;
    }
}
