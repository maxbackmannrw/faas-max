package com.faas.core.api.model.ws.operation.manager.client.dto;

import com.faas.core.data.db.client.content.ClientDBModel;
import com.faas.core.data.db.client.details.ClientDetailsDBModel;
import com.faas.core.data.db.client.intel.ClientIntelDBModel;

import java.util.List;

public class ApiOperationClientWSDTO {

    private ClientDBModel client;
    private ClientDetailsDBModel clientDetails;
    private List<ClientIntelDBModel> clientIntels;

    public ApiOperationClientWSDTO() {
    }

    public ApiOperationClientWSDTO(ClientDBModel client, ClientDetailsDBModel clientDetails, List<ClientIntelDBModel> clientIntels) {
        this.client = client;
        this.clientDetails = clientDetails;
        this.clientIntels = clientIntels;
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

    public List<ClientIntelDBModel> getClientIntels() {
        return clientIntels;
    }

    public void setClientIntels(List<ClientIntelDBModel> clientIntels) {
        this.clientIntels = clientIntels;
    }
}
