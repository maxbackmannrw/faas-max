package com.faas.core.base.model.ws.client.details.dto;

import com.faas.core.base.model.db.client.details.ClientAddressDBModel;

public class ClientAddressWSDTO {

    private ClientAddressDBModel clientAddress;

    public ClientAddressWSDTO() {
    }

    public ClientAddressWSDTO(ClientAddressDBModel clientAddress) {
        this.clientAddress = clientAddress;
    }

    public ClientAddressDBModel getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(ClientAddressDBModel clientAddress) {
        this.clientAddress = clientAddress;
    }
}
