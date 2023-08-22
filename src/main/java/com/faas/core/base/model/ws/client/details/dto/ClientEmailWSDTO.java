package com.faas.core.base.model.ws.client.details.dto;

import com.faas.core.base.model.db.client.details.ClientEmailDBModel;

public class ClientEmailWSDTO {

    private ClientEmailDBModel clientEmail;

    public ClientEmailWSDTO() {
    }

    public ClientEmailWSDTO(ClientEmailDBModel clientEmail) {
        this.clientEmail = clientEmail;
    }

    public ClientEmailDBModel getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(ClientEmailDBModel clientEmail) {
        this.clientEmail = clientEmail;
    }
}
