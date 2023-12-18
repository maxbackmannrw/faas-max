package com.faas.core.base.model.ws.client.details.content.dto;

import com.faas.core.base.model.db.client.details.content.dao.ClientEmailDAO;

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
