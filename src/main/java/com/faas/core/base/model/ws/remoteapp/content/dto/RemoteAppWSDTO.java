package com.faas.core.base.model.ws.remoteapp.content.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.remoteapp.RemoteAppDBModel;

public class RemoteAppWSDTO {

    private ClientDBModel client;
    private RemoteAppDBModel remoteApp;
    private OperationDBModel operation;

    public RemoteAppWSDTO() {
    }

    public RemoteAppWSDTO(ClientDBModel client, RemoteAppDBModel remoteApp, OperationDBModel operation) {
        this.client = client;
        this.remoteApp = remoteApp;
        this.operation = operation;
    }

    public ClientDBModel getClient() {
        return client;
    }

    public void setClient(ClientDBModel client) {
        this.client = client;
    }

    public RemoteAppDBModel getRemoteApp() {
        return remoteApp;
    }

    public void setRemoteApp(RemoteAppDBModel remoteApp) {
        this.remoteApp = remoteApp;
    }

    public OperationDBModel getOperation() {
        return operation;
    }

    public void setOperation(OperationDBModel operation) {
        this.operation = operation;
    }
}

