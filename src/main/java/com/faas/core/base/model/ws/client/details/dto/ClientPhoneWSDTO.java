package com.faas.core.base.model.ws.client.details.dto;

import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;

public class ClientPhoneWSDTO {

    private ClientPhoneDBModel clientPhone;

    public ClientPhoneWSDTO() {
    }

    public ClientPhoneWSDTO(ClientPhoneDBModel clientPhone) {
        this.clientPhone = clientPhone;
    }

    public ClientPhoneDBModel getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(ClientPhoneDBModel clientPhone) {
        this.clientPhone = clientPhone;
    }
}

