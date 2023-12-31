package com.faas.core.base.model.ws.remote.content.dto;

import com.faas.core.base.model.db.remote.content.dao.RemoteUrlDAO;

public class RemoteUrlWSDTO {

    private RemoteUrlDAO remoteUrl;

    public RemoteUrlWSDTO() {
    }

    public RemoteUrlWSDTO(RemoteUrlDAO remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public RemoteUrlDAO getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(RemoteUrlDAO remoteUrl) {
        this.remoteUrl = remoteUrl;
    }
}

