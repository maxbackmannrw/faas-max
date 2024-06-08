package com.faas.core.base.model.ws.remote.content.dto;

import com.faas.core.base.model.db.utils.UrlDBModel;

public class RemoteUrlWSDTO {

    private UrlDBModel remoteUrl;

    public RemoteUrlWSDTO() {
    }

    public RemoteUrlWSDTO(UrlDBModel remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public UrlDBModel getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(UrlDBModel remoteUrl) {
        this.remoteUrl = remoteUrl;
    }
}

