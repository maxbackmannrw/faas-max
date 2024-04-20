package com.faas.core.base.model.ws.remote.content.dto;

import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.utility.UrlDBModel;

import java.util.List;

public class RemoteWSDTO {

    private RemoteDBModel remote;
    private List<UrlDBModel> remoteUrls;

    public RemoteWSDTO() {
    }

    public RemoteWSDTO(RemoteDBModel remote, List<UrlDBModel> remoteUrls) {
        this.remote = remote;
        this.remoteUrls = remoteUrls;
    }

    public RemoteDBModel getRemote() {
        return remote;
    }

    public void setRemote(RemoteDBModel remote) {
        this.remote = remote;
    }

    public List<UrlDBModel> getRemoteUrls() {
        return remoteUrls;
    }

    public void setRemoteUrls(List<UrlDBModel> remoteUrls) {
        this.remoteUrls = remoteUrls;
    }
}

