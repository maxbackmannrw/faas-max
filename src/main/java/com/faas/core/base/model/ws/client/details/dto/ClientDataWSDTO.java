package com.faas.core.base.model.ws.client.details.dto;

import com.faas.core.base.model.db.client.details.ClientDataDBModel;

public class ClientDataWSDTO {

    private ClientDataDBModel clientData;

    public ClientDataWSDTO() {
    }

    public ClientDataWSDTO(ClientDataDBModel clientData) {
        this.clientData = clientData;
    }

    public ClientDataDBModel getClientData() {
        return clientData;
    }

    public void setClientData(ClientDataDBModel clientData) {
        this.clientData = clientData;
    }
}
