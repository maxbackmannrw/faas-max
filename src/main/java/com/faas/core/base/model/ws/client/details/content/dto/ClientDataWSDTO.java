package com.faas.core.base.model.ws.client.details.content.dto;

import com.faas.core.base.model.db.client.details.content.dao.ClientDataDAO;

public class ClientDataWSDTO {

    private ClientDataDAO clientData;

    public ClientDataWSDTO() {
    }

    public ClientDataWSDTO(ClientDataDAO clientData) {
        this.clientData = clientData;
    }

    public ClientDataDAO getClientData() {
        return clientData;
    }

    public void setClientData(ClientDataDAO clientData) {
        this.clientData = clientData;
    }
}
