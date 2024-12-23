package com.faas.core.api.model.ws.operation.manager.details.dto;

import com.faas.core.data.db.client.content.ClientDBModel;
import com.faas.core.data.db.client.details.ClientDetailsDBModel;

public class ApiOperationDetailsWSDTO {

    private ClientDBModel client;
    private ClientDetailsDBModel clientDetails;

    public ApiOperationDetailsWSDTO() {
    }

    public ApiOperationDetailsWSDTO(ClientDBModel client, ClientDetailsDBModel clientDetails) {
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
