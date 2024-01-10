package com.faas.core.api.model.ws.client.content.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.content.ClientDetailsDBModel;

public class ApiClientWSDTO {

    private ClientDBModel client;
    private ClientDetailsDBModel clientDetails;

    public ApiClientWSDTO() {
    }

    public ApiClientWSDTO(ClientDBModel client, ClientDetailsDBModel clientDetails) {
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
