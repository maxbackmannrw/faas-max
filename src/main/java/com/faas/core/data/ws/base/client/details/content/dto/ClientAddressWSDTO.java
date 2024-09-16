package com.faas.core.data.ws.base.client.details.content.dto;

import com.faas.core.data.db.client.details.dao.ClientAddressDAO;

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
