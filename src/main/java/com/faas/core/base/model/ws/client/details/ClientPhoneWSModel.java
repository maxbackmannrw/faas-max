package com.faas.core.base.model.ws.client.details;

import com.faas.core.base.model.ws.client.details.dto.ClientPhoneWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

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
