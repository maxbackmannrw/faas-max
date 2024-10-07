package com.faas.core.base.model.ws.client.details.dto;

import com.faas.core.data.db.client.intel.ClientIntelDBModel;

public class ClientIntelWSDTO {

    private ClientIntelDBModel clientIntel;

    public ClientIntelWSDTO() {
    }

    public ClientIntelWSDTO(ClientIntelDBModel clientIntel) {
        this.clientIntel = clientIntel;
    }

    public ClientIntelDBModel getClientIntel() {
        return clientIntel;
    }

    public void setClientIntel(ClientIntelDBModel clientIntel) {
        this.clientIntel = clientIntel;
    }
}

