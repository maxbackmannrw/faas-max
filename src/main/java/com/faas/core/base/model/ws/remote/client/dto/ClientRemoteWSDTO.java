package com.faas.core.base.model.ws.remote.client.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.remote.client.ClientRemoteDBModel;

public class ClientRemoteWSDTO {

    private ClientDBModel client;
    private ClientRemoteDBModel clientRemote;

    public ClientRemoteWSDTO() {
    }

    public ClientRemoteWSDTO(ClientDBModel client, ClientRemoteDBModel clientRemote) {
        this.client = client;
        this.clientRemote = clientRemote;
    }

    public ClientDBModel getClient() {
        return client;
    }

    public void setClient(ClientDBModel client) {
        this.client = client;
    }

    public ClientRemoteDBModel getClientRemote() {
        return clientRemote;
    }

    public void setClientRemote(ClientRemoteDBModel clientRemote) {
        this.clientRemote = clientRemote;
    }
}

