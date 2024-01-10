package com.faas.core.api.model.ws.client.details.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;

public class ApiClientOSINTWSDTO {

    private ClientDBModel client;

    public ApiClientOSINTWSDTO() {
    }

    public ApiClientOSINTWSDTO(ClientDBModel client) {
        this.client = client;
    }

    public ClientDBModel getClient() {
        return client;
    }

    public void setClient(ClientDBModel client) {
        this.client = client;
    }
}
