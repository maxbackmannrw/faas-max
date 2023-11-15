package com.faas.core.base.model.ws.client.remote.content.dto;

import com.faas.core.base.model.db.client.remote.ClientRemoteDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;


public class ClientRemoteWSDTO {

    private SessionDBModel clientSession;
    private ClientRemoteDBModel clientRemote;

    public ClientRemoteWSDTO() {
    }

    public ClientRemoteWSDTO(SessionDBModel clientSession, ClientRemoteDBModel clientRemote) {
        this.clientSession = clientSession;
        this.clientRemote = clientRemote;
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

