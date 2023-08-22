package com.faas.core.base.model.ws.client.content.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;

public class ClientWSDTO {

    private ClientDBModel client;

    public ClientWSDTO() {
    }

    public ClientWSDTO(ClientDBModel client) {
        this.client = client;
    }

    public ClientDBModel getClient() {
        return client;
    }

    public void setClient(ClientDBModel client) {
        this.client = client;
    }
}
