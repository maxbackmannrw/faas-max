package com.faas.core.base.model.ws.remote.content.dto;

import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.remote.details.RemoteUrlDBModel;

import java.util.List;

public class RemoteWSDTO {

    private RemoteDBModel remote;
    private List<RemoteUrlDBModel> remoteUrls;

    public RemoteWSDTO() {
    }

    public RemoteWSDTO(RemoteDBModel remote, List<RemoteUrlDBModel> remoteUrls) {
        this.remote = remote;
        this.remoteUrls = remoteUrls;
    }

    public RemoteDBModel getRemote() {
        return remote;
    }

    public void setRemote(RemoteDBModel remote) {
        this.remote = remote;
    }

    public List<RemoteUrlDBModel> getRemoteUrls() {
        return remoteUrls;
    }

    public void setRemoteUrls(List<RemoteUrlDBModel> remoteUrls) {
        this.remoteUrls = remoteUrls;
    }
}

