package com.faas.core.base.model.ws.client.details.dto;

import com.faas.core.data.db.client.details.dao.ClientEmailDAO;

public class ClientEmailWSDTO {

    private ClientEmailDAO clientEmail;

    public ClientEmailWSDTO() {
    }

    public ClientEmailWSDTO(ClientEmailDAO clientEmail) {
        this.clientEmail = clientEmail;
    }

    public ClientEmailDAO getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(ClientEmailDAO clientEmail) {
        this.clientEmail = clientEmail;
    }
}
