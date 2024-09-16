package com.faas.core.data.ws.base.remote.details.dto;

import com.faas.core.data.db.remote.details.RemoteUrlDBModel;

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

