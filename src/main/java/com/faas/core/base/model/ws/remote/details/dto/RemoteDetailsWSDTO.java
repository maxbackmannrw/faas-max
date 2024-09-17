package com.faas.core.base.model.ws.remote.details.dto;

import com.faas.core.data.db.remote.content.RemoteDBModel;

public class RemoteDetailsWSDTO {

    private RemoteDBModel remote;

    public RemoteDetailsWSDTO() {
    }

    public RemoteDetailsWSDTO(RemoteDBModel remote) {
        this.remote = remote;
    }

    public RemoteDBModel getRemote() {
        return remote;
    }

    public void setRemote(RemoteDBModel remote) {
        this.remote = remote;
    }
}

