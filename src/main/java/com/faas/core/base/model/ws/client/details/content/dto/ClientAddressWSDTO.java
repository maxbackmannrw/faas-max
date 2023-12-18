package com.faas.core.base.model.ws.client.details.content.dto;

import com.faas.core.base.model.db.client.details.content.dao.ClientAddressDAO;

public class ClientAddressWSDTO {

    private ClientAddressDAO clientAddress;

    public ClientAddressWSDTO() {
    }

    public ClientAddressWSDTO(ClientAddressDAO clientAddress) {
        this.clientAddress = clientAddress;
    }

    public ClientAddressDAO getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(ClientAddressDAO clientAddress) {
        this.clientAddress = clientAddress;
    }
}
