package com.faas.core.data.ws.base.client.content.dto;

import com.faas.core.data.db.client.content.ClientDBModel;

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
