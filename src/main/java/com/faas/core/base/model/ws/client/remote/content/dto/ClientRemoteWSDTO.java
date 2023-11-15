package com.faas.core.base.model.ws.client.remote.content.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.remote.ClientRemoteDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;


public class ClientRemoteWSDTO {

    private ClientDBModel client;
    private SessionDBModel clientSession;
    private ClientRemoteDBModel clientRemote;

    public ClientRemoteWSDTO() {
    }

    public ClientRemoteWSDTO(ClientDBModel client, SessionDBModel clientSession, ClientRemoteDBModel clientRemote) {
        this.client = client;
        this.clientSession = clientSession;
        this.clientRemote = clientRemote;
    }

    public ClientDBModel getClient() {
        return client;
    }

    public void setClient(ClientDBModel client) {
        this.client = client;
    }

    public SessionDBModel getClientSession() {
        return clientSession;
    }

    public void setClientSession(SessionDBModel clientSession) {
        this.clientSession = clientSession;
    }

    public ClientRemoteDBModel getClientRemote() {
        return clientRemote;
    }

    public void setClientRemote(ClientRemoteDBModel clientRemote) {
        this.clientRemote = clientRemote;
    }
}

