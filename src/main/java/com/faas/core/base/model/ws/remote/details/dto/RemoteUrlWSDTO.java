package com.faas.core.base.model.ws.remote.details.dto;

import com.faas.core.base.model.db.remote.details.RemoteUrlDBModel;

public class RemoteUrlWSDTO {

    private RemoteUrlDBModel remoteUrl;

    public RemoteUrlWSDTO() {
    }

    public RemoteUrlWSDTO(RemoteUrlDBModel remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public RemoteUrlDBModel getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(RemoteUrlDBModel remoteUrl) {
        this.remoteUrl = remoteUrl;
    }
}

