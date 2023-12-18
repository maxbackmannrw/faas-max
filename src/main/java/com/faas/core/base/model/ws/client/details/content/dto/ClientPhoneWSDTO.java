package com.faas.core.base.model.ws.client.details.content.dto;

import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;

public class ClientPhoneWSDTO {

    private ClientPhoneDAO clientPhone;

    public ClientPhoneWSDTO() {
    }

    public ClientPhoneWSDTO(ClientPhoneDAO clientPhone) {
        this.clientPhone = clientPhone;
    }

    public ClientPhoneDAO getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(ClientPhoneDAO clientPhone) {
        this.clientPhone = clientPhone;
    }
}

