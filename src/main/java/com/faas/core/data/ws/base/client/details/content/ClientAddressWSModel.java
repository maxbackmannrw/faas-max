package com.faas.core.data.ws.base.client.details.content;

import com.faas.core.data.ws.base.client.details.content.dto.ClientAddressWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class ClientAddressWSModel {

    private GeneralWSModel general;
    private List<ClientAddressWSDTO> clientAddresses;

    public ClientAddressWSModel() {
    }

    public ClientAddressWSModel(GeneralWSModel general, List<ClientAddressWSDTO> clientAddresses) {
        this.general = general;
        this.clientAddresses = clientAddresses;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ClientAddressWSDTO> getClientAddresses() {
        return clientAddresses;
    }

    public void setClientAddresses(List<ClientAddressWSDTO> clientAddresses) {
        this.clientAddresses = clientAddresses;
    }
}
