package com.faas.core.base.model.ws.client.details.content.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.ClientDetailsDBModel;


public class ClientDetailsWSDTO {

    private ClientDBModel client;
    private ClientDetailsDBModel clientDetails;

    public ClientDetailsWSDTO() {
    }

    public ClientDetailsWSDTO(ClientDBModel client, ClientDetailsDBModel clientDetails) {
        this.client = client;
        this.clientDetails = clientDetails;
    }

    public ClientDBModel getClient() {
        return client;
    }

    public void setClient(ClientDBModel client) {
        this.client = client;
    }

    public ClientDetailsDBModel getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(ClientDetailsDBModel clientDetails) {
        this.clientDetails = clientDetails;
    }
}
