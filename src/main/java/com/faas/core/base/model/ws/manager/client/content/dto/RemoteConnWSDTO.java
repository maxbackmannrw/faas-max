package com.faas.core.base.model.ws.manager.client.content.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.RemoteConnDBModel;


public class RemoteConnWSDTO {

    private ClientDBModel client;
    private RemoteConnDBModel remoteConn;

    public RemoteConnWSDTO() {
    }

    public RemoteConnWSDTO(ClientDBModel client, RemoteConnDBModel remoteConn) {
        this.client = client;
        this.remoteConn = remoteConn;
    }

    public ClientDBModel getClient() {
        return client;
    }

    public void setClient(ClientDBModel client) {
        this.client = client;
    }

    public RemoteConnDBModel getRemoteConn() {
        return remoteConn;
    }

    public void setRemoteConn(RemoteConnDBModel remoteConn) {
        this.remoteConn = remoteConn;
    }
}

