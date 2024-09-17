package com.faas.core.base.model.ws.remote.settings.dto;

import com.faas.core.data.db.remote.settings.RemoteTypeDBModel;

public class RemoteTypeWSDTO {

    private RemoteTypeDBModel remoteType;

    public RemoteTypeWSDTO() {
    }

    public RemoteTypeWSDTO(RemoteTypeDBModel remoteType) {
        this.remoteType = remoteType;
    }

    public RemoteTypeDBModel getRemoteType() {
        return remoteType;
    }

    public void setRemoteType(RemoteTypeDBModel remoteType) {
        this.remoteType = remoteType;
    }
}

