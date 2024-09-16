package com.faas.core.data.ws.base.client.details.content;

import com.faas.core.data.ws.base.client.details.content.dto.ClientPhoneWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class ClientPhoneWSModel {

    private GeneralWSModel general;
    private List<ClientPhoneWSDTO> clientPhones;

    public ClientPhoneWSModel() {
    }

    public ClientPhoneWSModel(GeneralWSModel general, List<ClientPhoneWSDTO> clientPhones) {
        this.general = general;
        this.clientPhones = clientPhones;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ClientPhoneWSDTO> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientPhoneWSDTO> clientPhones) {
        this.clientPhones = clientPhones;
    }
}
