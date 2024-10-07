package com.faas.core.base.model.ws.client.details.dto;

import com.faas.core.data.db.client.details.dao.ClientPhoneDAO;

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

