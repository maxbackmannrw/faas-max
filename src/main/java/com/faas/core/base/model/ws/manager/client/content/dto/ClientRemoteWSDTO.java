package com.faas.core.base.model.ws.manager.client.content.dto;

import com.faas.core.base.model.db.client.details.ClientRemoteDBModel;

public class ClientRemoteWSDTO {

    private ClientRemoteDBModel clientRemote;

    public ClientRemoteWSDTO() {
    }

    public ClientRemoteWSDTO(ClientRemoteDBModel clientRemote) {
        this.clientRemote = clientRemote;
    }

    public ClientRemoteDBModel getClientRemote() {
        return clientRemote;
    }

    public void setClientRemote(ClientRemoteDBModel clientRemote) {
        this.clientRemote = clientRemote;
    }
}

