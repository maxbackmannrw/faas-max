package com.faas.core.base.model.ws.remote.content.dto;

import com.faas.core.base.model.db.remote.content.RemoteDBModel;

public class RemoteWSDTO {

    private RemoteDBModel remote;

    public RemoteWSDTO() {
    }

    public RemoteWSDTO(RemoteDBModel remote) {
        this.remote = remote;
    }

    public RemoteDBModel getRemote() {
        return remote;
    }

    public void setRemote(RemoteDBModel remote) {
        this.remote = remote;
    }
}

