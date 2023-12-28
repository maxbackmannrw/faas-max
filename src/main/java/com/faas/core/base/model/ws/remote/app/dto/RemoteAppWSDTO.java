package com.faas.core.base.model.ws.remote.app.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.remote.app.RemoteAppDBModel;

public class RemoteAppWSDTO {

    private ClientDBModel client;
    private RemoteAppDBModel clientRemote;

    public RemoteAppWSDTO() {
    }

    public RemoteAppWSDTO(ClientDBModel client, RemoteAppDBModel clientRemote) {
        this.client = client;
        this.clientRemote = clientRemote;
    }

    public ClientDBModel getClient() {
        return client;
    }

    public void setClient(ClientDBModel client) {
        this.client = client;
    }

    public RemoteAppDBModel getClientRemote() {
        return clientRemote;
    }

    public void setClientRemote(RemoteAppDBModel clientRemote) {
        this.clientRemote = clientRemote;
    }
}

