package com.faas.core.base.model.ws.remote.content.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.remote.RemoteDBModel;

public class RemoteWSDTO {

    private ClientDBModel client;
    private RemoteDBModel clientRemote;

    public RemoteWSDTO() {
    }

    public RemoteWSDTO(ClientDBModel client, RemoteDBModel clientRemote) {
        this.client = client;
        this.clientRemote = clientRemote;
    }

    public ClientDBModel getClient() {
        return client;
    }

    public void setClient(ClientDBModel client) {
        this.client = client;
    }

    public RemoteDBModel getClientRemote() {
        return clientRemote;
    }

    public void setClientRemote(RemoteDBModel clientRemote) {
        this.clientRemote = clientRemote;
    }
}

