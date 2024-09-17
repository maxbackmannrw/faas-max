package com.faas.core.base.model.ws.client.settings.dto;

import com.faas.core.data.db.client.settings.ClientTypeDBModel;

public class ClientTypeWSDTO {

    private ClientTypeDBModel clientType;

    public ClientTypeWSDTO() {
    }

    public ClientTypeWSDTO(ClientTypeDBModel clientType) {
        this.clientType = clientType;
    }

    public ClientTypeDBModel getClientType() {
        return clientType;
    }

    public void setClientType(ClientTypeDBModel clientType) {
        this.clientType = clientType;
    }
}
