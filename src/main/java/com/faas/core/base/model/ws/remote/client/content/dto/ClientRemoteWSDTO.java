package com.faas.core.base.model.ws.remote.client.content.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.remote.client.ClientRemoteDBModel;

public class ClientRemoteWSDTO {

    private ClientDBModel client;
    private ClientRemoteDBModel clientRemote;
    private OperationDBModel operation;

    public ClientRemoteWSDTO() {
    }

    public ClientRemoteWSDTO(ClientDBModel client, ClientRemoteDBModel clientRemote, OperationDBModel operation) {
        this.client = client;
        this.clientRemote = clientRemote;
        this.operation = operation;
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

    public OperationDBModel getOperation() {
        return operation;
    }

    public void setOperation(OperationDBModel operation) {
        this.operation = operation;
    }
}

