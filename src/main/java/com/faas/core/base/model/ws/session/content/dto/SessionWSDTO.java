package com.faas.core.base.model.ws.session.content.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;


public class SessionWSDTO {

    private SessionDBModel session;
    private ClientDBModel client;

    public SessionWSDTO() {
    }

    public SessionWSDTO(SessionDBModel session, ClientDBModel client) {
        this.session = session;
        this.client = client;
    }

    public SessionDBModel getSession() {
        return session;
    }

    public void setSession(SessionDBModel session) {
        this.session = session;
    }

    public ClientDBModel getClient() {
        return client;
    }

    public void setClient(ClientDBModel client) {
        this.client = client;
    }
}
