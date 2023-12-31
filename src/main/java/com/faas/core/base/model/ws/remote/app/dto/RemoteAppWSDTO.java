package com.faas.core.base.model.ws.remote.app.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.remote.app.RemoteAppDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;

public class RemoteAppWSDTO {

    private ClientDBModel client;
    private SessionDBModel session;
    private RemoteAppDBModel remoteApp;

    public RemoteAppWSDTO() {
    }

    public RemoteAppWSDTO(ClientDBModel client, SessionDBModel session, RemoteAppDBModel remoteApp) {
        this.client = client;
        this.session = session;
        this.remoteApp = remoteApp;
    }

    public ClientDBModel getClient() {
        return client;
    }

    public void setClient(ClientDBModel client) {
        this.client = client;
    }

    public SessionDBModel getSession() {
        return session;
    }

    public void setSession(SessionDBModel session) {
        this.session = session;
    }

    public RemoteAppDBModel getRemoteApp() {
        return remoteApp;
    }

    public void setRemoteApp(RemoteAppDBModel remoteApp) {
        this.remoteApp = remoteApp;
    }
}

