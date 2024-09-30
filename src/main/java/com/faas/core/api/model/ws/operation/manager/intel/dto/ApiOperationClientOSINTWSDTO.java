package com.faas.core.api.model.ws.operation.manager.intel.dto;

import com.faas.core.data.db.client.content.ClientDBModel;

public class ApiOperationClientOSINTWSDTO {

    private ClientDBModel client;

    public ApiOperationClientOSINTWSDTO() {
    }

    public ApiOperationClientOSINTWSDTO(ClientDBModel client) {
        this.client = client;
    }

    public ClientDBModel getClient() {
        return client;
    }

    public void setClient(ClientDBModel client) {
        this.client = client;
    }
}
