package com.faas.core.base.model.ws.client.remote.content.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.remote.ClientRemoteDBModel;

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

