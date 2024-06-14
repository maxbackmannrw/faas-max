package com.faas.core.base.model.ws.remote.client.content.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.remote.client.RemoteClientDBModel;

public class RemoteClientWSDTO {

    private ClientDBModel client;
    private RemoteClientDBModel remoteClient;
    private OperationDBModel operation;

    public RemoteClientWSDTO() {
    }

    public RemoteClientWSDTO(ClientDBModel client, RemoteClientDBModel remoteClient, OperationDBModel operation) {
        this.client = client;
        this.remoteClient = remoteClient;
        this.operation = operation;
    }

    public ClientDBModel getClient() {
        return client;
    }

    public void setClient(ClientDBModel client) {
        this.client = client;
    }

    public RemoteClientDBModel getRemoteClient() {
        return remoteClient;
    }

    public void setRemoteClient(RemoteClientDBModel remoteClient) {
        this.remoteClient = remoteClient;
    }

    public OperationDBModel getOperation() {
        return operation;
    }

    public void setOperation(OperationDBModel operation) {
        this.operation = operation;
    }
}

